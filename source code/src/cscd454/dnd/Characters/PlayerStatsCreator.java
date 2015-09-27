package cscd454.dnd.Characters;

import java.util.Scanner;

import cscd454.dnd.Stats.Armor;
import cscd454.dnd.Stats.BasicStat;
import cscd454.dnd.Stats.StatHolder;
import cscd454.dnd.Stats.Weight;
import cscd454.dnd.Utils.InputUtil;
import cscd454.dnd.Utils.Output;
import cscd454.dnd.Utils.Scan;

public class PlayerStatsCreator
{
	private final int BASE_STAT_AMOUNT = 10;
	private final int STARTING_STAT_POINTS = 20;
	protected Scanner _scan;

	public PlayerStatsCreator()
	{
		_scan = Scan.getInstance();
	}

	public StatHolder createStats(CharacterType type, int points)
	{
		int usePoints = 0, str, wis, intel, dex;
		str = wis = intel = dex = 0;
		Output.getInstance()
				.info("You have "
						+ points
						+ " stat points to apply to your character's primary stat points.");
		Output.getInstance().info(advice(type) + " Choose wisely!");

		// Strength
		if (usePoints < points)
		{
			Output.getInstance()
					.prompt(points
							- usePoints
							+ " points left. How many would like to add to Strength?");
			str = InputUtil.getInput(0, points - usePoints);
			usePoints += str;
		}
		// Dexterity
		if (usePoints < points)
		{
			Output.getInstance()
					.prompt(points
							- usePoints
							+ " points left. How many would like to add to Dexterity?");
			dex = InputUtil.getInput(0, points - usePoints);
			usePoints += dex;
		}
		// Intelligence
		if (usePoints < points)
		{
			Output.getInstance()
					.prompt(points
							- usePoints
							+ " points left. How many would like to add to Intelligence?");
			intel = InputUtil.getInput(0, points - usePoints);
			usePoints += intel;
		}
		// Wisdom
		if (usePoints < points)
		{
			Output.getInstance()
					.info(points
							- usePoints
							+ " points left. These points have been added to Wisdom.");
			wis = points - usePoints;
			usePoints += wis;
		}
		if ( points == STARTING_STAT_POINTS )
			return generateStats(dex, str, wis, intel);
		else
			return generateLevelUpStats(dex, str, wis, intel);
	}

	private StatHolder generateStats(int dex, int str, int wis, int intel)
	{
		BasicStat strength = new BasicStat(BASE_STAT_AMOUNT + str, "Strength");
		BasicStat dexterity = new BasicStat(BASE_STAT_AMOUNT + dex, "Dexterity");
		BasicStat intelligence = new BasicStat(BASE_STAT_AMOUNT + intel,
				"Intelligence");
		BasicStat wisdom = new BasicStat(BASE_STAT_AMOUNT + wis, "Wisdom");
		Weight weight = new Weight(100.0);
		Armor armor = new Armor(BASE_STAT_AMOUNT);
		BasicStat block = new BasicStat(0, "block");
		BasicStat parry = new BasicStat(0, "parry");
		BasicStat damage = new BasicStat(20, "damage");

		StatHolder memberStats = new StatHolder(strength, dexterity,
				intelligence, wisdom, weight, armor, "invalid",
				"invalid", block, parry, damage);

		return memberStats;
	}
	
	private StatHolder generateLevelUpStats(int dex, int str, int wis, int intel)
	{
		BasicStat strength = new BasicStat(str, "Strength");
		BasicStat dexterity = new BasicStat(dex, "Dexterity");
		BasicStat intelligence = new BasicStat(intel, "Intelligence");
		BasicStat wisdom = new BasicStat(wis, "Wisdom");
		Weight weight = new Weight(0);
		Armor armor = new Armor(0);
		BasicStat block = new BasicStat(0, "block");
		BasicStat parry = new BasicStat(0, "parry");
		BasicStat damage = new BasicStat(0, "damage");

		StatHolder memberStats = new StatHolder(strength, dexterity,
				intelligence, wisdom, weight, armor, "invalid",
				"invalid", block, parry, damage);

		return memberStats;
	}

	private String advice(CharacterType type)
	{
		String advice;

		switch (type)
		{
		case CLERIC:
			advice = "Clerics rely on Wisdom to empower their spells.";
			break;
		case ROGUE:
			advice = "Rogues rely on Strength and dexterity to maximize their potential damage output.";
			break;
		case WARRIOR:
			advice = "Warriors rely on Strength to be able to sustain a fight and deal a good amount of damage.";
			break;
		case WIZARD:
			advice = "Wizards rely on intelligence to increate their damage output.";
			break;
		default:
			advice = "";
		}

		return advice;
	}
}
