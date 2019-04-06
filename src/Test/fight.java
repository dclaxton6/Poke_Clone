package Test;

import java.util.Random;
import java.util.Scanner;

public class fight {

	public static void battle(characters currentCharacter, int move, creatures currentEnemy){
		if(currentCharacter.getSpd() > currentEnemy.getSpd()){
			cAttack(currentCharacter, move, currentEnemy);
			if(currentEnemy.getHp() > 0){
				eAttack(currentCharacter, currentEnemy);
			}
		} else if(currentCharacter.getSpd() < currentEnemy.getSpd()){
			eAttack(currentCharacter, currentEnemy);
			if(currentCharacter.getHp() > 0){
				cAttack(currentCharacter, move, currentEnemy);
			}
		} else if(currentCharacter.getSpd() == currentEnemy.getSpd()){
			Random rNum = new Random();
			int r = rNum.nextInt(2);
			switch(r){
				case 0:{
					cAttack(currentCharacter, move, currentEnemy);
					if(currentEnemy.getHp() > 0){
						eAttack(currentCharacter, currentEnemy);
					}
					break;
				}
				case 1:{
					eAttack(currentCharacter, currentEnemy);
					if(currentCharacter.getHp() > 0){
						cAttack(currentCharacter, move, currentEnemy);
					}
					break;
				}
			}
		}
	}
	
	public static void cAttack(characters currentCharacter, int move, creatures currentEnemy){
		
		String moveName = currentCharacter.moveset.get(move).getName();
		double pwr = currentCharacter.moveset.get(move).getPower();
		int atk = currentCharacter.getAtk();
		int def = currentEnemy.getDef();
		int sAtk = currentCharacter.getSAtk();
		int sDef = currentEnemy.getSDef();
		int lv = currentCharacter.getLevel();
		String catergory = currentCharacter.moveset.get(move).getCatergory();
		int dam = 0;
		//need to add accuracy effect : done //need to add a speed stat to determine which attack goes first
		//need to change the modifier to include type damage and possible status effects  //need to add a random variable for critical hit
		Random rNum = new Random();
		int r = rNum.nextInt(100);
		int acc = (int) (currentCharacter.moveset.get(move).getAccuracy() * adjustedStage(currentCharacter, currentEnemy));
		
		if(acc >= r){
			double modifier = typeEffect(currentCharacter, move, currentEnemy);
			System.out.println(currentCharacter.name + " uses " + moveName + ".");
			switch (catergory){
				case "physical":{
					dam = (int) (((((((2*lv)/5)+2)* pwr * (atk/def))/50) + 2 ) * modifier);
					currentEnemy.setHp((int) (currentEnemy.getHp() - dam));
					
					if(modifier > 1){
						System.out.println("It's super effective.");
					}else if(modifier < 1){
						System.out.println("It's not very effective.");
					}
					System.out.println("It does " + dam + " damage.\n");
					 break;
				}
				case "special":{
					dam = (int) (((((((2*lv)/5)+2)* pwr * (sAtk/sDef))/50) + 2 ) * modifier);
					currentEnemy.setHp((int) (currentEnemy.getHp() - dam));
					
					if(modifier > 1){
						System.out.println("It's super effective.");
					}else if(modifier < 1){
						System.out.println("It's not very effective.");
					}
					System.out.println("It does " + dam + " damage.\n");
					break;
					}
				case "status":{
					statusEffect(currentCharacter, move, currentEnemy);
					break;
					}
			}
		
		}else{
			System.out.println(currentCharacter.name + "'s attack missed.");
		}
		//might need to remove when adding the speed stat which will allow for the speed stat to determine who goes first
		//eAttack(currentCharacter, currentEnemy);
		if(currentEnemy.hp < 0){
			currentEnemy.setHp(0);
		}
		
		if(currentCharacter.hp < 0){
			currentCharacter.setHp(0);
		}
	}
	
	public static void eAttack(characters currentCharacter, creatures currentEnemy){
		
		Random rand = new Random();
		int rNum = rand.nextInt(currentEnemy.moveset.size() - 1);
		String moveName = currentEnemy.moveset.get(rNum).name;
		double ePwr = currentEnemy.moveset.get(rNum).getPower(); 
		int eAtk = currentEnemy.getAtk();
		int eDef = currentCharacter.getDef();
		int eSAtk = currentEnemy.getSAtk();
		int eSDef = currentCharacter.getSDef();
		int eLv = currentEnemy.getLevel();
		String catergory = currentEnemy.moveset.get(rNum).getCatergory();
		int eDam = 0;
		
		int r = rand.nextInt(100);
		int eAcc = (int) (currentCharacter.moveset.get(rNum).getAccuracy() * adjustedStage(currentEnemy, currentCharacter));
		if(eAcc >= r){	
			double modifier = typeEffect(currentEnemy, rNum, currentCharacter);
			System.out.println(currentEnemy.name + " uses " + moveName + ".");
			switch (catergory){
			case "physical":{
				eDam = (int) (((((((2*eLv)/5)+2)* ePwr * (eAtk/eDef))/50) + 2 ) * modifier);
				currentCharacter.setHp((int) (currentCharacter.getHp() - eDam));
	
				if(modifier > 1){
					System.out.println("It's super effective.");
				}else if(modifier < 1){
					System.out.println("It's not very effective.");
				}
				System.out.println("It does " + eDam + " damage.\n");
				 break;
			}
			case "special":{
				eDam = (int) (((((((2*eLv)/5)+2)* ePwr * (eSAtk/eSDef))/50) + 2) * modifier);
				currentCharacter.setHp((int) (currentCharacter.getHp() - eDam));
				
				if(modifier > 1){
					System.out.println("It's super effective.");
				}else if(modifier < 1){
					System.out.println("It's not very effective.");
				}
				System.out.println("It does " + eDam + " damage.\n");
				break;
			}
			case "status":{
				statusEffect(currentEnemy,rNum,currentCharacter);
				break;
			}
		}
		}else{
			System.out.println(currentEnemy.name + "'s attack missed.");
		}
		if(currentCharacter.hp < 0){
			currentCharacter.setHp(0);
		}
	}
	
	public static void captureAttempt(enemy e, Inventory ballChoice){
		int a;
		double b;
		int captured = 0;
		Random r = new Random();
		
		a = (int) (((3 * e.getMaxHP() - 2 * e.getHp()) * e.getCatchRate() * ballChoice.getBallMultiplier() )/(3*e.getMaxHP())); //* bonusStatus;
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
					characters currentCharacter = MainMenu.currentCharacter;
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
		characters cp = new characters(e.getName(), e.getType(), e.getHp(), e.getMaxHP(), e.getAtk(),
		e.getDef(), e.getSAtk(), e.getSDef(), e.getSpd(), e.getAcc(), e.getEva(), e.getStage_atk(),
		e.getStage_def(), e.getStage_sAtk(), e.getStage_sDef(), e.getStage_acc(), e.getStage_eva(),
		e.getLevel(), 0, 0, " ", e.moveset);
		MainMenu.party.add(cp);
		e.setHp(0);
		System.out.println("Gotcha. " + cp.name + " was caught. ");
		System.out.println("Do you want to give it a nickname? y/n");
		String nicknameChoice = sc.nextLine();
		if(nicknameChoice.equals("y") || nicknameChoice.equals("Y")){
			System.out.println("Enter the nickname:");
			String nickname = sc.nextLine();
			cp.setName(nickname);
		}
		MainMenu.capture = 1;
	}
	
	public static double adjustedStage(creatures first, creatures second){
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
	
	public static double stageMultiplier(int a){
		double stat = 1.00;
		switch(a){
		case 0:{stat = 1; break;}
		case 1:{stat = 1.5; break;}
		case 2:{stat = 2; break;}
		case 3:{stat = 2.5; break;}
		case 4:{stat = 3; break;}
		case 5:{stat = 3.5; break;}
		case 6:{stat = 4; break;}
		
		case -1:{stat = 0.667; break;}
		case -2:{stat = 0.5; break;}
		case -3:{stat = 0.4; break;}
		case -4:{stat = 0.33; break;}
		case -5:{stat = 0.286; break;}
		case -6:{stat = 0.25; break;}
		}
		return stat;
	}
	
	public static double typeEffect(creatures first, int move, creatures second){
		String moveType = first.moveset.get(move).getType();
		String type = second.getType();
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
	
	public static int statusEffect(creatures first, int move, creatures second){
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
					second.setStage_eva(stage);;
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
					first.setStage_eva(stage);;
					break;
				}
			}
		}
		return 0;
	}
}