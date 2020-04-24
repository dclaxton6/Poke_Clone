import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
class initChar{
    Scanner s = new Scanner(System.in);
    int typeChoice;
    String moveType;
    Move moveChoice;
    ArrayList<Move> moves = new ArrayList<Move>(4);
    String charName;
    Random rNum = new Random();
    String type1;
    String type2;
    int baseHp;
    int baseAtk;
    int baseDef;
    int baseSAtk;
    int baseSDef;
    int baseSpd;


    //rewrite to merge initEnemy into this class
    public character create(){

        //  System.out.print("What type is your character? "
        //                 +"\n 1)Grass 2)Water 3)Fire"
        //                  +"\n");

        typeChoice =  3; // s.nextInt();
        switch(typeChoice){
            case 1:{
                moveChoice = new Move.Builder().initialMoveName("Razor Leaf").moveType("grass").maxPp(25).initialPp(25).initialPower(55).moveCategory("physical").moveAcc(95).build();
                type1 = "grass";
                break;
            }
            case 2:{
                moveChoice = new Move.Builder().initialMoveName("Water Gun").moveType("water").maxPp(25).initialPp(25).initialPower(40).moveCategory("special").moveAcc(100).build();
                type1 = "water";
                break;
            }
            case 3:{
                moveChoice = new Move.Builder().initialMoveName("Ember").moveType("fire").maxPp(25).initialPp(25).initialPower(40).moveCategory("physical").moveAcc(100).build();
                type1 = "fire";
                break;
            }
        }

        baseHp = rNum.nextInt(6) + 39;
        baseAtk = rNum.nextInt(4) + 49;
        baseDef = rNum.nextInt(23) + 43;
        baseSAtk = rNum.nextInt(15) + 50;
        baseSDef = rNum.nextInt(15) + 50;
        baseSpd = rNum.nextInt(20) + 45;

        // System.out.print("What is your(Character) name? ");
        // charName = s.next();

        moves.add(moveChoice);
        character d = new character.Builder()
        //.withName(charName)
         .withName("David")
        .type1(type1)
        .type2(type2)
        .currentHp(baseHp)
        .maxHp(baseHp)
        .baseAtk(baseAtk)
        .baseDef(baseDef)
        .baseSAtk(baseSAtk)
        .baseSDef(baseDef)
        .baseSpd(baseSpd)
        .baseAcc(0)
        .baseEva(0)
        .baseStage_Atk(0)
        .baseStage_Def(0)
        .baseStage_SAtk(0)
        .baseStage_SDef(0)
        .baseStage_Acc(0)
        .baseStage_Eva(0)
        .level(1) //edit
        .moveset(moves)
        .baseExp(0)
        .totalExp(0)
        .build();

        test.party.add(d);
        d.ls.levelStats(d,0);
        return d;
    }
    
    
    
}