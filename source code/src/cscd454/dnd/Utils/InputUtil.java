package cscd454.dnd.Utils;

import java.util.Scanner;

public class InputUtil
{
	private static Scanner _scan = Scan.getInstance();
	protected InputUtil() { }
	public static int getInput(int min, int max)
	{
		int input = 0;
		while (true)
		{
			if (_scan.hasNextInt())
				input = _scan.nextInt();

			if (input >= min && input <= max)
				return input;
			Output.getInstance().prompt("Invalid input.");
		}
	}
}
