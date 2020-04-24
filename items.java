import java.util.ArrayList;
import java.util.Scanner;

public class items {
    public static ArrayList<inventory> inv = test.inv;
    public static inventory potion = inv.get(1);
    public static inventory superPotion = inv.get(2);
    public static inventory hyperPotion = inv.get(3);

    public static inventory ether = inv.get(4);
    public static inventory maxEther = inv.get(5);

    public static inventory pokeBall = inv.get(6);
    public static inventory greatBall = inv.get(7);
    public static inventory ultraBall = inv.get(8);
    public static inventory masterBall = inv.get(9);

    // the way of accessing the character variables will change in the future this
    // is just a test
    // eventually i intend to place all of the characters within an arraylist
    // similar to the moves to moveset and access it that way
    public static void Items(character currentCharacter, enemy currentEnemy) {
        System.out.println("Items Menu");
        System.out.println("1)HP Items" + "\n2)MP Items" + "\n3)PokeBalls" + "\n press X to exit");

        Scanner itemChoice = new Scanner(System.in);

        switch (itemChoice.nextLine()) {
        case "1": {
            System.out.println("HP Items");
            System.out.println(
                    "1)Potion" + " : " + potion.getQuantity() + "\n2)Super Potion" + " : " + superPotion.getQuantity()
                            + "\n3)Hyper Potion" + " : " + hyperPotion.getQuantity()
                        + "\nPress x to go back");

                switch(itemChoice.nextLine()){
                    case "1":{
                        if(potion.getQuantity() > 0){
                            System.out.println("testing hp item 1");
                            currentCharacter.setCurrentHp(currentCharacter.getCurrentHp() + 20);
                            if(currentCharacter.getCurrentHp() > currentCharacter.getMaxHp()){
                                currentCharacter.setCurrentHp(currentCharacter.getMaxHp());
                            }
                            fight.eAttack(currentCharacter, currentEnemy);
                        }else{
                            System.out.println("You're out of " + potion.getName() +"s \n");
                        }
                        break;
                    }
                    case "2":{
                        if(superPotion.getQuantity() > 0){
                            System.out.println("testing hp item 2");
                            currentCharacter.setCurrentHp(currentCharacter.getCurrentHp() + 100);
                            if(currentCharacter.getCurrentHp() > currentCharacter.getMaxHp()){
                                currentCharacter.setCurrentHp(currentCharacter.getMaxHp());
                            }
                            fight.eAttack(currentCharacter, currentEnemy);
                        }else{
                            System.out.println("You're out of " + superPotion.getName() +"s \n");
                        }
                        break;
                    }
                    case "3":{
                        if(hyperPotion.getQuantity() > 0){
                            System.out.println("testing hp item 3");
                            currentCharacter.setCurrentHp(currentCharacter.getCurrentHp() + 200);
                            if(currentCharacter.getCurrentHp() > currentCharacter.getMaxHp()){
                                currentCharacter.setCurrentHp(currentCharacter.getMaxHp());
                            }
                            fight.eAttack(currentCharacter, currentEnemy);
                        }else{
                            System.out.println("You're out of " + hyperPotion.getName() +"s \n");
                        }
                        break;
                    }
                    case "x":{
                        Items(currentCharacter, currentEnemy);
                        break;
                    }
                }//end of switch for case 1
                break;
            } //end of case 1
            
            case "2":{
                //might need to add a way to add the mp based on the using the get method from the moveset arraylist : done 
                System.out.println("MP Items");
                System.out.println("1)Ether"  + " : " + ether.getQuantity()
                        + "\n2)Max Ether" + " : " + maxEther.getQuantity()
                        + "\n press X to go back");

                switch(itemChoice.nextLine()){
                    case "1":{
                        if(ether.getQuantity() > 0){
                            System.out.println("testing pp item 1");
                            System.out.println("Which move are you using the item on?\n ");
                            for(int i = 0; i < currentCharacter.moveset.size(); i++){
                                if(currentCharacter.moveset.get(i) != null){
                                System.out.println( (i+1)+ ")" + currentCharacter.moveset.get(i).getMoveName() + " " +
                                        currentCharacter.moveset.get(i).getPp() + " / " + currentCharacter.moveset.get(i).getMaxPp());
                                }
                            }
                            int moveChoice = itemChoice.nextInt();
                            currentCharacter.moveset.get(moveChoice - 1).setPp(currentCharacter.moveset.get(moveChoice - 1).getPp() + 10);
                            System.out.println("Restoring PP.");
                            fight.eAttack(currentCharacter, currentEnemy);
                        }else{
                            System.out.println("You're out of " + ether.getName() +"s \n");
                        }
                        break;
                    }
                    case "2":{
                        if(maxEther.getQuantity() > 0){
                            System.out.println("testing pp item 2");
                            System.out.println("Which move are you using the item on?\n ");
                            for(int i = 0; i < currentCharacter.moveset.size(); i++){
                                if(currentCharacter.moveset.get(i) != null){
                                System.out.println( (i+1)+")"+currentCharacter.moveset.get(i).getMoveName()+ " " +
                                        currentCharacter.moveset.get(i).getPp() + " / " + currentCharacter.moveset.get(i).getMaxPp());
                                }
                            }
                            int moveChoice = itemChoice.nextInt();
                            currentCharacter.moveset.get(moveChoice - 1).setPp(currentCharacter.moveset.get(moveChoice - 1).getPp() + currentCharacter.moveset.get(moveChoice - 1).getMaxPp());
                            System.out.println("Restoring PP.");
                            fight.eAttack(currentCharacter, currentEnemy);
                        }else{
                            System.out.println("You're out of " + maxEther.getName() +"s \n");
                        }
                        break;
                    }
                    case "x":{
                        Items(currentCharacter, currentEnemy);
                        break;
                    }
                } //end of switch for case 2
                break;
            } //end of case 2
            case "3":{
                System.out.println("PokeBalls");
                System.out.println("1)PokeBall" + " : " + pokeBall.getQuantity()
                        + "\n2)Great Ball" + " : " + greatBall.getQuantity()
                        + "\n3)Ultra Ball" + " : " + ultraBall.getQuantity()
                        + "\n4)Master Ball" + " : " + masterBall.getQuantity()
                        + "\n press X to go back");

                switch(itemChoice.nextLine()){
                    case "1":{
                        if(pokeBall.getQuantity() > 0){
                        fight.captureAttempt(currentEnemy, pokeBall);
                        pokeBall.setQuantity(pokeBall.getQuantity() - 1);
                        }else{
                            System.out.println("You're out of " + pokeBall.getName() +"s \n");
                        }
                        break;
                    }
                    case "2":{
                        if(greatBall.getQuantity() > 0){
                            fight.captureAttempt(currentEnemy, greatBall);
                            greatBall.setQuantity(greatBall.getQuantity() - 1);
                            }else{
                                System.out.println("You're out of " + greatBall.getName() +"s \n");
                            }
                            break;
                    }
                    case "3":{
                        if(ultraBall.getQuantity() > 0){
                            fight.captureAttempt(currentEnemy, ultraBall);
                            ultraBall.setQuantity(ultraBall.getQuantity() - 1);
                            }else{
                                System.out.println("You're out of " + ultraBall.getName() +"s \n");
                            }
                            break;
                    }
                    case "4":{
                        if(masterBall.getQuantity() > 0){
                            fight.captureAttempt(currentEnemy, masterBall);
                            masterBall.setQuantity(masterBall.getQuantity() - 1);
                            }else{
                                System.out.println("You're out of " + masterBall.getName() +"s \n");
                            }
                            break;
                    }
                    case "x":{
                        Items(currentCharacter, currentEnemy);
                        break;
                    }
                }//end of switch for case 3
                break;
            }//end of case 3
            case "x":{
                break;
            }
        }
    itemChoice.close();
    }
}