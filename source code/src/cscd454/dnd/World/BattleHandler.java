package cscd454.dnd.World;

import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Party.Party;
import cscd454.dnd.Utils.Output;

public class BattleHandler
{

	private Party _players;
	private Party _hostiles;

	public BattleHandler(Party playerParty, Party hostileParty)
	{
		_players = playerParty;
		_hostiles = hostileParty;
	}

	protected Party launchBattle()
	{
		boolean over = false;
		Party winner = null;

		while (!over)
		{
			playerTurn();
			hostileTurn();

			winner = determineWinner();
			over = (winner != null);
		}
		return winner;
	}

	private void playerTurn()
	{
		for (CharacterEntity player : _players)
		{
			if (_hostiles.isDead())
				break;
			Output.getInstance().separator();
			player.playTurn(_hostiles);
		}
	}

	private void hostileTurn()
	{
		for (CharacterEntity hostile : _hostiles)
		{
			if (_players.isDead())
				break;
			Output.getInstance().separator();
			hostile.playTurn(_players);
		}
	}

	private Party determineWinner()
	{
		boolean enemyAlive = !_hostiles.isDead();
		boolean playersAlive = !_players.isDead();

		if (playersAlive && !enemyAlive)
			return _players;
		if (!playersAlive && enemyAlive)
			return _hostiles;

		return null;
	}
}
