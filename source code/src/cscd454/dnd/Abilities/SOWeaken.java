package cscd454.dnd.Abilities;

import java.util.ArrayList;
import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class SOWeaken extends SingleTargetOffensiveAbility
{

	public SOWeaken(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.CLERIC;
		checkCompatibility();
		_name = "Weaken";
		_description = "Reduces an enemy character's armor.";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		Double armor = _master.getStats().getWisdom().getValue() * _scaling;
		armor += _baseValue + _perLevel * _level;
		for (CharacterEntity character : targets)
		{
			if (character.isDead())
				continue;
			Output.getInstance().info(
					_master.getName() + " casts " + _name + " on "
							+ character.getName()+ ", "+armor);
			character.reduceArmor(armor);
		}
		System.out.println(this);

	}

}
