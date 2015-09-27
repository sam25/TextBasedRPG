package cscd454.dnd.Abilities;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Characters.PlayerCharacter;

public class RogueAbilityFactory implements AbilityFactory
{
	protected AOCrescentSlash _cSlash;
	protected SOTasteTheirFear _taste;
	protected SODragonRage _rage;
	protected AOShadowAssault _shadow;
	protected PlayerCharacter _dummy;

	public RogueAbilityFactory()
	{
		_dummy = new PlayerCharacter(null, CharacterType.ROGUE, null, "");
		constructPrototypes();
		setValues();
	}

	private void constructPrototypes()
	{
		_cSlash = new AOCrescentSlash(_dummy);
		_taste = new SOTasteTheirFear(_dummy);
		_rage = new SODragonRage(_dummy);
		_shadow = new AOShadowAssault(_dummy);
	}

	// TODO
	// Get values from Database
	private void setValues()
	{
		AbilityInfoHandler handler = AbilityInfoHandler.getInstance();
		_cSlash.setValues(handler.getAbilityBaseValue("crescent slash"),
				handler.getAbilityScaling("crescent slash"),
				handler.getAbilityPerLevelValue("crescent slash"));
		_taste.setValues(handler.getAbilityBaseValue("taste their fear"),
				handler.getAbilityScaling("taste their fear"),
				handler.getAbilityPerLevelValue("taste their fear"));
		_rage.setValues(handler.getAbilityBaseValue("dragon rage"),
				handler.getAbilityScaling("dragon rage"),
				handler.getAbilityPerLevelValue("dragon rage"));
		_shadow.setValues(handler.getAbilityBaseValue("shadow assault"),
				handler.getAbilityScaling("shadow assault"),
				handler.getAbilityPerLevelValue("shadow assault"));
	}

	@Override
	public Ability createAbility(String name, CharacterEntity character)
	{
		ActiveAbility ability;
		switch (name.toLowerCase())
		{
		case "crescent slash":
			ability = new AOCrescentSlash(character);
			ability.setValues(_cSlash);
			break;
		case "taste their fear":
			ability = new SOTasteTheirFear(character);
			ability.setValues(_taste);
			break;
		case "dragon rage":
			ability = new SODragonRage(character);
			ability.setValues(_rage);
			break;
		case "shadow assault":
			ability = new AOShadowAssault(character);
			ability.setValues(_shadow);
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
		{ _cSlash.getName(), _taste.getName(), _rage.getName(),
				_shadow.getName() };
		return list;
	}
}
