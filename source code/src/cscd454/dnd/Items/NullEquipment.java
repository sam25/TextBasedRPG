package cscd454.dnd.Items;

import cscd454.dnd.Stats.StatHolder;

public class NullEquipment extends Equipment 
{
	public NullEquipment() 
	{
		super(new StatHolder(),
			  "Null Equipment",
			  "No Equipment",
			  0);
		
		getStatHolder().setEquipmentSlot("Null");
		getStatHolder().setEquipmentType("Null Equipment Type");
	}
}
