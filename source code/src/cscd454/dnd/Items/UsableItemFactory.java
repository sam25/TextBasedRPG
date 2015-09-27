package cscd454.dnd.Items;

import java.util.Random;

public class UsableItemFactory 
{
	private Random rand = new Random();
	private static final int NUM_USABLE_ITEMS = 2;
	private static final int HEALTH_POTION_EXTRA_CHANCES = 2;
	
	public UsableItemFactory() {};
	
	public UsableItem createUsableItem()
	{
		int total_chances = NUM_USABLE_ITEMS + HEALTH_POTION_EXTRA_CHANCES;
		int selection = rand.nextInt() % total_chances;
		
		if(selection == 0) {
			return new AshesOfTheFallen();
		} else if(selection > 0 && selection <= (1 + HEALTH_POTION_EXTRA_CHANCES)) {
			return new HealthPotion();
		}
		
		// just return a health potion if cause something goes wrong
		return new HealthPotion();
	}
}