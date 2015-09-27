package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class SOTasteTheirFear extends SingleTargetOffensiveAbility
{

	public SOTasteTheirFear(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.ROGUE;
		checkCompatibility();
		_name = "Taste their fear";
		_description = "Attack enemy target dealing damage based on missing health.";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double missinghp;
		double damage = _master.getStats().getStrength().getValue() * _scaling;
		damage += _baseValue + _perLevel * _level;
		if(_gen.nextInt(100)<=_master.getStats().getDexterity().getValue())
			damage *= 2;
		for (CharacterEntity character : targets)
		{
			if (character.isDead())
				continue;
			missinghp = character.getMaxHealth().getValue() - character.getHealth().getValue();
			missinghp *= 0.25;
			Output.getInstance().info(
					_master.getName() + " casts " + _name + " on "
							+ character.getName());
			character.inflictDamage(damage+missinghp);
		}
	}
}
