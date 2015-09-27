package cscd454.dnd.Utils;

import java.util.Scanner;

public class Scan {
	private static Scanner scan = new Scanner(System.in);
	
	protected Scan() {}
	
	public static Scanner getInstance()
	{
		return scan;
	}
}
