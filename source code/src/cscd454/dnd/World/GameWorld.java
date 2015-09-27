package cscd454.dnd.World;

import cscd454.dnd.Party.*;
import cscd454.dnd.Utils.DatabaseCreator;
import cscd454.dnd.Utils.Output;

public class GameWorld
{
	protected PlayerPartyCreator _playerPartyCreator;
	protected Party _players;
	protected DatabaseCreator dbCreator;
	private final int NUMBER_OF_ROOMS = 2;

	public GameWorld()
	{
		initialize();
		
		
	}

	public void initialize()
	{
		dbCreator = new DatabaseCreator();
		dbCreator.setupDatabaseConnections();
		_playerPartyCreator = new PlayerPartyCreator();
		_players = _playerPartyCreator.createParty();
		generateFirstRoom();
	}

	private void generateFirstRoom()
	{
		Room room;
		int i = 1;
		while (i <= NUMBER_OF_ROOMS)
		{
			Output.getInstance().separator();
			room = new Room(_players, i == NUMBER_OF_ROOMS);
			if (room.initialize())
				i++;
			else
				gameOver();
		}
		if (i > NUMBER_OF_ROOMS)
			winning();
	}

	private void winning()
	{
		Output.getInstance().separator();
		Output.getInstance().info("You finished the game!");
	}

	private void gameOver()
	{
		Output.getInstance().warning("GAME OVER....");
		dbCreator.closeConnection();
	}
}
