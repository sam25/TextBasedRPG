package cscd454.dnd.World;

import cscd454.dnd.Characters.*;
import cscd454.dnd.Party.*;
import cscd454.dnd.Utils.Output;

public class Room {
	
	protected Party _players;
	protected Party _hostiles;
	protected int _difficulty;
	protected boolean _boss;
	
	public Room( Party players, boolean boss )
	{
		_players = players;
		_boss = boss;
		calculateDifficulty();
	}
	
	private void calculateDifficulty()
	{
		_difficulty = 0;
		for(CharacterEntity ce : _players)
			_difficulty+=ce.getLevel();
	}

	protected boolean initialize()
	{
		PartyCreator partyCreator;
		
		partyCreator = new HostilePartyCreator( _difficulty, _boss );
		
		_hostiles = partyCreator.createParty();
		
		giveRoomDescription();
		
		return launchBattle();
	}
	private void giveRoomDescription()
	{
		Output.getInstance().info("You have arrived in a new dungeon room with "+ _hostiles.getParty().size() +" enemies!");
		for ( CharacterEntity enemy : _hostiles )
			Output.getInstance().printlnMessage( enemy.toString() );
		Output.getInstance().debug("This is a boss room!");
		Output.getInstance().warning("Let the battle begins!");
	}
	private boolean launchBattle()
	{
		BattleHandler battle = new BattleHandler( _players, _hostiles );
		Party winner = battle.launchBattle();
		
		if ( winner.getType() == PartyType.GOOD)
		{
			playerWin();
			return true;
		}
		else
		{
			playerLose();
			return true;
		}
	}
	private void playerWin()
	{
		Output.getInstance().info("Congratulations! You have cleared this room. Enjoy this chest's rewards!");
		Chest chest = new Chest( _difficulty );
		chest.openChest( _players );
		_players.rest();
		
	}
	private void playerLose()
	{
		Output.getInstance().warning("Everyone in your party has died...");
	}

}
