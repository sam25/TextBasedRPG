package cscd454.dnd.Characters;

import java.sql.SQLException;

import cscd454.dnd.Party.Party;
import cscd454.dnd.Stats.BasicStat;
import cscd454.dnd.Stats.Health;
import cscd454.dnd.Stats.StatHolder;
import cscd454.dnd.Utils.InfoHandler;

public class EnemyInfoHandler extends InfoHandler
{
	private static EnemyInfoHandler handler = new EnemyInfoHandler();

	private EnemyInfoHandler()
	{
		super();
	}

	public static synchronized EnemyInfoHandler getInstance()
	{
		return handler;
	}

	public HostileCharacter getHostileCharacterInfo(CharacterType hostileType,
			Party party, int level)
	{
		assert hostileType.toString() != "" && party != null;

		query = String.format("SELECT * FROM monsters WHERE name like '%s';",
				hostileType.toString());
		output.debug(hostileType.toString());
		StatHolder stats = new StatHolder();
		HostileCharacter hostile = new HostileCharacter(stats, hostileType,
				party);

		try
		{
			resultSet = stmt.executeQuery(query);
			while (resultSet.next())
			{
				double statScaling = resultSet.getDouble("stat_scaling");
				double scaling = Math.pow(statScaling, level);
				stats.setDamage(new BasicStat(resultSet.getDouble("base_damage")
						* scaling, "Damage"));
				stats.setStrength(new BasicStat(resultSet
						.getDouble("base_strength") * scaling, "Strength"));
				stats.setDexterity(new BasicStat(resultSet
						.getDouble("base_dexterity") * scaling, "Dexterity"));
				stats.setIntelligence(new BasicStat(resultSet
						.getDouble("base_intelligence") * scaling, "Intelligence"));
				stats.setWisdom(new BasicStat(resultSet.getDouble("base_wisdom")
						* scaling, "Wisdom"));
	
				scaling = Math.pow(resultSet.getDouble("health_scaling"), level);
				Health maxHealth = new Health(scaling
						* resultSet.getDouble("base_health"));
				output.debug(statScaling+", "+scaling+", "+maxHealth.getValue());
				hostile.setMaxHealth(maxHealth);
				hostile.setHealth(maxHealth);
			}

		} catch (SQLException e)
		{
			output.error(
					String.format("Error in getHostileCharacterInfo: %s",
							e.toString()));

			e.printStackTrace();
		} catch (Exception excep)
		{
			output.error(
					String.format("Error in getHostileCharacterInfo: %s",
							excep.toString()));

			excep.printStackTrace();
		}

		return hostile;
	}
}
