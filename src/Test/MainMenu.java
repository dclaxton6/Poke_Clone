package Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import loading_system.Load;
import loading_system.Save;

public class MainMenu {
	static ArrayList<Move> moveset1 = new ArrayList<Move>();
	public static characters currentCharacter = new characters();
	public static ArrayList<characters> party = new ArrayList<characters>();
	public static ArrayList<Inventory> inv = new ArrayList<Inventory>();
	public static enemy currentEnemy;
	public static boolean characterCreated = false;
	public static characters starter = null;
	public static int capture = 0;
	//these values are here for test i dont know if i should create a way to store the moves in a save file
	static Move waterGun = new Move("Water Gun",25, 25, 100, 60, "water", "special");
	static Move ember = new Move("Ember", 20, 20, 50, 70, "fire", "physical");
	static Move blazeKick = new Move("Blaze Kick", 10, 10, 90, 85, "fire", "special");
	static Move leer = new Move("Leer", 30, 30, 100, 0, "normal", "status", "def", -1);
	static Random rNum = new Random();

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("New Game - N"
				+ "\n Load Game - L");
		String menuChoice = sc.next();
		if(menuChoice.equals("n") || menuChoice.equals("N")){
			characterCreation();
		} if(menuChoice.equals("l") || menuChoice.equals("L")){
			Load.load();
		}
		start();
	}
	
	public static void characterCreation(){
		Scanner sc = new Scanner(System.in);
		//this may be where the save file is loaded
		if(characterCreated == false){
			Inventory money = new Inventory("Money", 1000);
			Inventory item1 = new Inventory("Potion", 2, 300, 150);
			Inventory item2 = new Inventory("Super Potion", 0, 700, 350);
			Inventory item3 = new Inventory("Hyper Potion", 0, 1200, 600);
			Inventory item4 = new Inventory("Ether", 3, 3000, 1500);
			Inventory item5 = new Inventory("Max Ether", 0, 6000, 3000);
			Inventory item6 = new Inventory("PokeBall", 1, 5, 200, 100);
			Inventory item7 = new Inventory("GreatBall", 1.5, 2, 600, 300);
			Inventory item8 = new Inventory("Ultra Ball", 2, 1, 800, 400);
			Inventory item9 = new Inventory("Master Ball", 255, 0, 0, 0);
			
			inv.add(money);
			inv.add(item1);
			inv.add(item2);
			inv.add(item3);
			inv.add(item4);
			inv.add(item5);
			inv.add(item6);
			inv.add(item7);
			inv.add(item8);
			inv.add(item9);
			System.out.println("What is your character's name: ");
			String characterName = sc.nextLine();
			
			//String characterName = "David";
			//i should probably connect the lv to how the stats increase on start up
			String type = "fire";
			int baseHp = rNum.nextInt(6) + 39;
			int baseAtk = rNum.nextInt(4) + 49;
			int baseDef = rNum.nextInt(23) + 43;
			int baseSAtk = rNum.nextInt(15) + 50;
			int baseSDef = rNum.nextInt(15) + 50;
			int baseSpd = rNum.nextInt(20) + 45;
			int lv = 5;
			int exp = 0;
			int totalExp = 0;
			String expType = "";
			for(int i = 1; i < lv; i++){
				baseHp += rNum.nextInt(5);
				baseAtk += rNum.nextInt(5);
				baseDef += rNum.nextInt(5);
				baseSAtk += rNum.nextInt(5);
				baseSDef += rNum.nextInt(5);
				baseSpd += rNum.nextInt(5);
				int expNeeded = levelingSystem.expNeeded(i) - exp;
				totalExp += expNeeded;
			}
			ArrayList<Move> moveset = new ArrayList<Move>();
			
			moveset.add(waterGun);
			moveset.add(leer);
			moveset.add(blazeKick);
			moveset.add(null);
			starter = new characters(characterName, type, baseHp, baseHp, baseAtk, baseDef, baseSAtk, baseSDef, baseSpd,
					0, 0, 0, 0, 0, 0, 0, 0, lv, exp, totalExp, expType, moveset);
			party.add(starter);
			currentCharacter = party.get(0);
			characterCreated = true;
		}
	}
	
	public static void start() {
	//this portion is for testing i will have to find a way to reorganize the party array and moveset1 assignment
		System.out.print(
				"\n1)Random Fight"
				+ "\n2)Gym"
				+ "\n3)PokeCenter\n\n");
		if(currentEnemy == null || currentEnemy.getHp() <= 0){
		String eName = "Enemy";
		String eType = "fire";
		int eHp = rNum.nextInt(6) + 39;
		int eAtk = rNum.nextInt(4) + 49;
		int eDef = rNum.nextInt(23) + 43;
		int eSAtk = rNum.nextInt(15) + 50;
		int eSDef = rNum.nextInt(15) + 50;
		int eSpd = rNum.nextInt(20) + 45;
		int baseExp = rNum.nextInt(572) + 36;
		int catchRate = 255;// rNum.nextInt(200) + 75;
		int basePay = rNum.nextInt(240);
		int eLv = rNum.nextInt(5) + currentCharacter.getLevel();
		for(int i = 1; i < eLv; i++){
			eHp += rNum.nextInt(5);
			eAtk += rNum.nextInt(5);
			eDef += rNum.nextInt(5);
			eSAtk += rNum.nextInt(5);
			eSDef += rNum.nextInt(5);
			eSpd += rNum.nextInt(5);
		}
		ArrayList<Move> eMoveset = new ArrayList<Move>();
		//eMoveset.add(ember);
		eMoveset.add(waterGun);
		eMoveset.add(leer);
		currentEnemy = new enemy(eName, eType, eHp, eHp, eAtk, eDef, eSAtk, eSDef, eSpd, 0, 0, 0, 0, 0, 0, 0, 0, eLv, eMoveset, baseExp, catchRate, basePay);
		}
		//issue with the item menu when i call back to the start method 
		//it creates new characters i need to separate a portion of the start method to another method so it wont affect these variables
		//: solved made the current character and enemy static and this allow me to make the call to items and maintain the character on the call back
		Scanner sc = new Scanner(System.in);
		
		Items Item = new Items();
		
		int quit = 0;
		while(quit != -1){
			//might have to edit this if statement if i add more playable characters
			if(currentEnemy.getHp() <= 0 || capture == 1){
				quit = -1;
				if(capture != 1){
					System.out.println("\n" + currentEnemy.name + " has fainted. you win." );
					currentCharacter.resetStageValues();
					currentCharacter.ls.expGain(currentCharacter, currentEnemy);
					battleMoney(currentEnemy, inv);
					
				} else {
					currentEnemy = null;
					capture = 0;
				} 
				//i will make changes later but for now this just allows us to go back into the ui and save the exp
				System.out.println("Do you want to battle again? y/n | To go to the shop press s");
				String endChoice = sc.next();
				if(endChoice.equals("y") || endChoice.equals("Y")){
					//by calling the start() it resets the exp value i need to find a way to save the value and reenter the battle
					start();
				}
				else if(endChoice.equals("s") || endChoice.equals("S")){
					shop();
				}
				}
			if(currentCharacter.getHp() <= 0){
				quit = -1;
				System.out.println("\n" + currentCharacter.name + " has fainted. you lose.");
			}
			
			System.out.println(currentCharacter.name + " Lv:" +currentCharacter.level +"  "+currentCharacter.hp +"/"+currentCharacter.maxHP +"\n" +
			currentEnemy.name+ " Lv:" +currentEnemy.level +"  "+currentEnemy.hp +"/"+ currentEnemy.maxHP);
			System.out.println("\n1)Fight"
					+"\n2)Change Character"
					+"\n3)Items"
					+"\n4)Run"
					+ "\n5)Stats"
					+ "\n6)Save Game"
					+ "\n7)Load Game");
			switch(sc.next()){
			case "1":{
				for(int i = 0; i < currentCharacter.moveset.size(); i++){
					if(currentCharacter.moveset.get(i) != null)
					System.out.println((i+1)+")" + currentCharacter.moveset.get(i).name + " " +
					currentCharacter.moveset.get(i).pp + " / " + currentCharacter.moveset.get(i).getMaxPp());
				}
				System.out.println("Press x to go back");
				switch(sc.next()){
				//need to add a way to access the moveset and perform damage :Done
				case "1":{
					if( currentCharacter.moveset.get(0) != null){
						if(currentCharacter.moveset.get(0).getPp() > 0){
							//if()
							currentCharacter.moveset.get(0).setPp(currentCharacter.moveset.get(0).getPp()-1);
	/*rather than call the battle function i should create and call a different function with in
	 *  the fight class that will use speed to determine who goes first :done but kept battle as the method name
	 */
							fight.battle(currentCharacter, 0, currentEnemy);
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
						currentCharacter.moveset.get(1).setPp(currentCharacter.moveset.get(1).getPp()-1);
						fight.battle(currentCharacter, 1, currentEnemy);
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
							currentCharacter.moveset.get(2).setPp(currentCharacter.moveset.get(2).getPp()-1);
							fight.battle(currentCharacter, 2, currentEnemy);
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
							currentCharacter.moveset.get(3).setPp(currentCharacter.moveset.get(3).getPp()-1);
							fight.battle(currentCharacter, 3, currentEnemy);
							}else{
								System.out.println("You have ran out of PP for that move!");
							}
						}else{
							System.out.println("No Move");
						}
					break;
				}
				case "x":{
				}
				}
				break;
			}
			case "2":{
				for(int i = 0; i < party.size(); i++){
					if(party.get(i) != null)
					System.out.println((i+1)+")" + party.get(i).name + " " +
					party.get(i).getHp() + " / " + party.get(i).getMaxHP());
				}
				int characterChoice = sc.nextInt() - 1;
				System.out.println("You have selected " + party.get(characterChoice).name);
				currentCharacter = party.get(characterChoice);
				break;
			}
			case "3":{
				Item.items(currentCharacter, currentEnemy);
				break;
			}
			case "4":{
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
			case "5":{
				System.out.println("Who stats do you want to view? 1)Character 2)Enemy");
				int statChoice = sc.nextInt();
				if(statChoice == 1){
					System.out.println(currentCharacter.getName() + " "
							+ "Lv: " + currentCharacter.getLevel()+ "\n"
							+ "Exp: " + currentCharacter.getExp()+"\n"
							+ "Exp to next Lv: " + currentCharacter.ls.expNeeded(currentCharacter.getLevel())+"\n"
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
							+"Base EXP: "+currentEnemy.getBaseExp()+"\n"
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
			case "6":{
				System.out.println("Do you want to save your game? y/n");
				String saveChoice = sc.next();
				if(saveChoice.equals("y") || saveChoice.equals("Y")){
					Save.save();
				}
				break;
			}
			case "7":{
				System.out.println("Do you want to load your game? y/n");
				String loadChoice = sc.next();
				if(loadChoice.equals("y") || loadChoice.equals("Y")){
					Load.load();
				}
				break;
			}
			}
		}//end of while loop
	sc.close();}
	
	public static void shop(){
		System.out.println("What do you want to buy?\n"
				+ "Current Money: " + inv.get(0).getMoney() + "\n"
						+ "Press x to exit\n");
		for(int i = 1; i < inv.size(); i++){
			System.out.println(i+")"+inv.get(i).getName()+" :" + inv.get(i).getCost());
		}
				/*+ "\n1)Potion :" + inv.get(1).getCost()
				+ "\n2)Super Potion" + inv.get(2).getCost()
				+ "\n3)Hyper Potion" + inv.get(3).getCost()
				+ "\n4)Ether" + inv.get(4).getCost()
				+ "\n5)Super Ether" + inv.get(1).getCost()
				+ "\n6)Hyper Ether" + inv.get(1).getCost()
				+ "\n7)PokeBall" + inv.get(1).getCost()
				+ "\n8)Great Ball" + inv.get(1).getCost()
				+ "\n9)Ultra Ball" + inv.get(1).getCost()
				+ "\n10)Master Ball" + inv.get(1).getCost());*/
		String itemChoice = sc.next();
		int i = 0;
		switch(itemChoice){
		case "1":{i = 1; break;}
		case "2":{i = 2; break;}
		case "3":{i = 3; break;}
		case "4":{i = 4; break;}
		case "5":{i = 5; break;}
		case "6":{i = 6; break;}
		case "7":{i = 7; break;}
		case "8":{i = 8; break;}
		case "9":{i = 9; break;}
		case "x":{start(); break;}
		}
		System.out.println("You selected " + inv.get(i).getName() + ". You currently have:"+ inv.get(i).getQuantity() + " How many would you like to buy?");
		int quantity = sc.nextInt();
		int totalPrice = quantity * inv.get(i).getSellPrice();
		if(inv.get(0).getMoney() >= totalPrice){
			System.out.print("You have bought " + quantity + inv.get(i).getName());
			if(quantity > 1){
				System.out.println("s");
				
			}else{
				System.out.println("\n");
			}
			inv.get(i).setQuantity(quantity);
			inv.get(0).setMoney(inv.get(0).getMoney() - totalPrice);
			shop();
		}else{
			System.out.println("You don't have enough money!");
			shop();
		}
	}

	public static void battleMoney(enemy currentEnemy, ArrayList<Inventory> inv){
		int payOut = currentEnemy.basePay * currentEnemy.getLevel(); 
		System.out.println("You have won " + payOut + " money.");
		inv.get(0).setMoney(inv.get(0).getMoney() + payOut);
	}
}