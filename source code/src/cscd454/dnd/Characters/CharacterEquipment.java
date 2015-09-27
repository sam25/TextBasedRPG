package cscd454.dnd.Characters;

import cscd454.dnd.Utils.Scan;
import cscd454.dnd.Items.Equipment;
import cscd454.dnd.Items.NullEquipment;
import cscd454.dnd.Stats.*;
import cscd454.dnd.Utils.Output;

public class CharacterEquipment {

	private Equipment _head;
	private Equipment _chest;
	private Equipment _legs;
	private Equipment _gloves;
	private Equipment _rightHand;
	private Equipment _offHand;
	
	public CharacterEquipment()
	{
		_head = new NullEquipment();
		_chest = new NullEquipment();
		_legs = new NullEquipment();
		_gloves = new NullEquipment();
		_rightHand = new NullEquipment();
		_offHand = new NullEquipment();
	}
	public void equipItem( Equipment item, StatHolder charStats )
	{
		Equipment equipedItem = item;
		
		
		if ( equipedItem.getStatHolder().getEquipmentSlot().equalsIgnoreCase("Invalid") )
			Output.getInstance().printlnMessage("Not an equipable item sorry.");
	
		equip( equipedItem, charStats );
		printEquipment();
		
	}
	
	private void equip( Equipment item, StatHolder charStats )
	{
		Equipment equipedItem = item;
		switch ( equipedItem.getStatHolder().getEquipmentSlot() ) {
		case "Head": 
			unequip(_head, charStats); 
			_head = equipedItem; 
			break;
		case "Chest": 
			unequip(_chest, charStats); 
			_chest = equipedItem; 
			break;
		case "Leg": 
			unequip(_legs, charStats); 
			_legs = equipedItem; 
			break;
		case "Hand": 
			unequip(_gloves, charStats); 
			_gloves = equipedItem; 
			break;
		case "OneHandWeapon" : 
			equipOneHandWeapon( equipedItem, charStats ); 
			break;
		case "TwoHandWeapon" : 
			equipTwoHandWeapon( equipedItem, charStats ); 
			break;
		case "Shield" : 
			equipShield( equipedItem, charStats ); 
			break;
		}
		
		charStats.add( equipedItem.getStatHolder() );
		
	}
	
	private void equipOneHandWeapon( Equipment item, StatHolder charStats )
	{
		if ( _offHand.getStatHolder().getEquipmentSlot().equals("TwoHandWeapon") )
		{
			unequip( _offHand, charStats );
			_rightHand = item;
		}
		else
			_rightHand = item;
	}
	
	private void equipTwoHandWeapon( Equipment item, StatHolder charStats )
	{
		unequip(_rightHand, charStats );
		unequip(_offHand, charStats );
		_rightHand = item;
		_offHand = item;
	}
	
	private void equipShield( Equipment item, StatHolder charStats )
	{
		if ( _offHand.getStatHolder().getEquipmentSlot().equals("TwoHandWeapon") )
		{
			unequip( _rightHand, charStats );
			_offHand = item;
		}
		else
			_offHand = item;
	}
	
	public void unequipItem( StatHolder charStats )
	{
		printEquipment();
		int pick = -1;
		
		while ( true )
		{
			System.out.print("Enter a number for the item you want to unequip: ");
			if ( Scan.getInstance().hasNextInt() )
			{
				pick = Scan.getInstance().nextInt();
				if ( pick >= 0 && pick <= 5 )
					break;
			}
		}
		Equipment unequipedItem = new NullEquipment();
		switch ( pick ) {
			case 0: unequipedItem = _head; break;
			case 1: unequipedItem = _chest; break;
			case 2: unequipedItem = _legs; break; 
			case 3: unequipedItem = _gloves; break;
			case 4: unequipedItem = _rightHand; break;
			case 5: unequipedItem = _offHand; break;
		}
		unequip( unequipedItem, charStats );
	}
	
	private void unequip( Equipment itemSlot, StatHolder charStats )
	{
		if ( !itemSlot.getStatHolder().getEquipmentSlot().equals("Null") )
		{
			StatHolder stats = new StatHolder();
			stats = itemSlot.getStatHolder();
			itemSlot = new NullEquipment();
			charStats.subtract( stats );
		}
	} 
	
	private void printEquipment()
	{
		String[] equipmentString = { _head.getDesc(),_chest.getDesc(),
				_legs.getDesc(), _gloves.getDesc(), _rightHand.getDesc(), 
				_offHand.getDesc() };
		Output.getInstance().printlnMessage("*** Equipment ***");
		Output.getInstance().orderedList( equipmentString );
	}
	

}
