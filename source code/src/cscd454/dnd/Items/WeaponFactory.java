package cscd454.dnd.Items;

import cscd454.dnd.Stats.BasicStat;

public class WeaponFactory extends EquipmentFactory 
{	
	public WeaponFactory(int level) { super(level); }

	@Override
	public String chooseStat() {
		if(!includedStats.contains("Damage")) {
			return "Damage";
		}
		
		return choosePrimaryStat();
	}
	
	@Override
	public void addStatPoints(int points)
	{
		String stat;
		for(int i = 0; i < includedStats.size(); i++) {
			stat = includedStats.get(i);
			
			addBaseStatPoints(stat, points);
			if(stat.equals("Damage")) {
				stats.setDamage(new BasicStat(points, "Damage"));
				// ensures that weapons grant parry,
				// value will be normalized inside
				stats.setParry(new BasicStat(points, "Parry")); 
			}
		}
	}
	
	// check that this is finished
	public OneHandWeapon createOneHandWeapon() 
	{		
		setupComponents("OneHandWeapon");
		
		return new OneHandWeapon(stats, name, desc, level);
	}
	
	// check that this is finished
	public TwoHandWeapon createTwoHandWeapon() 
	{		
		setupComponents("TwoHandWeapon");
		
		return new TwoHandWeapon(stats, name , desc, level);	
	}
	
	@Override
	protected void setQueryField()
	{
		queryField = stats.getEquipmentSlot();
	}
		
	// generates a type for the type of weapon you are creating
	@Override
	public String generateType()
	{
		return infoHandler.getEquipType(stats.getEquipmentSlot());
	}
}