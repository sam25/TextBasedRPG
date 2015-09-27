/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 * 
 * Item Interface
 */

package cscd454.dnd.Items;

import cscd454.dnd.Stats.Weight;

public interface Item 
{
	public abstract Weight getWeight();
	
	public abstract String getName();
	
	public abstract boolean isEquipable();
}
