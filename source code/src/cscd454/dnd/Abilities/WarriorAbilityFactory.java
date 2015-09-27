package cscd454.dnd.Abilities;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Characters.PlayerCharacter;

public class WarriorAbilityFactory implements AbilityFactory
{
	protected AODecimate _decimate;
	protected AOSpinningSlash _sslash;
	protected PDRaiseMorale _raise;
	protected SODecisiveStrike _strike;
	protected PlayerCharacter _dummy;

	public WarriorAbilityFactory()
	{
		_dummy = new PlayerCharacter(null, CharacterType.WARRIOR, null, "");
		constructPrototypes();
		setValues();
	}

	private void constructPrototypes()
	{
		_decimate = new AODecimate(_dummy);
		_sslash = new AOSpinningSlash(_dummy);
		_raise = new PDRaiseMorale(_dummy);
		_strike = new SODecisiveStrike(_dummy);
	}

	// TODO
	// Get values from Database
	private void setValues()
	{
		AbilityInfoHandler handler = AbilityInfoHandler.getInstance();
		_decimate.setValues(handler.getAbilityBaseValue("decimate"),
				handler.getAbilityScaling("decimate"),
				handler.getAbilityPerLevelValue("decimate"));
		_sslash.setValues(handler.getAbilityBaseValue("spinning slash"),
				handler.getAbilityScaling("spinning slash"),
				handler.getAbilityPerLevelValue("spinning slash"));
		_raise.setValues(handler.getAbilityBaseValue("raise morale"),
				handler.getAbilityScaling("raise morale"),
				handler.getAbilityPerLevelValue("raise morale"));
		_strike.setValues(handler.getAbilityBaseValue("decisive strike"),
				handler.getAbilityScaling("decisive strike"),
				handler.getAbilityPerLevelValue("decisive strike"));
	}

	@Override
	public Ability createAbility(String name, CharacterEntity character)
	{
		ActiveAbility ability;
		switch (name.toLowerCase())
		{
		case "decimate":
			ability = new AODecimate(character);
			ability.setValues(_decimate);
			break;
		case "spinning slash":
			ability = new AOSpinningSlash(character);
			ability.setValues(_sslash);
			break;
		case "raise morale":
			ability = new PDRaiseMorale(character);
			ability.setValues(_raise);
			break;
		case "decisive strike":
			ability = new SODecisiveStrike(character);
			ability.setValues(_strike);
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
		{ _decimate.getName(), _sslash.getName(), _raise.getName(),
				_strike.getName() };
		return list;
	}
}
