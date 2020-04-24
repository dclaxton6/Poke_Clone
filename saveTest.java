import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class saveTest {
    public static void main(String[] args){
        String s = "Hello world!";
        int i = 897648764;
        
        try {
           // create a new file with an ObjectOutputStream
           FileOutputStream out = new FileOutputStream("save1.txt");
           ObjectOutputStream oout = new ObjectOutputStream(out);
  
           // write something in the file
           oout.writeObject(s);
           oout.writeObject(i);
  
           // close the stream
           oout.close();
  
           // create an ObjectInputStream for the file we created before
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save1.txt"));
  
           // read and print what we wrote before
           System.out.println("" + (String) ois.readObject());
           System.out.println("" + ois.readObject());
        } catch (Exception ex) {
           ex.printStackTrace();
        }
     }
  }