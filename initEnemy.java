import java.util.ArrayList;
import java.util.Random;

class initEnemy{
    Random rNum = new Random();
    int typeChoice;
    String moveType;
    Move moveChoice;
    ArrayList<Move> moves = new ArrayList<Move>(4);
    String name;
    String type1;
    String type2;
    int baseHp;
    int baseAtk;
    int baseDef;
    int baseSAtk;
    int baseSDef;
    int baseSpd;
    int expGiven;
    int catchRate;
    int moneyGiven;
    levelingSystem ls = new levelingSystem();
    String[] names = {
        "NGrass",
        "Nwater",
        "Nfire"
    };

    public enemy create(){
        typeChoice = 1;//rNum.nextInt(2);
        
        switch(typeChoice){
            case 1:{
                moveChoice = new Move.Builder().initialMoveName("Razor Leaf").moveType("grass").initialPp(25).initialPower(55).moveCategory("physical").moveAcc(95).build();
                name = names[0];
                type1 = "grass";
                break;
            }
            case 2:{
                moveChoice = new Move.Builder().initialMoveName("Water Gun").moveType("water").initialPp(25).initialPower(40).moveCategory("special").moveAcc(100).build();
                name = names[1];
                type1 = "water";
                break;
            }
            case 3:{
                moveChoice = new Move.Builder().initialMoveName("Ember").moveType("fire").initialPp(25).initialPower(40).moveCategory("special").moveAcc(100).build();
                name = names[2];
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

        //need to create some time of level/move list and scrap what's below
        moves.add(moveChoice); //moves[0] = moveChoice;
        moves.add(moveChoice);
        moves.add(moveChoice);
        moves.add(moveChoice);

        enemy e = new enemy.Builder()
        .withName(name)
        .setType1(type1)
        .currentHp(baseHp)
        .maxHp(baseHp)
        .baseAtk(baseAtk)
        .baseDef(baseDef)
        .baseAtk(baseDef)
        .baseDef(baseDef)
        .baseSAtk(baseSAtk)
        .baseSDef(baseSDef)
        .baseSpd(baseSpd)
        .baseAcc(0)
        .baseEva(0)
        .baseStage_Atk(0)
        .baseStage_Def(0)
        .baseStage_SAtk(0)
        .baseStage_SDef(0)
        .baseStage_Acc(0)
        .baseStage_Eva(0)
        .level(rNum.nextInt(2) + 1)
        .moveset(moves)
        .expGiven(100200)
        .catchRate(0) //edit later based on calculation
        .moneyGiven(100)
        .build();

        ls.levelStats(e, 0);
        return e;

    }

}