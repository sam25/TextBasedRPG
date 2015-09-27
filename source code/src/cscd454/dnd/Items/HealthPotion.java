package cscd454.dnd.Items;

import cscd454.dnd.Stats.Weight;
import cscd454.dnd.Characters.CharacterEntity;

public class HealthPotion extends UsableItem 
{
	private final static int MAX_POTION_STACK_SIZE = 10;
	private final static double HEALTH_RESTORED = 100;
	
	public HealthPotion()
	{
		super("Health Potion", new Weight(1), MAX_POTION_STACK_SIZE);		
	}
	
	@Override
	public void useItem(CharacterEntity character) 
	{
		
		if(currStackSize > 0) {
			character.applyHeal(HEALTH_RESTORED);
			
			this.currStackSize--;
		}		
	}
}
