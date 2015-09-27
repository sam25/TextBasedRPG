/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 * 
 * Primary Stat Holder Class
 */

package cscd454.dnd.Stats;

public abstract class PrimaryStatHolder 
{
	private BasicStat strength;
	private BasicStat dexterity;
	private BasicStat intelligence;
	private BasicStat wisdom;
	
	// constructors
	public PrimaryStatHolder(BasicStat str,
						     BasicStat dex,
						     BasicStat intel,
						     BasicStat wis) 
	{
		strength = str;
		dexterity = dex;
		intelligence = intel;
		wisdom = wis;
	}
	
	public PrimaryStatHolder()
	{
		strength = new BasicStat(0, "Strength");
		dexterity = new BasicStat(0, "Dexterity");
		intelligence = new BasicStat(0, "Intelligence");
		wisdom = new BasicStat(0, "Wisdom");
	}
	
	public PrimaryStatHolder(PrimaryStatHolder holder)
	{
		strength = holder.getStrength();
		dexterity = holder.getDexterity();
		intelligence = holder.getIntelligence();
		wisdom = holder.getWisdom();
	}
	
	// get and set methods
	public BasicStat getStrength() { return strength; }
	public void setStrength(BasicStat s) 
	{
		if(s.getType().equals("Strength")) {
			strength = s;
		} else {
			System.err.println("Cannot set a non-strength stat as strength");
		} 
	}
	
	public BasicStat getDexterity() { return dexterity; }
	public void setDexterity(BasicStat d) 
	{
		if(d.getType().equals("Dexterity")) {
			dexterity = d;
		} else {
			System.err.println("Cannot set a non-dexterity stat as dexterity");
		} 
	}
	
	public BasicStat getIntelligence() { return intelligence; }
	public void setIntelligence(BasicStat i)
	{
		if(i.getType().equals("Intelligence")) {
			intelligence = i;
		} else {
			System.err.println("Cannot set a non-intelligence stat as intelligence");
		} 
	}
	
	public BasicStat getWisdom() { return wisdom; }
	public void setWisdom(BasicStat w) 
	{
		if(w.getType().equals("Wisdom")) {
			wisdom = w;
		} else {
			System.err.println("Cannot set a non-wisdom stat as wisdom");
		} 
	}
	
	public String toString()
	{
		String resp = "";

		resp += strength.toString();
		resp += dexterity.toString();
		resp += intelligence.toString();
		resp += wisdom.toString(); 
		
		return resp;
	}
}
