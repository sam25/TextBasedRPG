package cscd454.dnd.Items;

import cscd454.dnd.Stats.*;

public abstract class WeaponEquipment extends Equipment 
{
	private BasicStat damage;
	private BasicStat parry;
	protected String weaponType;

	public WeaponEquipment(StatHolder stats,
						  String name,
						  String desc, 
						  int levelReq)
	{
		super(stats, name, desc, levelReq);
		
		damage = stats.getDamage();
	}
	
	public BasicStat getDamage() { return damage; }
	public BasicStat getParry() { return parry; }

	public String getWeaponType() { return weaponType; }
	protected abstract void setWeaponType(String type);
}
