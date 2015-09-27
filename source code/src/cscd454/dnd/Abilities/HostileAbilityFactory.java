package cscd454.dnd.Abilities;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Characters.PlayerCharacter;

public class HostileAbilityFactory implements AbilityFactory
{
	protected SOSwingAx _ax;
	protected SOFireBall _fire;
	protected SOSmash _smash;
	protected SOSneakAttack _sneak;
	protected SOLunge _lunge;
	protected AOChump _chump;
	protected CharacterEntity _dummyGM;
	protected CharacterEntity _dummyGW;
	protected CharacterEntity _dummyO;
	protected CharacterEntity _dummyOR;
	protected CharacterEntity _dummyOW;
	protected CharacterEntity _dummyTB;

	public HostileAbilityFactory()
	{
		_dummyGM = new PlayerCharacter(null, CharacterType.GOBLINMAGE, null, "");
		_dummyGW = new PlayerCharacter(null, CharacterType.GOBLINWARRIOR, null,
				"");
		_dummyO = new PlayerCharacter(null, CharacterType.OGRE, null, "");
		_dummyOR = new PlayerCharacter(null, CharacterType.ORCROGUE, null, "");
		_dummyOW = new PlayerCharacter(null, CharacterType.ORCWARRIOR, null, "");
		_dummyTB = new PlayerCharacter(null, CharacterType.TROLLBOSS, null, "");
		constructPrototypes();
		setValues();
	}

	private void constructPrototypes()
	{
		_ax = new SOSwingAx(_dummyGW);
		_fire = new SOFireBall(_dummyGM);
		_smash = new SOSmash(_dummyO);
		_sneak = new SOSneakAttack(_dummyOR);
		_lunge = new SOLunge(_dummyOW);
		_chump = new AOChump(_dummyTB);
	}

	private void setValues()
	{
		AbilityInfoHandler handler = AbilityInfoHandler.getInstance();
		_ax.setValues(handler.getAbilityBaseValue("swing ax"),
				handler.getAbilityScaling("swing ax"),
				handler.getAbilityPerLevelValue("swing ax"));
		_fire.setValues(handler.getAbilityBaseValue("fire ball"),
				handler.getAbilityScaling("fire ball"),
				handler.getAbilityPerLevelValue("fire ball"));
		_smash.setValues(handler.getAbilityBaseValue("smash"),
				handler.getAbilityScaling("smash"),
				handler.getAbilityPerLevelValue("smash"));
		_sneak.setValues(handler.getAbilityBaseValue("sneak attack"),
				handler.getAbilityScaling("sneak attack"),
				handler.getAbilityPerLevelValue("sneak attack"));
		_lunge.setValues(handler.getAbilityBaseValue("lunge"),
				handler.getAbilityScaling("lunge"),
				handler.getAbilityPerLevelValue("lunge"));
		_chump.setValues(handler.getAbilityBaseValue("chump"),
				handler.getAbilityScaling("chump"),
				handler.getAbilityPerLevelValue("chump"));
	}

	@Override
	public Ability createAbility(String name, CharacterEntity character)
	{
		ActiveAbility ability;
		switch (name.toLowerCase())
		{
		case "goblin warrior":
			ability = new SOSwingAx(character);
			ability.setValues(_ax);
			break;
		case "goblin mage":
			ability = new SOFireBall(character);
			ability.setValues(_fire);
			break;
		case "ogre":
			ability = new SOSmash(character);
			ability.setValues(_fire);
			break;
		case "orc rogue":
			ability = new SOSneakAttack(character);
			ability.setValues(_fire);
			break;
		case "orc warrior":
			ability = new SOLunge(character);
			ability.setValues(_fire);
			break;
		case "troll boss":
			ability = new AOChump(character);
			ability.setValues(_fire);
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
		{ _ax.getName(), _fire.getName() };
		return list;
	}
}
