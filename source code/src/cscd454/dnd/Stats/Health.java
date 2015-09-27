/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 * 
 * Health Stat Class
 */

package cscd454.dnd.Stats;

public class Health extends Stat
{

	public Health(double healthVal)
	{
		super(healthVal, "Health");

		if (getValue() < 0)
		{
			this.setValue(0);
		}
	}

	// return a new copy
	public Health getInstance()
	{
		return new Health(this.getValue());
	}

	// suffer an attack
	public Health sufferAttack(Health hp)
	{
		return new Health(this.getValue() - hp.getValue());
	}

	// receive a heal
	public Health receiveHeal(Health heal)
	{
		return new Health(this.getValue() + heal.getValue());
	}

	// check if the attack is higher than 0
	public boolean isAboveZero()
	{
		return getValue() > 0 ? true : false;
	}

	public Health add(Health stat)
	{
		if (!stat.getType().equals(getType()))
		{
			return (Health) getInstance();
		}

		return new Health(add(stat.getValue()));
	}

	public Health subtract(Health stat)
	{
		if (!stat.getType().equals(getType()))
		{
			return (Health) getInstance();
		}

		return new Health(subtract(stat.getValue()));
	}

	public Health Multiply(Health stat)
	{
		if (!stat.getType().equals(getType()))
		{
			return (Health) getInstance();
		}

		return new Health(multiply(stat.getValue()));
	}

	public Health divide(Health stat)
	{
		if (!stat.getType().equals(getType()))
		{
			return (Health) getInstance();
		}

		return new Health(divide(stat.getValue()));
	}
}