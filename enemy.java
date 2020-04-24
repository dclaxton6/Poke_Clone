import java.util.ArrayList;

class enemy extends creature{
    private int expGiven;
    private int catchRate;
    private int moneyGiven;

    public enemy(Builder builder){
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
        this.moveset = builder.moveset;
        this.expGiven = builder.expGiven;
        this.catchRate = builder.catchRate;
        this.moneyGiven = builder.moneyGiven;
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
        private int stage_atk;
        private int stage_def;
        private int stage_sAtk;
        private int stage_sDef;
        private int stage_spd;
        private int stage_acc;
        private int stage_eva;
        private int level;
        private ArrayList<Move> moveset = new ArrayList<Move>(4);
        private int expGiven;
        private int catchRate;
        private int moneyGiven;

        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder setType1(String type1){
            this.type1 = type1;
            return this;
        }
        public Builder setType2(String type2){
            this.type2 = type2;
            return this;
        }
        public Builder currentAtk(int atk){
            this.atk = atk;
            return this;
        }
        public Builder currentDef(int def){
            this.def = def;
            return this;
        }
        public Builder currentSpd(int spd){
            this.spd = spd;
            return this;
        }
        public Builder currentSAtk(int sAtk){
            this.sAtk = sAtk;
            return this;
        }
        public Builder currentSDef(int sDef){
            this.sDef = sDef;
            return this;
        }
       
        public Builder currentHp(int currentHp){
            this.currentHp = currentHp;
            return this;
        }
        public Builder maxHp(int maxHp){
            this.maxHp = maxHp;
            return this;
        }
        public Builder baseHp(int baseStatHp){
            this.baseStatHp = baseStatHp;
            return this;
        }
        public Builder baseAtk(int baseStatAtk){
            this.baseStatAtk = baseStatAtk;
            return this;
        }
        public Builder baseDef(int baseStatDef){
            this.baseStatDef = baseStatDef;
            return this;
        }
        public Builder baseSpd(int baseStatSpd){
            this.baseStatSpd = baseStatSpd;
            return this;
        }
        public Builder baseSAtk(int baseStatSAtk){
            this.baseStatSAtk =baseStatSAtk;
            return this;
        }
        public Builder baseSDef(int baseStatSDef){
            this.baseStatSDef = baseStatSDef;
            return this;
        }
        public Builder baseAcc(int acc){
            this.acc = acc;
            return this;
        }
        public Builder baseEva(int eva){
            this.eva = eva;
            return this;
        }
        public Builder expGiven(int expGiven){
            this.expGiven = expGiven;
            return this;
        }
        public Builder baseStage_Atk(int stage_atk){
            this.stage_atk = stage_atk;
            return this;
        }
        public Builder baseStage_Def(int stage_def){
            this.stage_def = stage_def;
            return this;
        }
        public Builder baseStage_SAtk(int stage_sAtk){
            this.stage_sAtk = stage_sAtk;
            return this;
        }
        public Builder baseStage_SDef(int stage_sDef){
            this.stage_sDef = stage_sDef;
            return this;
        }
        public Builder baseStage_Spd(int stage_spd){
            this.stage_spd = stage_spd;
            return this;
        }
        public Builder baseStage_Acc(int stage_acc){
            this.stage_acc = stage_acc;
            return this;
        }
        public Builder baseStage_Eva(int stage_eva){
            this.stage_eva = stage_eva;
            return this;
        }
        public Builder level(int level){
            if(level > 1){
                //add call to method for leveling stats
            }
            this.level = level;
            return this;
        }
        public Builder moveset(ArrayList<Move> moveset){
            this.moveset = moveset;
            return this;
        }
        public Builder catchRate(int catchRate){
            this.catchRate = catchRate;
            return this;
        }
        public Builder moneyGiven(int moneyGiven){
            this.moneyGiven = moneyGiven;
            return this;
        }
        public enemy build(){
           return new enemy(this);
        }
    }

    public int getExpGiven() {
        return expGiven;
    }
    public void setExpGiven(int expGiven) {
        this.expGiven = expGiven;
    }
    public int getCatchRate() {
        return catchRate;
    }
    public void setCatchRate(int catchRate) {
        this.catchRate = catchRate;
    }
    public int getMoneyGiven() {
        return moneyGiven;
    }
    public void setMoneyGiven(int moneyGiven) {
        this.moneyGiven = moneyGiven;
    }

    @Override
    public String toString() {
        return "enemy "+
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
        "\n, exp given= " + expGiven +
        "\n, money given= " + moneyGiven +
        "\n, catch rate=" + catchRate + "]";
    }
}