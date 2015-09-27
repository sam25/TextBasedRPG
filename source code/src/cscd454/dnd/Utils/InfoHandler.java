package cscd454.dnd.Utils;

import java.sql.ResultSet;
import java.sql.Statement;

public abstract class InfoHandler
{
	protected static Statement stmt = null;
	protected ResultSet resultSet = null;
	protected Output output = Output.getInstance();

	protected String query = "";

	protected InfoHandler() 
	{
		setStatement();
	}
	
	public void setStatement()
	{
		stmt = DatabaseCreator.getStatement();
		if (stmt == null)
		{
			output.error("InfoHandler given null statement");
		}
	}
}
