package loading_system;

import java.io.Serializable;
import java.util.ArrayList;
import Test.Inventory;
import Test.characters;

public class saveFile implements Serializable {
	public ArrayList<characters> party;
	public ArrayList<Inventory> inv;
	
	public saveFile(ArrayList<characters> party, ArrayList<Inventory> inv){
		this.party = party;
		this.inv = inv;
	}
}