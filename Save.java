import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Save {
	public saveFile s;
	public ObjectOutputStream output;
	
	public void openFile(){
		
		try{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("save.txt"));
			System.out.print("Creating file\n");
		} catch(IOException io){
			System.out.println("Error trying to save file.");
		}
	}
	
	public void saveGame(){
		try{		
			output.writeObject(new saveFile(test.party, test.inv));
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
		}catch(IOException io){
			System.err.println( "Error closing file." );
		}
	}
	
	public static void save(){
		Save save = new Save();
		save.openFile();
		save.saveGame();
		save.closeFile();
	}
}