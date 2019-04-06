package Test;

import java.util.ArrayList;

public class enemy extends creatures {
	
	public int baseExp;
	public int catchRate;
	public int basePay;

	public enemy(){
		this("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, blank, 0, 0, 0);
	}
	
	public enemy(String name, String type, int hp, int maxHP, int atk, int def, int sAtk, int sDef, int spd, int acc, int eva, int stage_atk,
			int stage_def, int stage_sAtk, int stage_sDef, int stage_acc, int stage_eva, int level, ArrayList<Move> moveset, int baseExp, int catchRate, int basePay) {
		super(name, type, hp, maxHP, atk, def, sAtk, sDef, spd, acc, eva, 
				stage_atk, stage_def, stage_sAtk, stage_sDef, stage_acc, stage_eva, level, moveset);
		
		this.baseExp = baseExp;
		this.catchRate = catchRate;
		this.basePay = basePay;
	}

	public int getBaseExp() {
		return baseExp;
	}

	public void setBaseExp(int baseExp) {
		this.baseExp = baseExp;
	}

	public int getCatchRate() {
		return catchRate;
	}

	public void setCatchRate(int catchRate) {
		this.catchRate = catchRate;
	}

	public int getBasePay() {
		return basePay;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}
}