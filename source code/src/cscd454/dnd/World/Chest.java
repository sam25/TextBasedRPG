package cscd454.dnd.World;


import java.util.Random;

import cscd454.dnd.Characters.*;
import cscd454.dnd.Items.*;
import cscd454.dnd.Party.Party;
import cscd454.dnd.Utils.InputUtil;
import cscd454.dnd.Utils.Output;

public class Chest {
	
	private int _difficulty;
	private int _exp;
	private Item[] itemReward;
	private Random rand;
	private UsableItemFactory consumableMaker;
	private ArmorFactory armorMaker;
	private WeaponFactory weaponMaker;
	private ShieldFactory shieldMaker;
	
	public Chest( int difficulty )
	{
		_difficulty = difficulty;
		rand = new Random();
		consumableMaker= new UsableItemFactory();
		armorMaker = new ArmorFactory( _difficulty );
		weaponMaker = new WeaponFactory( _difficulty );
		shieldMaker = new ShieldFactory( _difficulty );
		initialize();
	}
	
	private void initialize()
	{
		_exp = 10 * _difficulty; //formula to calculate XP, could be changed later
		itemReward = new Item[ ( Math.abs(getRand() % 4)) +1 ];
		itemReward = createRewards( itemReward );
	}
	
	private Item[] createRewards( Item[] itemReward )
	{
		Item[] reward = itemReward;
		int i;
		int rewardType;
		for ( i = 0; i < reward.length; i++ )
		{
			rewardType = Math.abs( getRand() % 100 );
			 
			 if ( rewardType >= 0 && rewardType < 20 ) {//consumable
			 	reward[i] = consumableMaker.createUsableItem();
			 }
			 else if ( rewardType >= 20 && rewardType < 60 ) {
				 reward[i] = armorMaker.createArmor();
			 }
			 else if ( rewardType >= 60 && rewardType < 75 ) {
				 reward[i] = weaponMaker.createOneHandWeapon();
			 }
			 else if  ( rewardType >= 75 && rewardType < 90 ) {
				 reward[i] = weaponMaker.createTwoHandWeapon(); 	
			 }
			 else if ( rewardType >= 90 && rewardType < 100 ) {
				 reward[i] = shieldMaker.createShield();
			 }
		}
		return reward;
	}
	
	public void openChest( Party party )
	{	
		for ( CharacterEntity dude : party )
		{
			PlayerCharacter player = (PlayerCharacter) dude;
			Output.getInstance().info(player.getName() + " you gain "+ _exp +"XP!");
			player.addExp( _exp );
		}
		for ( int i = 0; i < itemReward.length; i++ )
		{
			for( CharacterEntity dude : party )
			{
				PlayerCharacter player = (PlayerCharacter) dude;
				
				Output.getInstance().printlnMessage("Item #"+(i+1)+": "+ itemReward[i].getName() );
				if ( itemReward[i].isEquipable() )
				{
					Output.getInstance().printlnMessage("Would you to equip this item? 1 for YES, 0 for NO.");
					int command = InputUtil.getInput(0, 1);
					if ( command == 1 )
						player.equipItem( (Equipment) itemReward[i] );
					else
						player.assignToInventory( itemReward[i] );
				} 
				else
					player.assignToInventory( itemReward[i] );
			}				
		}
	}
	
	private int getRand()
	{
		return rand.nextInt();
	}
}
