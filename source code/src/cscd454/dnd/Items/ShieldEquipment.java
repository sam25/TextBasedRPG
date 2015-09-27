package cscd454.dnd.Items;

import cscd454.dnd.Stats.*;

public class ShieldEquipment extends ArmorEquipment
{
	private BasicStat blockChance;
	
	
	public ShieldEquipment(StatHolder stats,
			  			   String name,
			  			   String desc, 
			  			   int levelReq)
	{
		super(stats, name, desc, levelReq);

		this.blockChance = stats.getBlock();
	}
	
	public BasicStat getBlock() { return blockChance; }
}
