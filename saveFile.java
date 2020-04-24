
import java.util.ArrayList;

public class saveFile {
    public ArrayList<character> party;
	public ArrayList<inventory> inv;
	
	public saveFile(ArrayList<character> party, ArrayList<inventory> inv){
		this.party = party;
		this.inv = inv;
	}
}