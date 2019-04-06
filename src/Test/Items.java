package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Items {
	public ArrayList<Inventory> inv = MainMenu.inv;
	public Inventory potion = inv.get(1);
	public Inventory superPotion = inv.get(2);
	public Inventory hyperPotion = inv.get(3);
	
	public Inventory ether = inv.get(4);
	public Inventory maxEther = inv.get(5);
	
	public Inventory pokeBall= inv.get(6);
	public Inventory greatBall = inv.get(7);
	public Inventory ultraBall = inv.get(8);
	public Inventory masterBall = inv.get(9);
	
	//the way of accessing the character variables will change in the future this is just a test
	//eventually i intend to place all of the characters within an arraylist similar to the moves to moveset and access it that way
	public void items(characters currentCharacter, enemy currentEnemy){
		System.out.println("Items Menu");
		System.out.println("1)HP Items"
				+ "\n2)MP Items"
				+ "\n3)PokeBalls"
				+ "\n press X to exit");
		
		Scanner itemChoice =  new Scanner(System.in);
		
		switch(itemChoice.nextLine()){
		case "1":{
			System.out.println("HP Items");
			System.out.println("1)Potion" + " : " + potion.getQuantity()
					+ "\n2)Super Potion" + " : " + superPotion.getQuantity()
					+ "\n3)Hyper Potion" + " : " + hyperPotion.getQuantity()
					+ "\nPress x to go back");
			switch(itemChoice.nextLine()){
				case "1":{
					if(potion.getQuantity() > 0){
						System.out.println("testing hp item 1");
						currentCharacter.setHp(currentCharacter.getHp() + 20);
						if(currentCharacter.getHp() > currentCharacter.getMaxHP()){
							currentCharacter.setHp(currentCharacter.maxHP);
						}
						fight.eAttack(currentCharacter, currentEnemy);
					}else{
						System.out.println("You're out of " + potion.name +"s \n");
					}
					MainMenu.start();
					break;
				}
				case "2":{
					if(superPotion.getQuantity() > 0){
						System.out.println("testing hp item 2");
						currentCharacter.setHp(currentCharacter.getHp() + 100);
						if(currentCharacter.getHp() > currentCharacter.getMaxHP()){
							currentCharacter.setHp(currentCharacter.maxHP);
						}
						fight.eAttack(currentCharacter, currentEnemy);
					}else{
						System.out.println("You're out of " + superPotion.name +"s \n");
					}
					MainMenu.start();
					break;
				}
				case "3":{
					if(hyperPotion.getQuantity() > 0){
						System.out.println("testing hp item 3");
						currentCharacter.setHp(currentCharacter.getHp() + 200);
						if(currentCharacter.getHp() > currentCharacter.getMaxHP()){
							currentCharacter.setHp(currentCharacter.maxHP);
						}
						fight.eAttack(currentCharacter, currentEnemy);
					}else{
						System.out.println("You're out of " + hyperPotion.name +"s \n");
					}
					MainMenu.start();
					break;
				}
				case "x":{
					items(currentCharacter, currentEnemy);
					break;
				}
			}
			break;
		}
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
							System.out.println( (i+1)+")"+currentCharacter.moveset.get(i).name+ " " +
									currentCharacter.moveset.get(i).pp + " / " + currentCharacter.moveset.get(i).getMaxPp());
							}
						}
						int moveChoice = itemChoice.nextInt();
						currentCharacter.moveset.get(moveChoice - 1).setPp(currentCharacter.moveset.get(moveChoice - 1).getPp() + 10);
						System.out.println("Restoring PP.");
						fight.eAttack(currentCharacter, currentEnemy);
					}else{
						System.out.println("You're out of " + ether.name +"s \n");
					}
					MainMenu.start();
					break;
				}
				case "2":{
					if(maxEther.getQuantity() > 0){
						System.out.println("testing pp item 2");
						System.out.println("Which move are you using the item on?\n ");
						for(int i = 0; i < currentCharacter.moveset.size(); i++){
							if(currentCharacter.moveset.get(i) != null){
							System.out.println( (i+1)+")"+currentCharacter.moveset.get(i).name+ " " +
									currentCharacter.moveset.get(i).pp + " / " + currentCharacter.moveset.get(i).getMaxPp());
							}
						}
						int moveChoice = itemChoice.nextInt();
						currentCharacter.moveset.get(moveChoice - 1).setPp(currentCharacter.moveset.get(moveChoice - 1).getPp() + currentCharacter.moveset.get(moveChoice - 1).getMaxPp());
						System.out.println("Restoring PP.");
						fight.eAttack(currentCharacter, currentEnemy);
					}else{
						System.out.println("You're out of " + maxEther.name +"s \n");
					}
					MainMenu.start();
					break;
				}
				case "x":{
					items(currentCharacter, currentEnemy);
					break;
				}
			}
			break;
		}
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
						System.out.println("You're out of " + pokeBall.name +"s \n");
					}
					MainMenu.start();
					break;
				}
				case "2":{
					if(greatBall.getQuantity() > 0){
						fight.captureAttempt(currentEnemy, greatBall);
						greatBall.setQuantity(greatBall.getQuantity() - 1);
						}else{
							System.out.println("You're out of " + greatBall.name +"s \n");
						}
						MainMenu.start();
						break;
				}
				case "3":{
					if(ultraBall.getQuantity() > 0){
						fight.captureAttempt(currentEnemy, ultraBall);
						ultraBall.setQuantity(ultraBall.getQuantity() - 1);
						}else{
							System.out.println("You're out of " + ultraBall.name +"s \n");
						}
						MainMenu.start();
						break;
				}
				case "4":{
					if(masterBall.getQuantity() > 0){
						fight.captureAttempt(currentEnemy, masterBall);
						masterBall.setQuantity(masterBall.getQuantity() - 1);
						}else{
							System.out.println("You're out of " + masterBall.name +"s \n");
						}
						MainMenu.start();
						break;
				}
				case "x":{
					items(currentCharacter, currentEnemy);
					break;
				}
			}
			break;
		}
		case "x":{
			MainMenu.start();
			break;
		}
		}
		itemChoice.close();
	}
}