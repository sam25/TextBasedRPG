package cscd454.dnd.Items;

import cscd454.dnd.Stats.Armor;
import cscd454.dnd.Stats.BasicStat;

public class ShieldFactory extends ArmorFactory 
{
	public ShieldFactory(int level) { super(level); }
	
	@Override
	public String chooseStat()
	{
		if(!includedStats.contains("Armor")) {
			return "Armor";
		} else if(!includedStats.contains("Block")) {
			return "Block";
		}
		
		return choosePrimaryStat();
	}
	
	@Override
	public String generateType()
	{
		return infoHandler.getEquipType(stats.getEquipmentSlot());
	}
	
	@Override
	public void addStatPoints(int points)
	{
		String stat;
		for(int i = 0; i < includedStats.size(); i++) {
			stat = includedStats.get(i);
			
			addBaseStatPoints(stat, points);
			
			if(stat.equals("Armor")) {
				stats.setArmor(new Armor(points));
			} else if(stat.equals("Block")) {
				stats.setBlock(new BasicStat(points, "Block"));
			} 
		}
	}
	
	public ShieldEquipment createShield()
	{
		setupComponents("Shield");
		
		return new ShieldEquipment(stats, name, desc, level);
	}
	
	@Override
	protected void setQueryField()
	{
		queryField = stats.getEquipmentSlot();
	}
}
