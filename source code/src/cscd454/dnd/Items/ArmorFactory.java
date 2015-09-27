package cscd454.dnd.Items;

import cscd454.dnd.Stats.Armor;

public class ArmorFactory extends EquipmentFactory 
{	
	public ArmorFactory(int lvl) { super(lvl); }
	
	@Override
	public void addStatPoints(int points)
	{
		String stat;
		for(int i = 0; i < includedStats.size(); i++) {
			stat = includedStats.get(i);
			addBaseStatPoints(stat, points);
			if(stat.equals("Armor")) {
				stats.setArmor(new Armor(points));
			}
		}
	}
	
	public ArmorEquipment createArmor()
	{	
		setupComponents(generateArmorSlot());
		
		return new ArmorEquipment(stats, name, desc, level);		
	}
	
	@Override
	protected void setQueryField()
	{
		queryField = "Armor";
	}
	
	@Override
	public String chooseStat()
	{
		if(!includedStats.contains("Armor")) {
			return "Armor";
		} 
		
		return choosePrimaryStat();
	}
	
	@Override
	public String generateType()
	{
		//return infoHandler.getEquipType("Armor");
		return "Armor";
	}
	
	public String generateArmorSlot()
	{
		int armorSlotIndicator = this.rand.nextInt() % 4;
		
		if(armorSlotIndicator == 0) {
			return "Head";
		} else if(armorSlotIndicator == 1) {
			return "Chest";
		} else if(armorSlotIndicator == 2) {
			return "Leg";
		} else {
			return "Hand";
		}
	}
}
