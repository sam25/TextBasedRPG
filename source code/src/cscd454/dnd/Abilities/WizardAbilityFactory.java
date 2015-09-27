package cscd454.dnd.Abilities;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Characters.PlayerCharacter;

public class WizardAbilityFactory implements AbilityFactory
{
	protected SODisintegrate _disintegrate;
	protected AOIncinerate _incinerate;
	protected POShockingOrb _shockingOrb;
	protected SODarkMatter _darkMatter;
	protected PlayerCharacter _dummy;

	public WizardAbilityFactory()
	{
		_dummy = new PlayerCharacter(null, CharacterType.WIZARD, null, "");
		constructPrototypes();
		setValues();
	}

	private void constructPrototypes()
	{
		_disintegrate = new SODisintegrate(_dummy);
		_incinerate = new AOIncinerate(_dummy);
		_shockingOrb = new POShockingOrb(_dummy);
		_darkMatter = new SODarkMatter(_dummy);
	}

	// TODO
	// Get values from Database
	private void setValues()
	{
		AbilityInfoHandler handler = AbilityInfoHandler.getInstance();
		_disintegrate.setValues(handler.getAbilityBaseValue("disintegrate"),
				handler.getAbilityScaling("disintegrate"),
				handler.getAbilityPerLevelValue("disintegrate"));
		_incinerate.setValues(handler.getAbilityBaseValue("incinerate"),
				handler.getAbilityScaling("incinerate"),
				handler.getAbilityPerLevelValue("incinerate"));
		_shockingOrb.setValues(handler.getAbilityBaseValue("shocking orb"),
				handler.getAbilityScaling("shocking orb"),
				handler.getAbilityPerLevelValue("shocking orb"));
		_darkMatter.setValues(handler.getAbilityBaseValue("dark matter"),
				handler.getAbilityScaling("dark matter"),
				handler.getAbilityPerLevelValue("dark matter"));
	}

	@Override
	public Ability createAbility(String name, CharacterEntity character)
	{
		ActiveAbility ability;
		switch (name.toLowerCase())
		{
		case "disintegrate":
			ability = new SODisintegrate(character);
			ability.setValues(_disintegrate);
			break;
		case "incinerate":
			ability = new AOIncinerate(character);
			ability.setValues(_incinerate);
			break;
		case "shocking orb":
			ability = new POShockingOrb(character);
			ability.setValues(_shockingOrb);
			break;
		case "dark matter":
			ability = new SODarkMatter(character);
			ability.setValues(_darkMatter);
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
		{ _disintegrate.getName(), _incinerate.getName(), _shockingOrb.getName(),
				_darkMatter.getName() };
		return list;
	}
}
