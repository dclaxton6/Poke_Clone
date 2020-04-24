import java.util.ArrayList;

abstract class creature{
    protected String name;
    protected String type1;
    protected String type2;
    protected int currentHp;
    protected int maxHp;
    protected int atk;
    protected int def;
    protected int spd;
    protected int sAtk;
    protected int sDef;

    protected int baseStatHp;
    protected int baseStatAtk;
    protected int baseStatDef;
    protected int baseStatSpd;
    protected int baseStatSAtk;
    protected int baseStatSDef;

    protected int acc;
    protected int eva;
    protected int stage_atk;
	protected int stage_def;
	protected int stage_sAtk;
	protected int stage_sDef;
	protected int stage_spd;
	protected int stage_acc;
	protected int stage_eva;
	protected int level;
    protected ArrayList<Move> moveset = new ArrayList<Move>(4);
        
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType1() {
        return type1;
    }
    public void setType1(String type1) {
        this.type1 = type1;
    }
    public String getType2() {
        return type2;
    }
    public void setType2(String type2) {
        this.type2 = type2;
    }
    public int getCurrentHp() {
        return currentHp;
    }
    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    public ArrayList<Move> getMoveset() {
            return moveset;
        }
    public void setMoveset(ArrayList<Move> moveset) {
            this.moveset = moveset;
        }
    public int getBaseStatHp() {
        return baseStatHp;
    }
    public void setBaseStatHp(int baseStatHp) {
        this.baseStatHp = baseStatHp;
    }
    public int getBaseStatAtk() {
        return baseStatAtk;
    }
    public void setBaseStatAtk(int baseStatAtk) {
        this.baseStatAtk = baseStatAtk;
    }
    public int getBaseStatDef() {
        return baseStatDef;
    }
    public void setBaseStatDef(int baseStatDef) {
        this.baseStatDef = baseStatDef;
    }
    public int getBaseStatSpd() {
        return baseStatSpd;
    }
    public void setBaseStatSpd(int baseStatSpd) {
        this.baseStatSpd = baseStatSpd;
    }
    public int getBaseStatSAtk() {
        return baseStatSAtk;
    }
    public void setBaseStatSAtk(int baseStatSAtk) {
        this.baseStatSAtk = baseStatSAtk;
    }
    public int getBaseStatSDef() {
        return baseStatSDef;
    }
    public void setBaseStatSDef(int baseStatSDef) {
            this.baseStatSDef = baseStatSDef;
        }    
    public int getAtk() {
            return atk;
        }
    public void setAtk(int atk) {
            this.atk = atk;
        }
    public int getDef() {
            return def;
        }
    public void setDef(int def) {
            this.def = def;
        }
    public int getSpd() {
            return spd;
        }
    public void setSpd(int spd) {
            this.spd = spd;
        }
    public int getSAtk() {
            return sAtk;
        }
    public void setSAtk(int sAtk) {
            this.sAtk = sAtk;
        }
    public int getSDef() {
            return sDef;
        }
    public void setSDef(int sDef) {
            this.sDef = sDef;
        }
    public int getAcc() {
            return acc;
        }
    public void setAcc(int acc) {
            this.acc = acc;
        }
    public int getEva() {
            return eva;
        }
    public void setEva(int eva) {
            this.eva = eva;
        }
    public int getStage_atk() {
            return stage_atk;
        }
    public void setStage_atk(int stage_atk) {
            this.stage_atk = stage_atk;
        }
    public int getStage_def() {
            return stage_def;
        }
    public void setStage_def(int stage_def) {
            this.stage_def = stage_def;
        }
    public int getStage_sAtk() {
            return stage_sAtk;
        }
    public void setStage_sAtk(int stage_sAtk) {
            this.stage_sAtk = stage_sAtk;
        }
    public int getStage_sDef() {
            return stage_sDef;
        }
    public void setStage_sDef(int stage_sDef) {
            this.stage_sDef = stage_sDef;
        }
    public int getStage_spd() {
            return stage_spd;
        }
    public void setStage_spd(int stage_spd) {
            this.stage_spd = stage_spd;
        }
    public int getStage_acc() {
            return stage_acc;
        }
    public void setStage_acc(int stage_acc) {
            this.stage_acc = stage_acc;
        }
    public int getStage_eva() {
            return stage_eva;
        }
    public void setStage_eva(int stage_eva) {
            this.stage_eva = stage_eva;
        }
    public int getLevel() {
            return level;
        }
    public void setLevel(int level) {
        this.level = level;
    }
    public void addMove(Move move){
		if(moveset.size() < 3){
		moveset.add(move);
		} else{
			System.out.println("you can not have more than 4 moves. Moves:" + moveset.size());
		}
	}
	public void removeMove(int move){
		moveset.remove(move);
	}
	public void loadMoveSet(ArrayList<Move> moveset){
		this.moveset = moveset;
	}
    public void resetStageValues(){
		setStage_atk(0);
		setStage_def(0);
		setStage_sAtk(0);
		setStage_sDef(0);
		setStage_spd(0);
		setStage_acc(0);
		setStage_eva(0);
	}
}