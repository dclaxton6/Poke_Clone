import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

class run{
    public static fight f = new fight();
    public static character currentCharacter;

    public void start(final character character){
        
        final Scanner s = new Scanner(System.in);
        int menuChoice;
        currentCharacter = character;

        final initEnemy ie = new initEnemy();
        enemy currentEnemy;
        final String[] menu = {
            "1)Random Fight",
			"2)Gym",
			"3)PokeCenter"
        };
        int exit = 0;
        while(exit != -1){
            
        for(final String option : menu){
            System.out.println(option);
        }
        
        menuChoice =  s.nextInt();
        
             switch(menuChoice){
            case 1:{// fight
                currentEnemy = ie.create();
                int quit = 0;
                while(quit  != -1){
                    if(currentEnemy.getCurrentHp() <= 0 || fight.capture == 1){
                        quit = -1;
                        if(fight.capture != 1){
                            System.out.println("\n" + currentEnemy.name + " has fainted. you win." );
                            currentCharacter.resetStageValues();
                            currentCharacter.ls.expGain(currentCharacter, currentEnemy);
                            battleMoney(currentEnemy, test.inv);
                            break;
                        } else{
                            currentEnemy = null;
                            fight.capture = 0;
                            break;
                        }
                    }
                    if(currentCharacter.getCurrentHp() <= 0){
                        quit = -1;
                        System.out.println("\n" + currentCharacter.name + " has fainted. you lose.");
                        break;
                    }
                    else{
                        String[] fightOptionsMenu = {
                            "Fight",
                            "Change Character",
                            "Items",
                            "Run",
                            "Stats",
                            "Save Game",
                            "Load Game"
                        };
                        System.out.println(currentCharacter.name + " Lv:" +currentCharacter.level +"  "+currentCharacter.currentHp +"/"+ currentCharacter.maxHp + "\n" +
                            currentEnemy.name + " Lv:" +currentEnemy.level +"  "+currentEnemy.currentHp +"/" + currentEnemy.maxHp);
                           
                        int t = 1;
                        for(String option : fightOptionsMenu){
                            System.out.println(t + ")" + option);
                            t++;
                        }
                        int fightOptions = s.nextInt();  
                        switch(fightOptions){
                            case 1:{
                                for(int i = 0; i < currentCharacter.moveset.size(); i++){
                                    if(currentCharacter.moveset.get(i) != null)
                                    System.out.println((i+1)+")" + currentCharacter.moveset.get(i).getMoveName()+ " " +
                                    currentCharacter.moveset.get(i).getPp() + " / " + currentCharacter.moveset.get(i).getMaxPp());
                                }
                                System.out.println("Press x to go back");
                                switch(s.next()){
                                    case "1":{
                                        if( currentCharacter.moveset.get(0) != null){
                                            if(currentCharacter.moveset.get(0).getPp() > 0){
                                                fight.battle(currentCharacter, 0, currentEnemy);
                                                currentCharacter.moveset.get(0).setPp(currentCharacter.moveset.get(0).getPp()-1);
                                                }else{
                                                    System.out.println("You have ran out of PP for that move!");
                                                }
                                            }else{
                                                System.out.println("No Move");
                                            }
                                        break;
                                    }
                                    case "2":{
                                        if( currentCharacter.moveset.get(1) != null){
                                            if(currentCharacter.moveset.get(1).getPp() > 0){
                                                fight.battle(currentCharacter, 1, currentEnemy);
                                                currentCharacter.moveset.get(1).setPp(currentCharacter.moveset.get(1).getPp()-1);
                                                }else{
                                                    System.out.println("You have ran out of PP for that move!");
                                                }
                                            }else{
                                                System.out.println("No Move");
                                            }
                                        break;
                                    }
                                    case "3":{
                                        if( currentCharacter.moveset.get(2) != null){
                                            if(currentCharacter.moveset.get(2).getPp() > 0){
                                                fight.battle(currentCharacter, 2, currentEnemy);
                                                currentCharacter.moveset.get(2).setPp(currentCharacter.moveset.get(2).getPp()-1);
                                                }else{
                                                    System.out.println("You have ran out of PP for that move!");
                                                }
                                            }else{
                                                System.out.println("No Move");
                                            }
                                        break;
                                    }
                                    case "4":{
                                        if( currentCharacter.moveset.get(3) != null){
                                            if(currentCharacter.moveset.get(3).getPp() > 0){
                                                fight.battle(currentCharacter, 3, currentEnemy);
                                                currentCharacter.moveset.get(3).setPp(currentCharacter.moveset.get(3).getPp()-1);
                                                }else{
                                                    System.out.println("You have ran out of PP for that move!");
                                                }
                                            }else{
                                                System.out.println("No Move");
                                            }
                                        break;
                                    }
                                    case "x":{
                                        break;
                                    }
                                }
                                break;
                            }
                            case 2:{
                                for(int i = 0; i < test.party.size(); i++){
                                    if(test.party.get(i) != null){
                                        System.out.println((i+1)+")" + test.party.get(i).name + " " +
                                        test.party.get(i).getCurrentHp() + " / " + test.party.get(i).getMaxHp());
                                    }
                                }
                                int characterChoice = s.nextInt() - 1;
                                System.out.println("You have selected " + test.party.get(characterChoice).name);
                                currentCharacter = test.party.get(characterChoice);
                                break;
                            }
                            case 3:{
                                items.Items(currentCharacter, currentEnemy);
                                break;
                            }
                            case 4:{
                                Random random = new Random();
                                int runAttempt = random.nextInt(10);
                                if(runAttempt > 6){
                                    System.out.println("You got away.");
                                    quit = -1;
                                } else{
                                    System.out.println("The enemy would not let you escape.\n");
                                    fight.eAttack(currentCharacter, currentEnemy);
                                }
                                break;
                            }
                            case 5:{
                                System.out.println("Who stats do you want to view? 1)Character 2)Enemy");
                                int statChoice = s.nextInt();
                                if(statChoice == 1){
                                    System.out.println(currentCharacter.getName() + " "
                                            + "Lv: " + currentCharacter.getLevel()+ "\n"
                                            + "Exp: " + currentCharacter.getExp()+"\n"
                                            + "Exp to next Lv: " + levelingSystem.expNeeded(currentCharacter.getLevel()) + "\n"
                                            + "Total Exp: " + currentCharacter.getTotalExp()+"\n"
                                            + "Atk: " + currentCharacter.getAtk()+ "\n"
                                            + "Def: " + currentCharacter.getDef()+ "\n"
                                            + "SAtk: " + currentCharacter.getSAtk()+ "\n"
                                            + "SDef: " + currentCharacter.getSDef()+ "\n"
                                            + "Spd: " + currentCharacter.getSpd()+ "\n"
                                            + "Acc: " + currentCharacter.getAcc()+ "\n"
                                            + "Eva: " + currentCharacter.getEva()+ "\n");
                                } else if(statChoice == 2){
                                    System.out.println(currentEnemy.getName() + " "
                                            + "Lv: " + currentEnemy.getLevel()+ "\n"
                                            +"EXP Given: "+currentEnemy.getExpGiven()+"\n"
                                            + "Atk: " + currentEnemy.getAtk()+ "\n"
                                            + "Def: " + currentEnemy.getDef()+ "\n"
                                            + "SAtk: " + currentEnemy.getSAtk()+ "\n"
                                            + "SDef: " + currentEnemy.getSDef()+ "\n"
                                            + "Spd: " + currentEnemy.getSpd()+ "\n"
                                            + "Acc: " + currentEnemy.getAcc()+ "\n"
                                            + "Eva: " + currentEnemy.getEva()+ "\n");
                                }
                                break;
                            }
                            case 6:{
                                System.out.println("Do you want to save your game? y/n");
                                String saveChoice = s.next();
                                if(saveChoice.equals("y") || saveChoice.equals("Y")){
                                    Save.save();
                                }
                                break;
                            }
                            case 7:{
                                System.out.println("Do you want to load your game? y/n");
                                String loadChoice = s.next();
                                if(loadChoice.equals("y") || loadChoice.equals("Y")){
                                    Load.load();
                                }
                                break;
                            }

                        }
                    }
                }
                break;
            }
            case 2:{//Gym case
                break;
            }
            case 3:{
                //heal
                System.out.println("You take a rest.");
                for(character c : test.party){
                    c.setCurrentHp(c.getMaxHp());
                }
                System.out.println("All of you characters have been restored.");
                break;
            }
        } 

        System.out.println("Do you want to battle again? (Y/N)");
        int quitBattleOption = 0;
        while(quitBattleOption != -1){
            String battleAgain = s.next().toLowerCase();
            switch(battleAgain){
                case "y":{
                    System.out.println("entered y");
                    quitBattleOption = -1;
                    break;
                }
                case "n":{
                    System.out.println("entered n");
                    quitBattleOption = -1;
                    exit = -1;
                    break;
                }
                default:{
                    System.out.println("Invalid entry. Please try again.");
                    System.out.println("Do you want to battle again? (Y/N)");
                    break;
                }
            }
        }
        }
        s.close();
    }

    public static void battleMoney(enemy currentEnemy, ArrayList<inventory> inv){
		int payOut = currentEnemy.getMoneyGiven() * currentEnemy.getLevel(); 
		System.out.println("You have won " + payOut + " money.");
		inv.get(0).setMoney(inv.get(0).getMoney() + payOut);
	}
}