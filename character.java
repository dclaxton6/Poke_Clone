import java.util.ArrayList;


class character extends creature{
    private int exp;
    private int totalExp;
    //private String expType;
    levelingSystem ls;

    public character(final Builder builder){
        this.name = builder.name;
        this.type1 = builder.type1;
        this.type2 = builder.type2;
        this.baseStatHp = builder.baseStatHp;
        this.baseStatAtk = builder.baseStatAtk;
        this.baseStatDef = builder.baseStatDef;
        this.baseStatSpd = builder.baseStatSpd;
        this.baseStatSAtk = builder.baseStatSAtk;
        this.baseStatSDef = builder.baseStatSDef;
        this.currentHp = builder.currentHp;
        this.maxHp = builder.maxHp;
        this.atk = builder.atk;
        this.def = builder.def;
        this.spd = builder.spd;
        this.sAtk = builder.sAtk;
        this.sDef = builder.sDef;
        this.acc = builder.acc;
        this.eva = builder.eva;
        this.stage_atk = builder.stage_atk;
	    this.stage_def = builder.stage_def;
	    this.stage_sAtk = builder.stage_sAtk;
	    this.stage_sDef = builder.stage_sDef;
	    this.stage_spd = builder.stage_spd;
	    this.stage_acc = builder.stage_acc;
	    this.stage_eva = builder.stage_eva;
        this.level = builder.level;
        this.ls = builder.ls;
        this.moveset = builder.moveset;
        this.exp = builder.exp;
        this.totalExp = builder.totalExp;
    }

    public static class Builder{
        private String name;
        private String type1;
        private String type2;
        private int baseStatHp;
        private int baseStatAtk;
        private int baseStatDef;
        private int baseStatSpd;
        private int baseStatSAtk;
        private int baseStatSDef;
        private int currentHp;
        private int maxHp;
        private int atk;
        private int def;
        private int spd;
        private int sAtk;
        private int sDef;
        private int acc;
        private int eva;
        private int exp;
        private int totalExp;
        private int stage_atk;
        private int stage_def;
        private int stage_sAtk;
        private int stage_sDef;
        private int stage_spd;
        private int stage_acc;
        private int stage_eva;
        private int level;
        private levelingSystem ls = new levelingSystem();
        private ArrayList<Move> moveset = new ArrayList<Move>(4);

        public Builder withName(final String name){
            this.name = name;
            return this;
        }
        public Builder type1(final String type1){
            this.type1 = type1;
            return this;
        }
        public Builder type2(final String type2){
            this.type2 = type2;
            return this;
        }
        
        public Builder baseHp(final int baseStatHp){
            this.baseStatHp = baseStatHp;
            return this;
        }
        public Builder baseAtk(final int baseStatAtk){
            this.baseStatAtk = baseStatAtk;
            return this;
        }
        public Builder baseDef(final int baseStatDef){
            this.baseStatDef = baseStatDef;
            return this;
        }
        public Builder baseSpd(final int baseStatSpd){
            this.baseStatSpd = baseStatSpd;
            return this;
        }
        public Builder baseSAtk(final int baseStatSAtk){
            this.baseStatSAtk =baseStatSAtk;
            return this;
        }
        public Builder baseSDef(final int baseStatSDef){
            this.baseStatSDef = baseStatSDef;
            return this;
        }
        
        public Builder currentHp(final int currentHp){
            this.currentHp = currentHp;
            return this;
        }
        public Builder maxHp(final int maxHp){
            this.maxHp = maxHp;
            return this;
        }
        public Builder currentAtk(final int atk){
            this.atk = atk;
            return this;
        }
        public Builder currentDef(final int def){
            this.def = def;
            return this;
        }
        public Builder currentSpd(final int spd){
            this.spd = spd;
            return this;
        }
        public Builder currentSAtk(final int sAtk){
            this.sAtk = sAtk;
            return this;
        }
        public Builder currentSDef(final int sDef){
            this.sDef = sDef;
            return this;
        }
        
        public Builder baseAcc(final int acc){
            this.acc = acc;
            return this;
        }
        public Builder baseEva(final int eva){
            this.eva = eva;
            return this;
        }
        public Builder baseExp(final int exp){
            this.exp = exp;
            return this;
        }
        public Builder totalExp(final int totalExp){
            this.totalExp = totalExp;
            return this;
        }
        public Builder baseStage_Atk(final int stage_atk){
            this.stage_atk = stage_atk;
            return this;
        }
        public Builder baseStage_Def(final int stage_def){
            this.stage_def = stage_def;
            return this;
        }
        public Builder baseStage_SAtk(final int stage_sAtk){
            this.stage_sAtk = stage_sAtk;
            return this;
        }
        public Builder baseStage_SDef(final int stage_sDef){
            this.stage_sDef = stage_sDef;
            return this;
        }
        public Builder baseStage_Spd(final int stage_spd){
            this.stage_spd = stage_spd;
            return this;
        }
        public Builder baseStage_Acc(final int stage_acc){
            this.stage_acc = stage_acc;
            return this;
        }
        public Builder baseStage_Eva(final int stage_eva){
            this.stage_eva = stage_eva;
            return this;
        }
        public Builder level(final int level){
            if(level > 1){
                //add call to method for leveling stats
            }
            this.level = level;
            return this;
        }
        public Builder levelingSystem(final levelingSystem ls){
            this.ls = ls;
            return this;
        }
        public Builder moveset(final ArrayList<Move> moveset){
            this.moveset = moveset;
            return this;
        }
        public character build(){
           return new character(this);
        }
    }

    public int getExp() {
        return exp;
    }
    public void setExp(final int exp) {
        this.exp = exp;
    }
    public int getTotalExp() {
        return totalExp;
    }
    public void setTotalExp(final int totalExp) {
        this.totalExp = totalExp;
    }

    public void loadValues(final character c){
        setName(c.name);
        setType1(c.type1);
        setType2(type2);
        setCurrentHp(c.currentHp);
        setMaxHp(c.maxHp);
        setAtk(c.atk);
        setDef(c.def);
        setSAtk(c.sAtk);
		setSDef(c.sDef);
        setSpd(c.spd);
		setAcc(c.acc);
        setEva(c.eva);
        setStage_atk(c.stage_atk);
		setStage_def(c.stage_def);
		setStage_sAtk(c.stage_sAtk);
		setStage_sDef(c.stage_sDef);
		setStage_acc(c.stage_acc);
        setStage_eva(c.stage_eva);
        setLevel(c.level);
		loadMoveSet(c.moveset);
		setExp(c.exp);
    }
    
    @Override
    public String toString() {
        return "character "+
        "\n [name= " + name +
        "\n, type1= " + type1 +
        "\n, type2= " + type2 + 
        "\n, current hp= " + currentHp + 
         "\n, max hp= " + maxHp + 
         "\n, atk= " + atk + 
         "\n, def= " + def +
         "\n, sAtk= " + sAtk +
         "\n, sDef= " + sDef +
         "\n, spd= " + spd +
         "\n, acc= " + acc +
         "\n, eva= " + eva +
          "\n, moveset=" + moveset + 
          "\n, exp= " + exp + "]";
    }
}