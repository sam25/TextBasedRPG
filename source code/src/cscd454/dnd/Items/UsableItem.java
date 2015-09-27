package cscd454.dnd.Items;

import cscd454.dnd.Stats.Weight;
import cscd454.dnd.Utils.OverflowChecker;
import cscd454.dnd.Characters.CharacterEntity;

public abstract class UsableItem implements Item 
{
	String name;
	Weight weight;
	int maxStackSize, currStackSize;
	
	
	public UsableItem(String name, 
					  Weight weight,
					  int maxStack)
	{
		this.name = name;
		this.weight = weight;
		
		maxStackSize = maxStack;
		currStackSize = 1;
	}
	
	public UsableItem(String name, 
					  Weight weight,
					  int current,
					  int maxStack)
	{
		this.name = name;
		this.weight = weight;
		
		if(current > maxStack) {
			current = maxStack;
		}
		
		maxStackSize = maxStack;
		currStackSize = current;
	}
	
	@Override
	public Weight getWeight() {	return weight; }

	@Override
	public String getName() { return name; }
	
	@Override
	public boolean isEquipable() { return false; }
	
	public void increaseStack(int stackIncrease)
	{
		if(OverflowChecker.integerAdditionCausesOverflow(currStackSize, stackIncrease) ||
		   currStackSize + stackIncrease >= maxStackSize ) {
			currStackSize = maxStackSize;
		} else {
			currStackSize += maxStackSize;
		}
	}

	public abstract void useItem(CharacterEntity character);
}
