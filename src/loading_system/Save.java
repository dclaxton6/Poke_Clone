package loading_system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Test.Inventory;
import Test.MainMenu;
import Test.characters;

public class Save {

	public ObjectOutputStream output;
	
	public void openFile(){
		
		try{
			output = new ObjectOutputStream(new FileOutputStream("save.ser"));
			System.out.print("Creating file\n");
		} catch(IOException io){
			System.out.println("Error trying to save file.");
		}
	}
	
	public void saveGame(){
		ArrayList<characters> main;
		ArrayList<Inventory> inv;
		main = MainMenu.party;
		inv = MainMenu.inv;
		saveFile sf = new saveFile(main, inv);
		
		try{		
			
			//saveFile save = new saveFile(main, enemy);
			output.writeObject(sf);
			System.out.print("Saving file\n");
		} catch(IOException io){
			System.err.println( "Error writing to file." );
			return;
		}
	}
		
	public void closeFile(){
		try{
			if(output != null){
				output.close();
			}
		}catch(IOException io){}
	}
	
	public static void save(){
		Save save = new Save();
		save.openFile();
		save.saveGame();
		save.closeFile();
	}
}