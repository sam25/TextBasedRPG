package cscd454.dnd.Abilities;

import java.sql.*;
import java.util.ArrayList;

import cscd454.dnd.Utils.InfoHandler;

public class AbilityInfoHandler extends InfoHandler
{
	private static AbilityInfoHandler handler = new AbilityInfoHandler();

	private AbilityInfoHandler()
	{
		super();
	}

	public static synchronized AbilityInfoHandler getInstance()
	{
		return handler;
	}

	public synchronized ArrayList<String> getClassAbilities(String charType)
	{
		assert stmt != null;

		query = String.format(
				"SELECT name FROM abilities WHERE character_type like '%s';",
				charType);

		ArrayList<String> abilityNames = new ArrayList<String>();

		try
		{
			resultSet = stmt.executeQuery(query);

			while (resultSet.next())
			{
				abilityNames.add(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			output.error(e.toString());
		}

		return abilityNames;
	}

	public synchronized String getAbilityClass(String ability)
	{
		assert stmt != null;

		query = String.format(
				"SELECT character_type FROM abilities WHERE name like '%s';",
				ability);

		try
		{
			resultSet = stmt.executeQuery(query);
			return resultSet.getString("character_type");
		} catch (SQLException e) {
			output.error(e.toString());
			return "Invalid";
		}
	}

	public synchronized int getAbilityBaseValue(String ability)
	{
		assert stmt != null;

		query = String.format("SELECT base_value FROM abilities WHERE name like '%s';", ability);

		try
		{
			resultSet = stmt.executeQuery(query);
			return resultSet.getInt("base_value");
		} catch (SQLException e) {
			output.error(e.toString());
			return -1;
		}
	}

	public synchronized double getAbilityScaling(String ability)
	{
		assert stmt != null;

		query = String.format("SELECT scaling FROM abilities WHERE name like '%s';", ability);

		try
		{
			resultSet = stmt.executeQuery(query);
			return resultSet.getDouble("scaling");
		} catch (SQLException e) {
			output.error("SQL Error in getAbilityScaling");
			return -1;
		}
	}

	public synchronized int getAbilityPerLevelValue(String ability)
	{
		assert stmt != null;

		query = String.format("SELECT per_level FROM abilities WHERE name like '%s';", ability);

		try
		{
			resultSet = stmt.executeQuery(query);
			return resultSet.getInt("per_level");
		} catch (SQLException e) {
			output.error("SQL Error in getAbilityBaseValue");
			return -1;
		}
	}
}
