package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class AOIncinerate extends AOEOffensiveAbility
{

	public AOIncinerate(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.WIZARD;
		checkCompatibility();
		_name = "Incinerate";
		_description = "Shoot a cone of fire scorching all enemies in front.";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double damage = _master.getStats().getIntelligence().getValue() * _scaling;
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
