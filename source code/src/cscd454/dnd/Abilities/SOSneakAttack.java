package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class SOSneakAttack extends SingleTargetOffensiveAbility
{

	public SOSneakAttack(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.ORCROGUE;
		checkCompatibility();
		_name = "Sneak Attack";
		_description = "Sneak attack";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double damage = _master.getStats().getDamage().getValue()
				+ _master.getStats().getStrength().getValue() * _scaling;
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
