import java.util.ArrayList;
import java.util.Scanner;

class gym{
    public static ArrayList<enemy> eParty;
    public static void main(String[] args){
        gym d = new gym();
        d.init();
    }
    public void init(){
        System.out.println("Which gym would you like to challenge?");
        String [] gyms  = {
            "Gym 1: Tony ",
            "Gym 2: Blaine",
            "Gym 3: Victoria",
            "Gym 4: Dom",
            "Gym 5: Rita",
            "Gym 6: Walter",
            "Gym 7: Max",
            "Gym 8: Chris"

        };
        for (String gym : gyms) {
            System.out.println(gym);
        }
        Scanner s = new Scanner(System.in);
        int gymChoice = s.nextInt();

        enemy [] gymOps = {};

        switch(gymChoice){
            case 1:{
               // gymOps = {

                //};
                break;
            }
            case 2:{
                break;
            }
            case 3:{
                break;
            }
            case 4:{
                break;
            }
            case 5:{
                break;
            }
            case 6:{
                break;
            }
            case 7:{
                break;
            }
            case 8:{
                break;
            }
        }
        s.close();
    }
}