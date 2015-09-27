package cscd454.dnd.Items;

import java.sql.*;
import java.util.Random;

import cscd454.dnd.Utils.InfoHandler;

public class ItemInfoHandler extends InfoHandler
{
	private static ItemInfoHandler handler = new ItemInfoHandler();
	private static Random rand;
	
	private ItemInfoHandler() 
	{
		super();
		rand = new Random(); 
	}
	
	public static synchronized ItemInfoHandler getInstance()
	{
		return handler;
	}

	public synchronized int getMaxNumStats(String equipType)
	{
		assert stmt != null;
			
		query = String.format("SELECT num_stats " +
				"FROM num_equipment_stats " +
				"WHERE equip_slot LIKE '%s';", equipType);

				
		try {
			resultSet = stmt.executeQuery(query);
		
			return resultSet.getInt("num_stats");
		} catch(SQLException e) {
			output.error("SQL Error in getMaxNumStats");
			return -1;
		}
	}
	
	public synchronized int getNumStatPoints(String equipType, int level)
	{
		assert stmt != null;
		
		query = String.format("SELECT stat_points " +
							  "FROM equipment_stat_budget " +
							  "WHERE equipment LIKE '%s' " +
							  "AND level = %d;",
							  equipType, level);
						
		try {
			
			resultSet = stmt.executeQuery(query);
			
			return resultSet.getInt("stat_points");
		} catch(SQLException e) {
			output.error("SQL Error in getNumStatPoints");
			return -1;
		}
	}

	public synchronized int getEquipTypeCount(String equipment)
	{
		assert stmt != null;
		
		query = String.format("SELECT count(equipType) AS cnt " +
							  "FROM equipment_type " +
						      "WHERE equipment LIKE '%s';", equipment);
				
		try { 
			resultSet = stmt.executeQuery(query);
			
			return resultSet.getInt("cnt");
		} catch(SQLException e) {
			output.error("SQL Error in getEqupTypeCount\n\n");
			return -1;
		}
	}
	
	public synchronized String getEquipType(String equipment)
	{
		assert stmt != null;
		
		int count = getEquipTypeCount(equipment);
		if(count <= 0) {
			return "Invalid";
		}
		
		int randIndex = rand.nextInt(count) + 1;
		
		
		query = String.format("SELECT equipType " +
				  			  "FROM equipment_type " +
				  			  "WHERE equipment LIKE '%s' " +
				  			  "AND equipTypeIndex = %d;", 
				  			  equipment, randIndex);
		
		try { 
			resultSet = stmt.executeQuery(query);
		
			return resultSet.getString("equipType");
		} catch(SQLException e) {
			output.error("SQL Error in getEquipType\n\n");
			return "Invalid";
		}
	}
}