package Test;

import java.io.Serializable;
import java.util.ArrayList;

public class creatures implements Serializable{

	public String name;
	public String type;
	public int hp;
	public int maxHP;
	public int atk;
	public int def;
	public int sAtk;
	public int sDef;
	public int spd;
	public int acc;
	public int eva;
	public int stage_atk;
	public int stage_def;
	public int stage_sAtk;
	public int stage_sDef;
	public int stage_spd;
	public int stage_acc;
	public int stage_eva;
	public int level;
	public ArrayList<Move> moveset = new ArrayList<Move>();
	static ArrayList<Move> blank = new ArrayList<Move>();
	public creatures(){
		
		this("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, blank);
	};
	
	public creatures(String name, String type, int hp, int maxHP, int atk, int def, int sAtk, int sDef, int spd, int acc, int eva, int stage_atk,
			int stage_def, int stage_sAtk, int stage_sDef, int stage_acc, int stage_eva, int level, ArrayList<Move> moveset) {
		super();
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.maxHP = maxHP;
		this.atk = atk;
		this.def = def;
		this.sAtk = sAtk;
		this.sDef = sDef;
		this.spd = spd;
		this.acc = acc;
		this.eva = eva;
		this.stage_atk = stage_atk;
		this.stage_def = stage_def;
		this.stage_sAtk = stage_sAtk;
		this.stage_sDef = stage_sDef;
		this.stage_acc = stage_acc;
		this.stage_eva = stage_eva;
		this.level = level;
		this.moveset = moveset;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
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
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
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
		if(getStage_atk() >= 6){
			System.out.println("Attack can not be increased any higher.");
		} if(getStage_atk() <= -6){
			System.out.println("Attack can not be decreased any lower.");
		}else{ 
			if(stage_atk < 0){
			System.out.println("Attack lowered by " + Math.abs(stage_atk));
			} else if(stage_atk > 0){
			System.out.println("Attack increased by " + stage_atk);
			}
			this.stage_atk = getStage_atk() + stage_atk;
		}	
	}
	public int getStage_def() {
		return stage_def;
	}
	public void setStage_def(int stage_def) {
		if(getStage_def() >= 6){
			System.out.println("Defense can not be increased any higher.");
		} if(getStage_def() <= -6){
			System.out.println("Defense can not be decreased any lower.");
		}else{ 
			if(stage_def < 0){
			System.out.println("Defense lowered by " + Math.abs(stage_def));
			} else if(stage_def > 0){
			System.out.println("Defense increased by " + stage_def);
			}
			this.stage_def = getStage_def() + stage_def;
		}	
	}
	public int getStage_sAtk() {
		return stage_sAtk;
	}
	public void setStage_sAtk(int stage_sAtk) {
		if(getStage_sAtk() >= 6){
			System.out.println("S. Attack can not be increased any higher.");
		} if(getStage_sAtk() <= -6){
			System.out.println("S. Attack can not be decreased any lower.");
		}else{ 
			if(stage_sAtk < 0){
			System.out.println("S. Attack lowered by " + Math.abs(stage_sAtk));
			} else if(stage_sAtk > 0){
			System.out.println("S. Attack increased by " + stage_sAtk);
			}
			this.stage_sAtk = getStage_sAtk() + stage_sAtk;
		}
	}
	public int getStage_sDef() {
		return stage_sDef;
	}
	public void setStage_sDef(int stage_sDef) {
		if(getStage_sDef() >= 6){
			System.out.println("S. Defense can not be increased any higher.");
		} if(getStage_sDef() <= -6){
			System.out.println("S. Defense can not be decreased any lower.");
		}else{ 
			if(stage_sDef < 0){
			System.out.println("S. Defense lowered by " + Math.abs(stage_sDef));
			} else if(stage_sDef > 0){
			System.out.println("S. Defense increased by " + stage_sDef);
			}
			this.stage_sDef = getStage_sDef() + stage_sDef;
		}	
	}
	public int getStage_spd() {
		return stage_spd;
	}
	public void setStage_spd(int stage_spd) {
		if(getStage_spd() >= 6){
			System.out.println("Speed can not be increased any higher.");
		} if(getStage_spd() <= -6){
			System.out.println("Speed can not be decreased any lower.");
		}else{ 
			if(stage_spd < 0){
			System.out.println("Speed lowered by " + Math.abs(stage_spd));
			} else if(stage_spd > 0){
			System.out.println("Speed increased by " + stage_spd);
			}
			this.stage_spd = getStage_spd() + stage_spd;
		}	
	}
	public int getStage_acc() {
		return stage_acc;
	}
	public void setStage_acc(int stage_acc) {
		if(getStage_acc() >= 6){
			System.out.println("Accuracy can not be increased any higher.");
		} if(getStage_acc() <= -6){
			System.out.println("Accuracy can not be decreased any lower.");
		}else{ 
			if(stage_acc < 0){
			System.out.println("Accuracy lowered by " + Math.abs(stage_acc));
			} else if(stage_acc > 0){
			System.out.println("Accuracy increased by " + stage_acc);
			}
			this.stage_acc = getStage_acc() + stage_acc;
		}
	}
	public int getStage_eva() {
		return stage_eva;
	}
	public void setStage_eva(int stage_eva) {
		if(getStage_eva() >= 6){
			System.out.println("Evasion can not be increased any higher.");
		} if(getStage_eva() <= -6){
			System.out.println("Evasion can not be decreased any lower.");
		}else{ 
			if(stage_eva < 0){
			System.out.println("Evasion lowered by " + Math.abs(stage_eva));
			} else if(stage_eva > 0){
			System.out.println("Evasion increased by " + stage_eva);
			}
			this.stage_eva = getStage_eva() + stage_eva;
		}
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
	//i could create a method similar to loadValues to reset the stages at the end of each battle
}