package cscd454.dnd.Abilities;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Party.PartyType;

public abstract class OffensiveAbility extends ActiveAbility
{
	public OffensiveAbility(CharacterEntity master)
	{
		super(master);
		_abilityType = AbilityType.OFFENSIVE;
	}

	@Override
	protected boolean canCastOn(CharacterEntity target)
	{
		if (target.getParty().equals(_master.getParty())
				|| target.getParty().getType() == PartyType.NEUTRAL
				|| target.getParty().getType() == _master.getParty().getType())
			return false;
		return true;
	}
	
}