package Test;

import java.io.Serializable;

public class Move implements Serializable{
	
	public String name;
	public int maxPp;
	public int pp;
	public int accuracy;
	public int power;
	public String type;
	public String catergory;
	public String stat;
	public int stage;
	
	public Move(String name,int maxPp, int pp, int accuracy, int power, String type, String catergory){
		this.name = name;
		this.maxPp= maxPp;
		this.pp = pp;
		this.accuracy = accuracy;
		this.power = power;
		this.type = type;
		this.catergory = catergory;
	}
	
	public Move(String name,int maxPp, int pp, int accuracy, int power, String type, String catergory, String stat, int stage){
		this.name = name;
		this.maxPp= maxPp;
		this.pp = pp;
		this.accuracy = accuracy;
		this.power = power;
		this.type = type;
		this.catergory = catergory;
		this.stat = stat;
		this.stage = stage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPp() {
		return maxPp;
	}

	public void setMaxPp(int maxPp) {
		this.maxPp = maxPp;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		if(pp > getMaxPp()){
			this.pp = getMaxPp();
		}else if(pp < 0){
			this.pp = 0;
		}else{
			this.pp = pp;
			}
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCatergory() {
		return catergory;
	}

	public void setCatergory(String catergory) {
		this.catergory = catergory;
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
		return "[Name=" + name + ", PP=" + pp + ", Power=" + power + "]";
	}
}