package loading_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Test.Inventory;
import Test.MainMenu;
import Test.characters;

public class Load {

	private ObjectInputStream sc;
	
	public void openFile(){
		try{
			
			sc = new ObjectInputStream(new FileInputStream("save.ser"));
		} catch (IOException io){
			System.err.println("Error opening file.");
		}
	}
	
	public void loadFile(){
		ArrayList<characters> party;
		ArrayList<Inventory>  inv;
		saveFile loadFile;
		try{
			while(true){
				loadFile = (saveFile) sc.readObject();
				party = loadFile.party;
				inv = loadFile.inv;
				MainMenu.currentCharacter.loadValues(party.get(0));
				for(int i = 0; i < party.size(); i++){
					MainMenu.party.add(party.get(i));
				}
				MainMenu.inv = inv;
				//below is the code i was going to go with before created the load values method
				/*
				MainMenu.currentCharacter.setName(main.name);
				MainMenu.currentCharacter.setHp(main.hp);
				MainMenu.currentCharacter.setMaxHP(main.maxHP);
				*/
				MainMenu.characterCreated = true;
			}
		}catch(ClassNotFoundException classNotFoundException){
			System.err.println( "Unable to create object." );
		}catch(IOException io){
			//System.err.println("Error during read from file.");
		}
	}
	
	public void closeFile(){
		try{
			if(sc != null){
				sc.close();
			}
		} catch (IOException io){
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}
	
	public static void load(){
		Load load = new Load();
		load.openFile();
		load.loadFile();
		load.closeFile();
	}
}