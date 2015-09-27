package cscd454.dnd.Characters;

import java.util.Scanner;

import cscd454.dnd.Abilities.Ability;
import cscd454.dnd.Abilities.AbilityFactory;
import cscd454.dnd.Abilities.ClericAbilityFactory;
import cscd454.dnd.Abilities.RogueAbilityFactory;
import cscd454.dnd.Abilities.WarriorAbilityFactory;
import cscd454.dnd.Abilities.WizardAbilityFactory;
import cscd454.dnd.Party.Party;
import cscd454.dnd.Stats.StatHolder;
import cscd454.dnd.Utils.InputUtil;
import cscd454.dnd.Utils.Output;
import cscd454.dnd.Utils.Scan;

public class PlayerCharacterCreator
{
	private final int STARTING_STAT_POINTS = 20;
	protected Scanner _scan;
	protected PlayerStatsCreator _statsCreator;
	protected ClericAbilityFactory _clericAbilityFactory;
	protected WarriorAbilityFactory _warriorAbilityFactory;
	protected WizardAbilityFactory _wizardAbilityFactory;
	protected RogueAbilityFactory _rogueAbilityFactory;
	
	public PlayerCharacterCreator()
	{
		_scan = Scan.getInstance();
		_statsCreator = new PlayerStatsCreator();
		_clericAbilityFactory = new ClericAbilityFactory();
		_warriorAbilityFactory = new WarriorAbilityFactory();
		_rogueAbilityFactory = new RogueAbilityFactory();
		_wizardAbilityFactory = new WizardAbilityFactory();
	}

	public PlayerCharacter createCharacter(Party party)
	{
		Output.getInstance().separator();
		CharacterType type = chooseCharacterType();
		Output.getInstance().separator();
		String name = getName();
		PlayerCharacter player;
		Output.getInstance().separator();
		StatHolder stats = _statsCreator
				.createStats(type, STARTING_STAT_POINTS);
		player = new PlayerCharacter(stats, type, party, name);
		Output.getInstance().separator();
		player.learnAbility(getAbility(type, player));
		return player;
	}

	protected Ability getAbility(CharacterType type, PlayerCharacter player)
	{
		AbilityFactory factory;
		int choice = -1;
		switch (type)
		{
		case CLERIC:
			factory = _clericAbilityFactory;
			break;
		case ROGUE:
			factory = _rogueAbilityFactory;
			break;
		case WARRIOR:
			factory = _warriorAbilityFactory;
			break;
		case WIZARD:
			factory = _wizardAbilityFactory;
			break;
		default:
			factory = _clericAbilityFactory;
		}
		boolean isAbilityOK = false;
		while ( !isAbilityOK )
		{
			Output.getInstance().info("Now you need to pick an ability for your character.");
			Output.getInstance().orderedList(factory.listAbilities());
			Output.getInstance().prompt("Enter the number of your choice:");
			choice = InputUtil.getInput(0, factory.listAbilities().length-1);
			int i;
			if (  player._abilities.size() != 0 )
			{
				for ( i = 0; i < player._abilities.size(); i++ )
				{
					if ( factory.listAbilities()[choice].equals(player._abilities.get(i).getName()) )
					{
						Output.getInstance().error("You have already learned this ability. Please choose another one\n1");
						break;
					}
					if ( i == player._abilities.size()-1 )
						return factory.createAbility(factory.listAbilities()[choice], player);
				}
			}
			else
				return factory.createAbility(factory.listAbilities()[choice], player);
		}
		return factory.createAbility(factory.listAbilities()[choice], player);
	}

	private String getName()
	{
		Output.getInstance().prompt("What would you like to name your character?");
		String name = "";
		while(name.isEmpty() || name.equals("\n"))
			name = _scan.nextLine();
		return name;
	}

	private CharacterType chooseCharacterType()
	{
		CharacterType type;
		String[] types = {"Cleric", "Rogue", "Warrior", "Wizard"};
		int choice;
		Output.getInstance().info("You will need to choose a class for your character.");
		Output.getInstance().orderedList(types);
		Output.getInstance().prompt("What class would you like to play? Enter a valid number:");
		choice = InputUtil.getInput(0, types.length-1);
		switch(choice)
		{
		case 0:
			type = CharacterType.CLERIC;
			break;
		case 1:
			type = CharacterType.ROGUE;
			break;
		case 2:
			type = CharacterType.WARRIOR;
			break;
		case 3:
			type = CharacterType.WIZARD;
			break;
		default:
			type = null;
			break;
		}
		return type;
	}
}
