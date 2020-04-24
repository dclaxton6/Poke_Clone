import java.util.ArrayList;

class inventory{

    private String name;
	private int quantity;
	private int cost;
	private int sellPrice;
	private int money;
    private double ballMultiplier;
    public static ArrayList<inventory> initInv = new ArrayList<inventory>();
    
    public inventory(Builder builder){
        this.name = builder.name;
        this.quantity = builder.quantity;
        this.cost = builder.cost;
        this.sellPrice = builder.sellPrice;
        this.money = builder.money;
        this.ballMultiplier = builder.ballMultiplier;
    }

    public inventory() {
	}

	public static class Builder{
        private String name;
        private int quantity;
        private int cost;
        private int sellPrice;
        private int money;
        private double ballMultiplier;

        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }
        public Builder cost(int cost){
            this.cost = cost;
            return this;
        }
        public Builder sellPrice(int sellPrice){
            this.sellPrice = sellPrice;
            return this;
        }
        public Builder money(int money){
            this.money = money;
            return this;
        }
        public Builder ballMultiplier(double ballMultiplier){
            this.ballMultiplier = ballMultiplier;
            return this;
        }
        public inventory build(){
            return new inventory(this);
         }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getSellPrice() {
        return sellPrice;
    }
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public double getBallMultiplier() {
        return ballMultiplier;
    }
    public void setBallMultiplier(double ballMultiplier) {
        this.ballMultiplier = ballMultiplier;
    }
    public static ArrayList<inventory> createInventory(){
        inventory money = new inventory.Builder().withName("Money").money(1000).build();
        inventory item1 = new inventory.Builder().withName("Potion").quantity(2).cost(300).sellPrice(150).build();
        inventory item2 = new inventory.Builder().withName("Super Potion").quantity(0).cost(700).sellPrice(350).build();
		inventory item3 = new inventory.Builder().withName("Hyper Potion").quantity(0).cost(12000).sellPrice(600).build();
		inventory item4 = new inventory.Builder().withName("Ether").quantity(3).cost(30000).sellPrice(1500).build();
        inventory item5 = new inventory.Builder().withName("Max Ether").quantity(0).cost(6000).sellPrice(3000).build();
        inventory item6 = new inventory.Builder().withName("PokeBall").ballMultiplier(1).quantity(5).cost(200).sellPrice(100).build();
        inventory item7 = new inventory.Builder().withName("GreatBall").ballMultiplier(1.5).quantity(2).cost(600).sellPrice(300).build();
        inventory item8 = new inventory.Builder().withName("Ultra Ball").ballMultiplier(2).quantity(1).cost(800).sellPrice(400).build();
        inventory item9 = new inventory.Builder().withName("Master Ball").ballMultiplier(255).quantity(0).cost(0).sellPrice(0).build();
            
        initInv.add(money);
        initInv.add(item1);
        initInv.add(item2);
        initInv.add(item3);
        initInv.add(item4);
        initInv.add(item5);
        initInv.add(item6);
        initInv.add(item7);
        initInv.add(item8);
        initInv.add(item9);

        return initInv;
    }
    // public void loadInventory(ArrayList<Inventory> inv){
		
	// }
}