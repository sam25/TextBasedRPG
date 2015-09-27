package cscd454.dnd.Abilities;

import java.util.ArrayList;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class POShockingOrb extends PartyOffensiveAbility
{

	public POShockingOrb(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.WIZARD;
		checkCompatibility();
		_name = "Shocking Orb";
		_description = "Fire a orb of energy forward in a line that detonates on striking an enemy dealing damage to all enemies";
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
