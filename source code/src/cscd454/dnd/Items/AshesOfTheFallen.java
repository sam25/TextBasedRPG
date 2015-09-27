package cscd454.dnd.Items;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Stats.Weight;

public class AshesOfTheFallen extends UsableItem 
{
	private final static int MAX_ASHES_STACK_SIZE = 5;
	
	public AshesOfTheFallen()
	{
		super("Ashes of the Fallen", 
			  new Weight(1),
			  MAX_ASHES_STACK_SIZE);
	}
	
	@Override
	public void useItem(CharacterEntity character) 
	{
		if(character.getHealth().getValue() == 0 &&
		   currStackSize > 0)
		{
			character.applyHeal(character.getMaxHealth().getValue());
		}
	}
}
