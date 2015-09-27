package cscd454.dnd.Items;

import java.util.ArrayList;
import java.util.Random;

import cscd454.dnd.Stats.*;

public abstract class EquipmentFactory 
{
	
	protected ItemInfoHandler infoHandler;
	protected StatHolder stats;
	protected Random rand;
	protected ArrayList<String> includedStats;
	protected int level;
	protected String name, desc, queryField;
	private final int NUM_NON_ARMOR_STATS = 4;  
	
	protected EquipmentFactory(int lvl) 
	{
			stats = new StatHolder();
			infoHandler = ItemInfoHandler.getInstance();
			includedStats = new ArrayList<String>();
			level = lvl;
			rand = new Random();
	}
	
	public abstract String chooseStat();
	public abstract String generateType();
	public abstract void addStatPoints(int points);

	
	protected String choosePrimaryStat()
	{
		int num = rand.nextInt() % NUM_NON_ARMOR_STATS;
		
		if(num == 0) {
			return "Strength";
		} else if(num == 1) {
			return "Dexterity";
		} else if(num == 2) {
			return "Intelligence";
		} else {
			return "Wisdom";
		} 	
	}

	public void generateStats() 
	{		
		// give items a random number of stats
		int perEachStatPoints, statPoints, numStats;
		statPoints = infoHandler.getNumStatPoints(queryField, level);
		numStats = rand.nextInt(infoHandler.getMaxNumStats(queryField)) + 1;
		
		if(statPoints == -1) {
			perEachStatPoints = 0;
		} else {
			if(numStats > statPoints) {
				numStats = statPoints;
			}
			
			perEachStatPoints = statPoints / numStats;
		}
		
		String stat = "";
		
		for(int i = 0; i < numStats; i++, stat = "") {			
			while(includedStats.contains(stat) || stat.equals("")){
				stat = chooseStat();
			}
			includedStats.add(stat);
		}
	
		// set the stats for each of the selected stats.
		addStatPoints(perEachStatPoints);
		 
	}
	
	public void addBaseStatPoints(String stat, int points)
	{
		if(stat.equals("Strength")) {
			stats.setStrength(new BasicStat(points, "Strength"));
		} else if(stat.equals("Dexterity")) {
			stats.setDexterity(new BasicStat(points, "Dexterity"));
		} else if(stat.equals("Intelligence")) {
			stats.setIntelligence(new BasicStat(points, "Intelligence"));
		} else if(stat.equals("Wisdom")) {
			stats.setWisdom(new BasicStat(points, "Wisdom"));
		}
	}
	
	// template method
	public void setupComponents(String slot) 
	{
		stats.setEquipmentSlot(slot);
		stats.setEquipmentType(generateType());
		
		setQueryField();
		generateStats();
		createName();
		createDesc();
		
		includedStats.clear();
	}
	
	protected abstract void setQueryField();
	
	public void createName()
	{
		name = stats.getEquipmentSlot() + " " + 
				stats.getEquipmentType() + " of ";
		
		for(int i = 0; i < includedStats.size(); i++) {
			name += includedStats.get(i) + " ";
			
			if(i < includedStats.size()-1) {
				name += "and ";
			}
		}
	}
	
	public void createDesc()
	{
		desc = stats.toString() + "\nRequires level " + level + "\n";
	}
}
