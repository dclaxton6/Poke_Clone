import java.util.Random;
import java.util.Scanner;


public class fight {
	public static int capture = 0;
	
	public static void battle(character currentCharacter, int move, enemy currentEnemy){
		if(currentCharacter.getSpd() > currentEnemy.getSpd()){
			cAttack(currentCharacter, move, currentEnemy);
			if(currentEnemy.getCurrentHp() > 0){
				eAttack(currentCharacter, currentEnemy);
			}
		} else if(currentCharacter.getSpd() < currentEnemy.getSpd()){
			eAttack(currentCharacter, currentEnemy);
			if(currentCharacter.getCurrentHp() > 0){
				cAttack(currentCharacter, move, currentEnemy);
			}
		} else if(currentCharacter.getSpd() == currentEnemy.getSpd()){
			Random rNum = new Random();
			int r = rNum.nextInt(2);
			switch(r){
				case 0:{
					cAttack(currentCharacter, move, currentEnemy);
					if(currentEnemy.getCurrentHp() > 0){
						eAttack(currentCharacter, currentEnemy);
					}
					break;
				}
				case 1:{
					eAttack(currentCharacter, currentEnemy);
					if(currentCharacter.getCurrentHp() > 0){
						cAttack(currentCharacter, move, currentEnemy);
					}
					break;
				}
			}
		}
    }
    public static void cAttack(character currentCharacter, int move, enemy currentEnemy){
        String moveName = currentCharacter.moveset.get(move).getMoveName();
        double pwr = currentCharacter.moveset.get(move).getPower();
		double atk = currentCharacter.getAtk();
		double def = currentEnemy.getDef();
        double sAtk = currentCharacter.getSAtk();
        double sDef = currentEnemy.getSDef();
		int lv = currentCharacter.getLevel();
		String category = currentCharacter.moveset.get(move).getMoveCategory();
		int dam = 0;
		double modifier = typeEffect(currentCharacter, move, currentEnemy);
        Random rNum = new Random();
		int r = rNum.nextInt(100);
        int acc = (int) (currentCharacter.moveset.get(move).getMoveAcc() * adjustedStage(currentCharacter, currentEnemy));

        if(acc >= r){
			System.out.println(currentCharacter.name + " uses " + moveName + ".");
			switch (category){
				case"physical":{
					dam = (int) (((((2 * lv) * pwr * (atk/def))/50)+2) * modifier);
					break;
				}
				case"special":{
					dam = (int) (((((2 * lv) * pwr * (sAtk/sDef))/50)+2) * modifier);
					break;
				}
				case "status":{
					statusEffect(currentCharacter, move, currentEnemy);
					break;
				}
			}
			if(category != "status"){
				if(modifier > 1){
					System.out.println("It's super effective.");
				}else if(modifier < 1){
					System.out.println("It's not very effective.");
				}
				System.out.println("It does " + dam + " damage.\n");
				currentEnemy.setCurrentHp( (int) ( currentEnemy.getCurrentHp() - dam) );
			}
		}else{
			System.out.println(currentCharacter.name + "'s attack missed.");
        }
        
        if(currentEnemy.currentHp < 0){
			currentEnemy.setCurrentHp(0);
		}
    }
    public static void eAttack(character currentCharacter, enemy currentEnemy){
		Random rand = new Random();
		int rNum = rand.nextInt(currentEnemy.moveset.size());
		String moveName = currentEnemy.moveset.get(rNum).getMoveName();
		double ePwr = currentEnemy.moveset.get(rNum).getPower(); 
		double eAtk = currentEnemy.getAtk();
		double eDef = currentCharacter.getDef();
		double eSAtk = currentEnemy.getSAtk();
		double eSDef = currentCharacter.getSDef();
		int eLv = currentEnemy.getLevel();
		String category = currentEnemy.moveset.get(rNum).getMoveCategory();
		int eDam = 0;
		
		int r = rand.nextInt(100);
		int eAcc = (int) (currentEnemy.moveset.get(rNum).getMoveAcc() * adjustedStage(currentEnemy, currentCharacter));
		if(eAcc >= r){	
			double modifier = typeEffect(currentEnemy, rNum, currentCharacter);
			System.out.println(currentEnemy.name + " uses " + moveName + ".");
			switch (category){
				case"physical":{
					eDam = (int) (((((2 * eLv) * ePwr * (eAtk/eDef))/50)+2) * modifier);
					break;
				}
				case"special":{
					eDam = (int) (((((2 * eLv) * ePwr * (eSAtk/eSDef))/50)+2) * modifier);
					break;
				}
				case "status":{
					statusEffect(currentEnemy, rNum, currentCharacter);
					break;
				}
			}
			if(category != "status"){
				if(modifier > 1){
					System.out.println("It's super effective.");
				}else if(modifier < 1){
					System.out.println("It's not very effective.");
				}
				System.out.println("It does " + eDam + " damage.\n");
				currentCharacter.setCurrentHp( (int) ( currentCharacter.getCurrentHp() - eDam) );
			}
		}else{
			System.out.println(currentEnemy.name + "'s attack missed.");
		}
		if(currentCharacter.currentHp < 0){
			currentCharacter.setCurrentHp(0);
		}
	}
	
	public static void captureAttempt(enemy e, inventory ballChoice){
		int a;
		double b;
		int captured = 0;
		Random r = new Random();
		
		a = (int) (((3 * e.getMaxHp() - 2 * e.getCurrentHp()) * e.getCatchRate() * ballChoice.getBallMultiplier() )/(3*e.getMaxHp())); //* bonusStatus;
		if(a >= 255){
			capture(e);
		}else{
			b = (int) (1048560 / Math.sqrt(Math.sqrt(16711680/a)));
			for(int i = 0; i < 4; i++){
				int rnum = r.nextInt(65535);
				if(b > rnum){
					System.out.println("a: "+a +"| b: " + b + "rnum: " + rnum + " Shake");
					if(i == 3){
						captured = 1;
					}
				}else{
					System.out.println(e.getName() + " broke free.");
					character currentCharacter = run.currentCharacter;
					eAttack(currentCharacter , e);
					i = 5;
				}
			}
			if(captured == 1){
				capture(e);
			}
		}
	}
	
	public static void capture(enemy e){
		Scanner sc = new Scanner(System.in);
		character cp = new character.Builder()
		.withName(e.getName())
		.type1(e.getType1())
		.type2(e.getType2()) // make sure to rewrite builder for type2 so that if null it will catch
		.currentHp(e.getCurrentHp())
		.maxHp(e.getMaxHp())
		.baseAtk(e.getAtk())
		.baseDef(e.getDef())
		.baseSAtk(e.getSAtk())
		.baseSDef(e.getSDef())
		.baseSpd(e.getSpd())
		.baseAcc(e.getAcc())
		.baseEva(e.getEva())
		.baseStage_Atk(0)
        .baseStage_Def(0)
        .baseStage_SAtk(0)
        .baseStage_SDef(0)
        .baseStage_Acc(0)
        .baseStage_Eva(0)
        .level(e.getLevel())
        .moveset(e.getMoveset())
        .baseExp(0) 
		.build();

		test.party.add(cp);
		e.setCurrentHp(0);
		System.out.println("Gotcha. " + cp.name + " was caught. ");
		System.out.println("Do you want to give it a nickname? y/n");
		String nicknameChoice = sc.nextLine();
		if(nicknameChoice.equals("y") || nicknameChoice.equals("Y")){
			System.out.println("Enter the nickname:");
			String nickname = sc.nextLine();
			cp.setName(nickname);
		}
		capture = 1;
		sc.close();
	}
	
    public static double adjustedStage(creature first, creature second){
		int a = first.getAcc();
		int b = second.getEva();
		double acc = 1.00;
		double eva = 1.00;
		
		switch(a){
		case 0:{acc = 1;break;}
		case 1:{acc = 1.3;break;}
		case 2:{acc = 1.67;break;}
		case 3:{acc = 2;break;}
		case 4:{acc = 2.3;break;}
		case 5:{acc = 2.67;break;}
		case 6:{acc = 3;break;}
		
		case -1:{acc = 0.75;break;}
		case -2:{acc = 0.6;break;}
		case -3:{acc = 0.5;break;}
		case -4:{acc = 0.43;break;}
		case -5:{acc = 0.375;break;}
		case -6:{acc = 0.33;break;}
		}
		
		switch(b){
		case 0:{eva = 1;break;}
		case 1:{eva = 0.75;break;}
		case 2:{eva = 0.6;break;}
		case 3:{eva = 0.5;break;}
		case 4:{eva = 0.43;break;}
		case 5:{eva = 0.375;break;}
		case 6:{eva = 0.33;break;}
		
		case -1:{eva = 1.3;break;}
		case -2:{eva = 1.67;break;}
		case -3:{eva = 2;break;}
		case -4:{eva = 2.3;break;}
		case -5:{eva = 2.67;break;}
		case -6:{eva = 3;break;}
		}
		
		double adjusted_stage = acc * eva;
		return adjusted_stage;
	}

    public static double typeEffect(creature first, int move, creature second){
		String moveType = first.moveset.get(move).getMoveType();
		String type = second.getType1();
		double typeDamageRate = 1;
		//it might be a good idea to convert the switch statement for the types to a map based on the types
		switch(moveType){
		case "normal":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 0.5; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 0; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "fight":{
			switch(type){
			case "normal":{ typeDamageRate = 2; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 0.5; break;}
			case "poison":{ typeDamageRate = 0.5; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 2; break;}
			case "bug":{ typeDamageRate = 0.5; break;}
			case "ghost":{ typeDamageRate = 0; break;}
			case "steel":{ typeDamageRate = 2; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 0.5; break;}
			case "ice":{typeDamageRate = 2; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 2; break;}
			case "fairy":{typeDamageRate = 0.5; break;}
			}
			break;
		}
		case "flying":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 2; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 0.5; break;}
			case "bug":{ typeDamageRate = 2; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 2; break;}
			case "electric":{typeDamageRate = 0.5; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "poison":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 0.5; break;}
			case "ground":{ typeDamageRate = 0.5; break;}
			case "rock":{ typeDamageRate = 0.5; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 0.5; break;}
			case "steel":{ typeDamageRate = 0; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 2; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 2; break;}
			}
			break;
		}
		case "ground":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 0; break;}
			case "poison":{ typeDamageRate = 2; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 2; break;}
			case "bug":{ typeDamageRate = 0.5; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 2; break;}
			case "fire":{typeDamageRate = 2; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 0.5; break;}
			case "electric":{typeDamageRate = 2; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "rock":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 0.5; break;}
			case "flying":{ typeDamageRate = 2; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 0.5; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 2; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 2; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 2; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "bug":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 0.5; break;}
			case "flying":{ typeDamageRate = 0.5; break;}
			case "poison":{ typeDamageRate = 0.5; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 0.5; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 0.5; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 2; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 2; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 2; break;}
			case "fairy":{typeDamageRate = 0.5; break;}
			}
			break;
		}
		case "ghost":{
			switch(type){
			case "normal":{ typeDamageRate = 0; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 2; break;}
			case "steel":{ typeDamageRate = 1; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 2; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 0.5; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "steel":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 2; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 0.5; break;}
			case "water":{ typeDamageRate = 0.5; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 0.5; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 2; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 2; break;}
			}
			break;
		}
		case "fire":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 0.5; break;}
			case "bug":{ typeDamageRate = 2; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 2; break;}
			case "fire":{typeDamageRate = 0.5; break;}
			case "water":{ typeDamageRate = 0.5; break;}
			case "grass":{typeDamageRate = 2; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 2; break;}
			case "dragon":{typeDamageRate = 0.5; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "water":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 2; break;}
			case "rock":{ typeDamageRate = 2; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 1; break;}
			case "fire":{typeDamageRate = 2; break;}
			case "water":{ typeDamageRate = 0.5; break;}
			case "grass":{typeDamageRate = 0.5; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 0.5; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "grass":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 0.5; break;}
			case "poison":{ typeDamageRate = 0.5; break;}
			case "ground":{ typeDamageRate = 2; break;}
			case "rock":{ typeDamageRate = 2; break;}
			case "bug":{ typeDamageRate = 0.5; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 0.5; break;}
			case "water":{ typeDamageRate = 2; break;}
			case "grass":{typeDamageRate = 0.5; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 2; break;}
			case "dragon":{typeDamageRate = 0.5; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "electric":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 2; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 0; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 1; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 2; break;}
			case "grass":{typeDamageRate = 0.5; break;}
			case "electric":{typeDamageRate = 0.5; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 0.5; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "psychic":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 2; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 2; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 0.5; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 0; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "ice":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 2; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 2; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 0.5; break;}
			case "water":{ typeDamageRate = 0.5; break;}
			case "grass":{typeDamageRate = 2; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 0.5; break;}
			case "dragon":{typeDamageRate = 2; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		case "dragon":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 1; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 2; break;}
			case "dark":{typeDamageRate = 1; break;}
			case "fairy":{typeDamageRate = 0; break;}
			}
			break;
		}
		case "dark":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 0.5; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 1; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 2; break;}
			case "steel":{ typeDamageRate = 1; break;}
			case "fire":{typeDamageRate = 1; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 2; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 1; break;}
			case "dark":{typeDamageRate = 0.5; break;}
			case "fairy":{typeDamageRate = 0.5; break;}
			}
			break;
		}
		case "fairy":{
			switch(type){
			case "normal":{ typeDamageRate = 1; break;}
			case "fight":{ typeDamageRate = 2; break;}
			case "flying":{ typeDamageRate = 1; break;}
			case "poison":{ typeDamageRate = 0.5; break;}
			case "ground":{ typeDamageRate = 1; break;}
			case "rock":{ typeDamageRate = 1; break;}
			case "bug":{ typeDamageRate = 1; break;}
			case "ghost":{ typeDamageRate = 1; break;}
			case "steel":{ typeDamageRate = 0.5; break;}
			case "fire":{typeDamageRate = 0.5; break;}
			case "water":{ typeDamageRate = 1; break;}
			case "grass":{typeDamageRate = 1; break;}
			case "electric":{typeDamageRate = 1; break;}
			case "psychic":{typeDamageRate = 1; break;}
			case "ice":{typeDamageRate = 1; break;}
			case "dragon":{typeDamageRate = 2; break;}
			case "dark":{typeDamageRate = 2; break;}
			case "fairy":{typeDamageRate = 1; break;}
			}
			break;
		}
		} 
		return typeDamageRate;
	}

	//test and review to confirm that this working
	public static void statusEffect(creature first, int move, creature second){
		System.out.println("Status effected accessed.");
		String stat = first.moveset.get(move).getStat();
		int stage =  first.moveset.get(move).getStage();
		if(stage < 0){
			switch(stat){
				case "atk":{
					second.setStage_atk(stage);
					break;
					}
				case "def":{
					second.setStage_def(stage);
					break;
					}
				case "sAtk":{
					second.setStage_sAtk(stage);
					break;
				}
				case "sDef":{
					second.setStage_sDef(stage);
					break;
				}
				case "acc":{
					second.setStage_acc(stage);
					break;
				}
				case "eva":{
					second.setStage_eva(stage);
					break;
				}
			}
		} else if(stage > 0){
			switch(stat){
				case "atk":{
					first.setStage_atk(stage);
					break;
					}
				case "def":{
					first.setStage_def(stage);
					break;
				}
				case "sAtk":{
					first.setStage_sAtk(stage);
					break;
				}
				case "sDef":{
					first.setStage_sDef(stage);
					break;
				}
				case "acc":{
					first.setStage_acc(stage);
					break;
				}
				case "eva":{
					first.setStage_eva(stage);
					break;
				}
			}
		}
	}
}