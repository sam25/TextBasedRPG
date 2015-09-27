package cscd454.dnd.Items;

import cscd454.dnd.Stats.*;

public  class ArmorEquipment extends Equipment 
{
	private Armor armorVal;
	private String armorType, armorSlot;
	
	public ArmorEquipment(StatHolder stats,
						  String name,
						  String desc, 
						  int levelReq)
	{
		super(stats, name, desc, levelReq);
		
		armorVal = stats.getArmor();
		setArmorType(stats.getEquipmentType());
		setArmorSlot(stats.getEquipmentSlot());
	}
	
	private void setArmorType(String aType)
	{
		if(aType.equals("Light") || 
		   aType.equals("Medium") || 
		   aType.equals("Heavy"))
		{
			armorType = aType;
		} else {
			armorType = "Invalid";
		}
	}
	
	private void setArmorSlot(String aSlot)
	{
		if(aSlot.equals("Head") || 
		   aSlot.equals("Chest") ||
		   aSlot.equals("Leg") ||
		   aSlot.equals("Hand)")) 
		{
			armorSlot = aSlot;
		} else {
			armorSlot = "Invalid";
		}
	}
	
	public static boolean validArmorTypeOrSlot(String aType) 
	{
		return aType.equals("Invalid") ? false : true;
	}
	
	public boolean isSameArmorType(String type)
	{
		return armorType.toString().equals(type);
	}

	public boolean canEquipArmorType(String charArmorType)
	{
		
		if(charArmorType.equals("Heavy") &&
		   !ArmorEquipment.validArmorTypeOrSlot(armorType)) 
		{
			return true;
		}
		else if(charArmorType.equals("Medium")&&
			   (armorType.equals("Medium") || 
			    armorType.equals("Light")))
		{
			return true;
		} 
		else if(charArmorType.equals("Light") &&
				armorType.equals("Light"))
		{
			return true;
		}
		
		return false;
	}
	
	public Armor getArmorVal() { return this.armorVal; }
	public String getArmorType() { return this.armorType; }
	public String getArmorSlot() { return this.armorSlot; }
	
}


