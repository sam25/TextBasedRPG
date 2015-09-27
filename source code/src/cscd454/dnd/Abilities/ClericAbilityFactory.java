package cscd454.dnd.Abilities;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Characters.PlayerCharacter;

public class ClericAbilityFactory implements AbilityFactory
{
	protected PDWish _wish;
	protected SDAstralBlessing _astral;
	protected SDResistance _resist;
	protected SOWeaken _weaken;
	protected PlayerCharacter _dummy;

	public ClericAbilityFactory()
	{
		_dummy = new PlayerCharacter(null, CharacterType.CLERIC, null, "");
		constructPrototypes();
		setValues();
	}

	private void constructPrototypes()
	{
		_wish = new PDWish(_dummy);
		_astral = new SDAstralBlessing(_dummy);
		_resist = new SDResistance(_dummy);
		_weaken = new SOWeaken(_dummy);
	}

	// TODO
	// Get values from Database
	private void setValues()
	{
		AbilityInfoHandler handler = AbilityInfoHandler.getInstance();
		_wish.setValues(handler.getAbilityBaseValue("wish"),
				handler.getAbilityScaling("wish"),
				handler.getAbilityPerLevelValue("wish"));
		_astral.setValues(handler.getAbilityBaseValue("astral blessing"),
				handler.getAbilityScaling("astral blessing"),
				handler.getAbilityPerLevelValue("astral blessing"));
		_resist.setValues(handler.getAbilityBaseValue("resistance"),
				handler.getAbilityScaling("resistance"),
				handler.getAbilityPerLevelValue("resistance"));
		_weaken.setValues(handler.getAbilityBaseValue("weaken"),
				handler.getAbilityScaling("weaken"),
				handler.getAbilityPerLevelValue("weaken"));
	}

	@Override
	public Ability createAbility(String name, CharacterEntity character)
	{
		ActiveAbility ability;
		switch (name.toLowerCase())
		{
		case "wish":
			ability = new PDWish(character);
			ability.setValues(_wish);
			break;
		case "astral blessing":
			ability = new SDAstralBlessing(character);
			ability.setValues(_astral);
			break;
		case "resistance":
			ability = new SDResistance(character);
			ability.setValues(_resist);
			break;
		case "weaken":
			ability = new SOWeaken(character);
			ability.setValues(_weaken);
			break;
		default:
			ability = null;
			break;
		}

		return ability;
	}

	@Override
	public String[] listAbilities()
	{
		String[] list =
		{ _wish.getName(), _astral.getName(), _resist.getName(),
				_weaken.getName() };
		return list;
	}
}
