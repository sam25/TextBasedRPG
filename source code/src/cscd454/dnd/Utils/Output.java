package cscd454.dnd.Utils;

public class Output
{
	private static Output instance = new Output();
	private boolean _debugMode;
	private final String _warning = "[!]";
	private final String _prompt = "[?]";
	private final String _message = "   ";
	private final String _info = "[.]";
	private final String _debug = "[DEBUG]";

	protected Output()
	{
		_debugMode = false;
	}

	public static Output getInstance()
	{
		return instance;
	}

	public void printMessage(String message)
	{
		System.out.print(_message + " " + message);
	}

	public void printlnMessage(String message)
	{
		System.out.println(_message + " " + message);
	}

	public void separator()
	{
		System.out.println("");
	}

	public void warning(String message)
	{
		System.out.println(_warning + " " + message);
	}

	public void prompt(String message)
	{
		System.out.println(_prompt + " " + message);
		System.out.print(" > ");
	}

	public void error(String error)
	{
		if(_debugMode)
			System.err.println(error);
	}

	public void info(String message)
	{
		System.out.println(_info + " " + message);
	}

	public void orderedList(Object[] list)
	{
		int i = 0;
		for (Object s : list)
		{
			System.out.println(_message + i + " - " + s);
			i++;
		}
	}

	public void debug(String message)
	{
		if(_debugMode)
			System.out.println(_debug + " " + message);
	}
	
	public void toggleDebug()
	{
		_debugMode = !_debugMode;
	}
}
