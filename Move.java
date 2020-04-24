class Move{
    private String moveName;
    private int pp;
    private int maxPp;
    private int power;
    private String moveType;
    private String moveCategory;
    private int moveAcc;
    private String stat;
	private int stage;

   private Move(Builder builder){
       this.moveName = builder.moveName;
       this.pp = builder.pp;
       this.maxPp = builder.maxPp;
       this.power = builder.power;
       this.moveType = builder.moveType;
       this.moveCategory = builder.moveCategory;
       this.moveAcc =  builder.moveAcc;
       this.stat = builder.stat;
       this.stage = builder.stage;
   }

    public static class Builder{
        private String moveName;
        private int pp;
        private int maxPp;
        private int power;
        private String moveType;
        private String moveCategory;
        private int moveAcc;
        private String stat;
        private int stage;


        public Builder initialMoveName(String moveName){
            this.moveName = moveName;
            return this;
        }
        public Builder initialPp(int pp){
            this.pp = pp;
            return this;
        }
        public Builder maxPp(int maxPp){
            this.maxPp = maxPp;
            return this;
        }
        public Builder initialPower(int power){
            this.power = power;
            return this;
        }
        public Builder moveType(String moveType){
            this.moveType = moveType;
            return this;
        }
        public Builder moveCategory(String moveCategory){
            this.moveCategory = moveCategory;
            return this;
        }
        public Builder moveAcc(int moveAcc){
            this.moveAcc = moveAcc;
            return this;
        }
        public Builder stat(String stat){
            this.stat = stat;
            return this;
        }
        public Builder stage(int stage){
            this.stage = stage;
            return this;
        }
        public Move build(){
            return new Move(this);
        }
    }

    public String getMoveName() {
        return moveName;
    }
    public int getPp() {
        return pp;
    }
    public void setPp(int pp) {
        this.pp = pp;
    }
    public int getMaxPp() {
        return maxPp;
    }
    public void setMaxPp(int maxPp) {
        this.maxPp = maxPp;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public String getMoveType() {
        return moveType;
    }
    public String getMoveCategory() {
        return moveCategory;
    }
    public int getMoveAcc() {
        return moveAcc;
    }
    public void setMoveAcc(int moveAcc) {
        this.moveAcc = moveAcc;
    }
    public String getStat() {
        return stat;
    }
    public void setStat(String stat) {
        this.stat = stat;
    }
    public int getStage() {
        return stage;
    }
    public void setStage(int stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "move "+
        " (Move Name= " + moveName +
         ", pp= " + pp + "/" + maxPp +
         ", power= " + power + 
         ", Move Type= " + moveType + 
         ", Move Category= " + moveCategory +
         ", Move Accuracy= " + moveAcc + ")";
    }
}