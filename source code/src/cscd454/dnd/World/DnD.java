package cscd454.dnd.World;

import cscd454.dnd.Utils.Output;

public class DnD
{
	public static void main(String[] args)
	{
		Output.getInstance().printlnMessage("Welcome to Dungeons and Dragons!");
		Output.getInstance().printlnMessage("by Team ABeeSeesDee");
		Output.getInstance().separator();
		GameWorld gameWorld = new GameWorld();

		gameWorld.initialize();
	}

}
