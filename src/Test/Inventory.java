package Test;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
	public String name;
	public int quantity;
	public int cost;
	public int sellPrice;
	public int money;
	public double ballMultiplier;
	
	public Inventory(String name, int money){
		this.name = name;
		this.money = money;
	}
	public Inventory(String name, int quantity, int cost, int sellPrice){
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.sellPrice = sellPrice;
	}
	public Inventory(String name, double ballMultiplier, int quantity, int cost, int sellPrice){
		this.name = name;
		this.ballMultiplier = ballMultiplier;
		this.quantity = quantity;
		this.cost = cost;
		this.sellPrice = sellPrice;
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
	public void loadInventory(ArrayList<Inventory> inv){
		
	}
}