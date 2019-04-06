package Test;

import java.io.Serializable;
import java.util.ArrayList;

public class characters extends creatures {
	public int exp;
	public int totalExp;
	public String expType;
	public levelingSystem ls = new levelingSystem();
	public characters(){
		this("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", blank);
	}
	
	public characters(String name, String type, int hp, int maxHP, int atk, int def, int sAtk, int sDef, int spd, int acc, int eva, int stage_atk,
			int stage_def, int stage_sAtk, int stage_sDef, int stage_acc, int stage_eva, int level, int exp, int totalExp, String expType, ArrayList<Move> moveset) {
		super(name, type, hp, maxHP, atk, def, sAtk, sDef, spd, acc, eva, 
				stage_atk, stage_def, stage_sAtk, stage_sDef, stage_acc, stage_eva, level, moveset);
		this.exp = exp;
		this.totalExp = totalExp;
		this.expType = expType;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		//this may be where i set a level cap
		this.exp = exp;
	}
	
	public int getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}
	
	public void loadValues(characters c){
		setName(c.name);
		setType(c.type);
		setHp(c.hp);
		setMaxHP(c.maxHP);
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
}