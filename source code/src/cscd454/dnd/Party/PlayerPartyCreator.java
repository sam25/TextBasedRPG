package cscd454.dnd.Party;

import java.util.Scanner;

import cscd454.dnd.Characters.PlayerCharacterCreator;
import cscd454.dnd.Utils.InputUtil;
import cscd454.dnd.Utils.Output;
import cscd454.dnd.Utils.Scan;

public class PlayerPartyCreator implements PartyCreator
{
	protected PlayerCharacterCreator _playerCharacterCreator;
	protected Scanner _scan;
	
	public PlayerPartyCreator()
	{
		_playerCharacterCreator = new PlayerCharacterCreator();
		_scan = Scan.getInstance();
	}
	
	@Override
	public Party createParty()
	{
		Party party = new Party(PartyType.GOOD);
		Output.getInstance().prompt("How many players would like to join this party? (1 to 5)");
		int numPlayers = InputUtil.getInput(1, 5);
		for(int i=0; i<numPlayers; i++)
		{
			Output.getInstance().separator();
			Output.getInstance().info("Player "+i);
			party.addMember(_playerCharacterCreator.createCharacter(party));
			Output.getInstance().separator();
		}
		return party;
	}
}