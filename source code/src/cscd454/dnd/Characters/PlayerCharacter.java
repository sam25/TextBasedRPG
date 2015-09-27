package cscd454.dnd.Characters;

import java.util.ArrayList;
import cscd454.dnd.Items.*;
import cscd454.dnd.Party.Party;
import cscd454.dnd.Stats.*;
import cscd454.dnd.Utils.InputUtil;
import cscd454.dnd.Utils.Output;
import cscd454.dnd.Abilities.*;

public class PlayerCharacter extends CharacterEntity
{

	protected ArrayList<Item> _inventory;
	private CharacterEquipment _equipedItems;
	private int _currentInventorySize;
	private int _experience;
	private int _currentLevel;
	private double _levelExp = 10;
	private PlayerStatsCreator playerStatsCreator;
	private final int POINTS_ON_LEVEL_UP = 4;

	public PlayerCharacter(StatHolder stats, CharacterType type, Party party,
			String name)
	{
		super(stats, type, party);
		_name = name;
		_equipedItems = new CharacterEquipment();
		_inventory = new ArrayList<Item>();
		_currentInventorySize = 0;
		_experience = 0;
		_currentLevel = 1;
		_maxHealth = new Health(150);
		if (_stats != null)
			_maxHealth = _maxHealth.receiveHeal(new Health(_stats.getStrength()
					.getValue() * 4));
		_health = _maxHealth.getInstance();
		playerStatsCreator = new PlayerStatsCreator();
	}

	public void playTurn(Party hostiles)
	{
		if (isDead())
			return;
		Party targetParty;
		Output.getInstance().separator();
		Output.getInstance().warning(this + ", your turn has begun!");

		callItemMenu();
		int command = callAbilityMenu();
		Output.getInstance().separator();
		int target;
		if (_abilities.get(command).getAbilityType() == AbilityType.DEFENSIVE)
			targetParty = _party;
		else
			targetParty = hostiles;

		target = callTargetMenu(targetParty);
		while (targetParty.getParty().get(target).isDead())
		{
			Output.getInstance().warning("You can't target a dead target!");
			target = callTargetMenu(targetParty);
		}

		_abilities.get(command).castAbility(targetParty.getParty().get(target));
	}

	private void callItemMenu()
	{
		Output.getInstance().prompt(
				"Would you like to use or equip an item? 1 for YES, 0 for NO.");
		int input = InputUtil.getInput(0, 1);
		if (input == 1)
		{
			printInventory();
			pickItem();
		}
	}

	private int callAbilityMenu()
	{
		Output.getInstance().info("List of avaiblable abilities:");
		Output.getInstance().orderedList(_abilities.toArray());
		Output.getInstance().prompt(
				"Enter a number corresponding to the ability chosen");
		return InputUtil.getInput(0, _abilities.size() - 1);
	}

	private int callTargetMenu(Party enemies)
	{
		Output.getInstance().info("List of avaiblable targets:");
		Output.getInstance().orderedList(enemies.getParty().toArray());
		Output.getInstance().prompt(
				"Enter a number corresponding to the target chosen");
		return InputUtil.getInput(0, enemies.getParty().size() - 1);
	}

	public void addExp(int moreExp)
	{
		_experience += moreExp;
		checkLevelUp();
	}

	private void checkLevelUp()
	{
		if (_experience >= _levelExp * _currentLevel)
		{
			_currentLevel += 1;
			_experience = 0;
			Output.getInstance().separator();
			Output.getInstance().printlnMessage("\t\t**********");
			Output.getInstance().warning("LEVEL UP!!! "+ _name + " YOU ARE NOW LEVEL "+ _currentLevel );
			Output.getInstance().printlnMessage("\t\t**********");
			Output.getInstance().separator();
			_stats.add( playerStatsCreator.createStats( _type, POINTS_ON_LEVEL_UP) );
			PlayerCharacterCreator playerCharacterCreator = new PlayerCharacterCreator();
			learnAbility( playerCharacterCreator.getAbility( _type, this ) );
		}
	}

	public void assignToInventory(Item obj)
	{
		_inventory.add(obj);
		_currentInventorySize++;
		Output.getInstance().info(
				obj.getName() + " was added to your inventory.");
		Output.getInstance().separator();

	}

	public void removeFromInventory(Item obj)
	{
		if (_currentInventorySize > 0)
		{
			_inventory.remove(obj);
			_currentInventorySize--;
		}
	}

	private void printInventory()
	{
		Output.getInstance().orderedList(_inventory.toArray());
	}

	private void pickItem()
	{
		Output.getInstance()
				.prompt("Enter a number corresponding to the item of your choosing, type -1 to pick nothing.");
		int itemPicked = InputUtil.getInput(-1, _inventory.size() - 1);
		if (itemPicked == -1)
			return;
		Item pick = _inventory.get(itemPicked);

		if (pick.isEquipable())
			equipItem((Equipment) pick);
		else
			useConsumable((UsableItem) pick);

	}

	public void equipItem(Equipment item)
	{
		_equipedItems.equipItem(item, _stats);
	}

	protected void unequipItem(Equipment item)
	{
		_equipedItems.unequipItem(_stats);
	}

	private void useConsumable(UsableItem item)
	{
		item.useItem(this);
	}

}
