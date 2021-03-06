package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class SOSwingAx extends SingleTargetOffensiveAbility
{

	public SOSwingAx(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.GOBLINWARRIOR;
		checkCompatibility();
		_name = "Swing Ax";
		_description = "Swing ax dealing damage to an enemy target.";
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
