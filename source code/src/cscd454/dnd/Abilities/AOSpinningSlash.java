package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class AOSpinningSlash extends AOEOffensiveAbility
{

	public AOSpinningSlash(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.WARRIOR;
		checkCompatibility();
		_name = "Spinning Slash";
		_description = "Whirls weapon and dashes to a target, dealing damage to enemies in his path";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double damage = _master.getStats().getStrength().getValue() * _scaling;
		damage += _baseValue + _perLevel * _level;
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
