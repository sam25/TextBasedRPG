package cscd454.dnd.Characters;

import java.util.Random;

import cscd454.dnd.Party.*;
import cscd454.dnd.Stats.StatHolder;

public class HostileCharacter extends CharacterEntity
{
	public HostileCharacter( StatHolder stats, CharacterType type, Party party )
	{
		super( stats, type, party );
		_name = type.name();
	}
	
	public void playTurn( Party playerParty)
	{
		if(isDead())
			return;
		Random rand = new Random();
		Party players = playerParty;
		
		int abilityPicked = Math.abs(rand.nextInt() % _abilities.size());
		int targetPicked = Math.abs(rand.nextInt() % players.getParty().size());
		CharacterEntity target = players.getParty().get( targetPicked );
		
		_abilities.get( abilityPicked ).castAbility( target );
	}
}
