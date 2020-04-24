
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


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
		ArrayList<character> party;
		ArrayList<inventory> inv;
		saveFile loadsFile;
		try{
			while(true){
                System.out.println( "Entering Loading state." );
                loadsFile = (saveFile) sc.readObject();
                System.out.println( "read save file." );
				party = loadsFile.party;
                inv = loadsFile.inv;

                System.out.println( "set party/inv." );
				run.currentCharacter.loadValues(party.get(0));
				for(int i = 0; i < party.size(); i++){
					test.party.add(party.get(i));
				}
				test.inv = inv;
			}
		}catch(ClassNotFoundException classNotFoundException){
			
		}catch(IOException io){
			System.err.println("Error during read from file.");
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