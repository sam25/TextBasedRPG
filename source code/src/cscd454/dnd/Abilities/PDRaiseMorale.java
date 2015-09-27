package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Stats.BasicStat;
import cscd454.dnd.Utils.Output;

public class PDRaiseMorale extends PartyDefensiveAbility
{

	public PDRaiseMorale(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.WARRIOR;
		checkCompatibility();
		_name = "Raise Morale";
		_description = "Unleash a battle cry inspiring all allies and self to gain extra strength.";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double str = _master.getStats().getStrength().getValue() * _scaling;
		str += _baseValue + _perLevel * _level;
		for (CharacterEntity character : targets)
		{
			if (character.isDead())
				continue;
			character.getStats().setStrength(
					new BasicStat(character.getStats().getStrength().getValue()
							+ str, "Strength"));
			Output.getInstance().info(
					_master.getName() + " casts " + _name + " on "
							+ character.getName());
			Output.getInstance().warning(
					character.getName() + " gains " + str + " strength.");
		}
	}
}
