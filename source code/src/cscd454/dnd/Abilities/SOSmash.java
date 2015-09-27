package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class SOSmash extends SingleTargetOffensiveAbility
{

	public SOSmash(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.OGRE;
		checkCompatibility();
		_name = "Smash";
		_description = "SMASH!";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double damage = _master.getStats().getDamage().getValue()
				+ _master.getStats().getIntelligence().getValue() * _scaling;
		damage += _baseValue + _perLevel * _level;
		if (_gen.nextInt(100) <= _master.getStats().getDexterity().getValue())
			damage *= 2;
		for (CharacterEntity character : targets)
		{
			if (character.isDead())
				continue;
			Output.getInstance().info(
					_master.getName() + " casts " + _name + " on "
							+ character.getName());
			character.inflictDamage(damage);
		}
	}

}
