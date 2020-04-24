
import java.util.ArrayList;
import java.util.Scanner;

class test{
    public static run r = new run();
    public static String NoD;
    public static ArrayList<character> party = new ArrayList<character>();
    public static ArrayList<inventory> inv = inventory.createInventory();
    
    public static void main(String[] args){

        initChar ic = new initChar();
        
        Scanner s = new Scanner(System.in);
        String[] menuOp = {
           "New - N",
           "Load - L"
        };
        //while v does not equal quit continue
        for(String option : menuOp){
            System.out.println(option);
        }
       
        NoD = s.nextLine().toLowerCase();
        switch(NoD){
            case "n":{
                //quit value true
                
                r.start(ic.create());
                break;
            }
            case "l":{
                System.out.println("load");
                Load.load();
                //quit value true
                break;
            }
            default:{
                System.out.println("default");
                //test.main(args);

            }
        }
        s.close();
    }
}