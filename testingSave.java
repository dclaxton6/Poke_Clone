import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class testingSave implements Serializable{
    public saveFile s;
    static int r = 5;

    public static void main(final String[] args) throws IOException, ClassNotFoundException {

        // ObjectOutputStream output = new ObjectOutputStream(new
        // FileOutputStream("save.txt"));
        final FileOutputStream out = new FileOutputStream("save.txt");
        final ObjectOutputStream output = new ObjectOutputStream(out);
            System.out.print("Creating file\n");
 
            System.out.println("entering save");

            output.writeInt(r);
            // output.writeObject(new saveFile(test.party, test.inv));
            // System.out.print("Saving file\n");
      
                 output.close();
                 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.txt"));
  
                 // read and print what we wrote before
                 System.out.println("" + (String) ois.readObject());
                 System.out.println("" + ois.readObject());
     
    }
}