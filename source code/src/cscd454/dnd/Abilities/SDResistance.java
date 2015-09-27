package cscd454.dnd.Abilities;

import java.util.ArrayList;
import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class SDResistance extends SingleTargetDefensiveAbility
{
	public SDResistance(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.CLERIC;
		checkCompatibility();
		_name = "Resistance";
		_description = "Grants armor to an ally character.";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double armor = _master.getStats().getWisdom().getValue() * _scaling;
		armor += _baseValue + _perLevel * _level;
		for (CharacterEntity character : targets)
		{
			if (character.isDead())
				continue;
			Output.getInstance().info(
					_master.getName() + " casts " + _name + " on "
							+ character.getName());
			character.grantArmor(armor);
		}
	}

}
