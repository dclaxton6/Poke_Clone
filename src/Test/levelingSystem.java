package Test;

import java.io.Serializable;

public class levelingSystem implements Serializable{
	
	public void expGain(characters ch, enemy c){
		
		double wildOrTrained = 1; 
		int baseExp = c.baseExp;
		double e = 1;
		int affectionLv = 1;
		int faintedP = c.level; 
		int lv = ch.level;
		double p = 1;
		int s = 1;
		double ogOrTrade = 1;
		double v = 1;
		//String lvType = c.lvType;
		
		int flatFormula = (int) ((wildOrTrained*ogOrTrade*baseExp*e*faintedP*p*affectionLv*v)/(7*s));
		int scaledFormula = (int) ((((wildOrTrained*baseExp*faintedP)/(5*s)) * ((Math.pow(((2 * faintedP)+10),2.5))/Math.pow((faintedP + lv + 10), 2.5))+1)*ogOrTrade*e*p);
		int totalExp = ch.getExp() + scaledFormula;
		
		ch.setExp(totalExp);
		ch.setTotalExp(ch.getTotalExp() + ch.getExp());
		System.out.println(ch.name + " has gained " + scaledFormula +" experience. ");
		int expNeeded = expNeeded(ch.getLevel()) - ch.getExp();
		if(expNeeded > 0){
			System.out.println("Exp Needed " + expNeeded);
		}
		
		System.out.println("Total Exp: " + ch.getTotalExp());
		
		if(ch.getExp() >= expNeeded(ch.getLevel())){
			System.out.println("LEVEL UP!!");
			ch.setLevel(ch.getLevel() + 1);
			ch.setExp(0);
			System.out.println("current level: " + ch.getLevel());
		}
	}
	
	public static int expNeeded(int level /*, String expType*/){
		/*int erratic;
		if(level <= 50){
			Math.pow(level, 3);
		} else if(level >= 50 && level <= 68){
			Math.pow(level, 3);
		} else if(level >= 68 && level <= 98){
			Math.pow(level, 3);
		} else if(level >= 98 && level <= 100){
			Math.pow(level, 3);
		}
		*/
		int fast = (int) (4 * Math.pow(level + 1, 3)/5);
		int medFast = (int) Math.pow(level, 3);
		int medSlow =(int) (((6/5)*Math.pow(level, 3)) - (15 * Math.pow(level, 2)) + (100 * level) - 140);
		int slow = (int) (5 * Math.pow(level, 3)/4);
		/*int fluctuating;
		if(level <= 15){
			Math.pow(level, 3);
		} else if(level >= 15 && level <= 36){
			Math.pow(level, 3);
		} else if(level >= 36 && level <= 100){
			Math.pow(level, 3);
		}*/
		return fast;
	}
}