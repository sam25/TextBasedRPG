package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class SOFireBall extends SingleTargetOffensiveAbility
{

	public SOFireBall(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.GOBLINMAGE;
		checkCompatibility();
		_name = "Fire Ball";
		_description = "Throw fireball dealing damage to an enemy target";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double damage = _master.getStats().getDamage().getValue()
				+ _master.getStats().getIntelligence().getValue() * _scaling;
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
