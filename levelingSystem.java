import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class levelingSystem {
    public void expGain(character ch, enemy c){
		
		double wildOrTrained = 1; 
		int baseExp = c.getExpGiven();
		double e = 1;
		//int affectionLv = 1;
		int faintedP = c.level; 
		int lv = ch.level;
		double p = 1;
		int s = 1;
		double ogOrTrade = 1;
		//double v = 1;
		//String lvType = c.lvType;
		
		//int flatFormula = (int) ((wildOrTrained*ogOrTrade*baseExp*e*faintedP*p*affectionLv*v)/(7*s));
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
		//I  need to find a way to take the remaining exp and apply it to the next level requirement
		if(ch.getExp() >= expNeeded(ch.getLevel())){
			System.out.println("LEVEL UP!!");
			ch.setLevel(ch.getLevel() + 1);
			ch.ls.levelStats(ch,1);
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
		//int medFast = (int) Math.pow(level, 3);
		//int medSlow =(int) (((6/5)*Math.pow(level, 3)) - (15 * Math.pow(level, 2)) + (100 * level) - 140);
		//int slow = (int) (5 * Math.pow(level, 3)/4);
        
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
	public void levelStats(creature c, int trigger){
		//i should loop through each stat to give value for the fomula unique value to each stat
		Random rNum = new Random();
		Map<String, Integer> stats = new HashMap<String, Integer>();
		Set< Map.Entry<String, Integer> > statSet = stats.entrySet();
		stats.put("Hp", c.getMaxHp());
		stats.put("Atk", c.getAtk());
		stats.put("Def", c.getDef());
		stats.put("Spd", c.getSpd());
		stats.put("Sp Atk", c.getSAtk());
		stats.put("Sp Def", c.getSDef());
		int level = c.getLevel();

			for(Map.Entry<String, Integer> stat:statSet){
				int iv = rNum.nextInt(32);
				int ev = rNum.nextInt(2 + 1);
				int nature = 1;
				if(trigger == 1){
					System.out.println("Before " + stat.getKey() + " update: " + stat.getValue() );
				}
				if(!stat.getKey().equals("Hp")
				){
					switch(stat.getKey()){
						case "Atk":{
							c.setAtk( ( (	(	( ( 2 * c.getBaseStatAtk() + iv + ( ev / 4 )) * level ) / 100 ) + 5) * nature) );
							break;
						}
						case "Def":{
							c.setDef( ( (	(	( ( 2 * c.getBaseStatDef() + iv + ( ev / 4 )) * level ) / 100 ) + 5) * nature) );
							break;
						}
						case "Spd":{
							c.setSpd( ( (	(	( ( 2 * c.getBaseStatSpd() + iv + ( ev / 4 )) * level ) / 100 ) + 5) * nature) );
							break;
						}
						case "Sp Atk":{
							c.setSAtk( ( (	(	( ( 2 * c.getBaseStatSAtk() + iv + ( ev / 4 )) * level ) / 100 ) + 5) * nature) );
							break;
						}
						case "Sp Def":{
							c.setSDef( ( (	(	( ( 2 * c.getBaseStatSDef() + iv + ( ev / 4 )) * level ) / 100 ) + 5) * nature) );
							break;
						}
					}
				}else{
					
					c.setMaxHp( (	(	( 2 * c.getBaseStatHp() + iv + ( ev / 4 )) * level ) / 100 ) + (level + 10) );
					if(trigger == 0){
						c.setCurrentHp(c.getMaxHp());
					}
				}
				if(trigger == 1){
					System.out.print("After " + stat.getKey() + " update: " );
					switch(stat.getKey()){
						case "Atk":{ 
							System.out.println(c.getAtk());
							break;
						}
						case "Def":{
							System.out.println(c.getDef());
							break;
						}
						case "Spd":{
							System.out.println(c.getSpd());
							break;
						}case "Sp Atk":{
							System.out.println(c.getSAtk());
							break;
						}
						case "Sp Def":{
							System.out.println(c.getSDef());
							break;
						}
						case "Hp":{
							System.out.println(c.getMaxHp());
							break;
						}
					}
				}
			}
		}
}