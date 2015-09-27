/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 * 
 * Mitigation Stat Class
 */

package cscd454.dnd.Stats;

public class Mitigation extends Stat
{	
	public Mitigation(double mitigationVal)
	{
		super(mitigationVal, "Mitigation");
	}

	// return a new copy
	public Mitigation getInstance()
	{
		return new Mitigation(getValue());
	}
	
	// get an attack after getValue()
	public BasicStat getAfterMitigationAttack(BasicStat atk)
	{
		return new BasicStat(multiply(atk.getValue()), "Damage");
	}

	public Mitigation add(Mitigation stat)
	{
		if(!stat.getType().equals(getType())) {
			return (Mitigation) getInstance();
		}
		
		return new Mitigation(add(stat.getValue()));
	}
	
	public Mitigation subtract(Mitigation stat)
	{
		if(!stat.getType().equals(getType())) {
			return (Mitigation) getInstance();
		}
		
		return new Mitigation(subtract(stat.getValue()));
	}
	
	public Mitigation Multiply(Mitigation stat)
	{
		if(!stat.getType().equals(getType())) {
			return (Mitigation) getInstance();
		}
		
		return new Mitigation(multiply(stat.getValue()));
	}
	
	public Mitigation divide(Mitigation stat)
	{
		if(!stat.getType().equals(getType())) {
			return (Mitigation) getInstance();
		}
		
		return new Mitigation(divide(stat.getValue()));
	}
}