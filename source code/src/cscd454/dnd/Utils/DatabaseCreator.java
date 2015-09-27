package cscd454.dnd.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class DatabaseCreator 
{
	private Statement stmt;
	private Scanner file;
	private String query, filename;
	private static Connection conn;
	private static Output output = Output.getInstance();
	
	private static final String DB_LOCAL_FILE_PATH = "DndDatabase.db";
	private static final String SQL_LOCAL_FILE_PATH = "DndDatabaseCommands.sql";
	
	public DatabaseCreator() 
	{	
		openConnection();
		stmt = DatabaseCreator.getStatement();

		
		try{
			file = new Scanner(new FileReader(SQL_LOCAL_FILE_PATH));
		} catch(FileNotFoundException e) {
			output.error("Could not open database creation file " + filename);
			file = null;
		} 
	}
	
	public void openConnection() 
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(String.format(
					"jdbc:sqlite:%s", DB_LOCAL_FILE_PATH));

		} catch (SQLException e) {
				output.error("Could not open database.");
				System.exit(0);
		} catch (ClassNotFoundException cExcep)	{
			output.error(cExcep.getClass().getName() + ": "
					+ cExcep.getMessage());
			System.exit(0);
		}
	}
	
	/* derived from http://www.tutorialspoint.com/sqlite/sqlite_java.htm */
	public void setupDatabaseConnections()
	{
		output.debug("Setting up the database connections");
		try
		{
			if (checkFileLength(DB_LOCAL_FILE_PATH))
			{
				buildDatabase();
				// close db and reopen it to preserve it in case of a crash
				conn.close();
				openConnection();
			}
		} catch (SQLException e){
			Output.getInstance().error("Could not open database.");
			System.exit(0);
		} 
	}

	private boolean checkFileLength(String path)
	{
		File f = new File(path);
		return f.length() == 0;
	}
	
	public void buildDatabase()
	{
		try {
			while(file.hasNext()) 
			{
				setupQuery();
				stmt.executeUpdate(query);
			}
		} catch(SQLException e) {
			System.err.println("SQL Error building database from filename: " + filename);
		} catch(IOException ioE) {
			System.err.println("IO Error building database from filename: " + filename);
		}
	}
	
	public void setupQuery() throws IOException
	{
		query = "";
		
		if(file == null) { throw new IOException(); }
		
		while(!query.contains(";")) {
			if(query.trim().length() == 0) {
				query = "";
			}
			if(file.hasNext()){
				query += file.nextLine();
			} else {
				query = query + ";";
			}
		}
	}
	
	public void closeConnection() 
	{
		try{
			conn.close();
		} catch(SQLException e) {
			output.error("DatabaseCreator.closeConnection : could not close database");
		}
	}
	
	public static Statement getStatement()
	{
		try{
			return conn.createStatement();
		} catch(SQLException e) {
			output.error("DatabseCreator.getStatement: Could not create statement from connection.");
			return null;
		}
	}
}
