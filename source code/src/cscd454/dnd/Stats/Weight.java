/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 * 
 * Weight Stat Class
 */

package cscd454.dnd.Stats;

public class Weight extends Stat
{	
	public Weight(double weightVal)
	{
		super(weightVal, "Weight");
	}
	
	// return a new copy
	public Weight getInstance()
	{
		return new Weight(getValue());
	}
	
	public boolean isEquipable(Weight w)
	{
		return w.getValue() > this.getValue() ? false : true;
	}
	
	public Weight add(Weight stat)
	{
		if(!stat.getType().equals(getType())) {
			return (Weight) getInstance();
		}
		
		return new Weight(add(stat.getValue()));
	}
	
	public Weight subtract(Weight stat)
	{
		if(!stat.getType().equals(getType())) {
			return (Weight) getInstance();
		}
		
		return new Weight(subtract(stat.getValue()));
	}
}
