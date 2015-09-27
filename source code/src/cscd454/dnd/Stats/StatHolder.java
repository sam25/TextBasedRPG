/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 * 
 * Stat Holder Class
 */

package cscd454.dnd.Stats;

public class StatHolder extends PrimaryStatHolder 
{
	private Weight weight;
	private Armor armor;
	private String equipmentType, equipmentSlot;
	private BasicStat block, parry;
	private BasicStat damage;
	
	// constructors
	public StatHolder()
	{
		super();
		
		weight = new Weight(0);
		armor = new Armor(0);
		equipmentType = "Invalid";
		equipmentSlot = "Invalid";
		block = new BasicStat(0, "Block");
		parry = new BasicStat(0, "Parry");
		damage = new BasicStat(0, "Damage");
	}
	
	public StatHolder(StatHolder stats)
	{
		super(stats);
		
		weight = stats.getWeight();
		armor = stats.getArmor();
		equipmentType = stats.getEquipmentType();
		equipmentSlot = stats.getEquipmentSlot();
		block = stats.getBlock();
		parry = stats.getParry();
		damage = stats.getDamage();
	}
	
	public StatHolder(BasicStat str,
					  BasicStat dex,
					  BasicStat intel,
					  BasicStat wis,
					  Weight weight,
					  Armor armor,
					  String equipmentType,
					  String equipmentSlot,
					  BasicStat block,
					  BasicStat parry,
					  BasicStat dmg)
	{
		super(str, dex, intel, wis);
		
		this.weight = weight;
		this.armor = armor;
		this.equipmentType = equipmentType;
		this.equipmentSlot = equipmentSlot;
		this.block = block;
		this.parry = parry;
		this.damage = dmg;
	}
	
	// get/set methods
	public Weight getWeight() { return weight; }
	public void setWeight(Weight w) { weight = w; }
	
	public Armor getArmor() { return armor; }
	public void setArmor(Armor a) {	armor = a; }
	
	public String getEquipmentType() { return equipmentType; }
	public void setEquipmentType(String type) {equipmentType = type;}
	
	public String getEquipmentSlot() { return equipmentSlot; }
	public void setEquipmentSlot(String slot) {equipmentSlot = slot;}
	
	public BasicStat getParry() { return parry; }
	public void setParry(BasicStat p){
		if(p.getType().equals("Parry")) {
			parry = p;
		} else {
			System.err.println("Cannot set a non-parry stat as parry");
		}
	}
	
	public BasicStat getBlock() { return block; }
	public void setBlock(BasicStat b){
		if(b.getType().equals("Block")) {
			block = b;
		} else {
			System.err.println("Cannot set a non-block stat as block");
		}
	}
	
	public BasicStat getDamage() { return damage; }
	public void setDamage(BasicStat dmg){
		if(damage.getType().equals("Damage")) {
			damage = dmg;
		} else {
			System.err.println("Cannot set a non-damage stat as min damace");
		}
	}
	
	public StatHolder add(StatHolder stats)
	{
		return new StatHolder(getStrength().add(stats.getStrength()),
							  getDexterity().add(stats.getDexterity()),
							  getIntelligence().add(stats.getIntelligence()),
							  getWisdom().add(stats.getWisdom()),
							  weight.add(stats.getWeight()),
							  armor.add(stats.getArmor()),
							  equipmentType,
							  equipmentSlot,
							  block.add(stats.getBlock()),
							  parry.add(stats.getParry()),
							  damage.add(stats.getDamage()));
	}
	
	public StatHolder subtract(StatHolder stats)
	{
		return new StatHolder(getStrength().subtract(stats.getStrength()),
							  getDexterity().subtract(stats.getDexterity()),
							  getIntelligence().subtract(stats.getIntelligence()),
							  getWisdom().subtract(stats.getWisdom()),
							  weight.subtract(stats.getWeight()),
							  armor.subtract(stats.getArmor()),
							  equipmentType,
							  equipmentSlot,
							  block.subtract(stats.getBlock()),
							  parry.subtract(stats.getParry()),
							  damage.subtract(stats.getDamage()));
	}
	
	
	// need to fill this out
	@Override
	public String toString()
	{
		
		String resp = "Type: " + equipmentType + "\n";
		resp += "Slot: " + equipmentSlot + "\n";

		if ( ! damage.toString().isEmpty() )
			resp += damage.toString() + "\n";
		
		resp += super.toString();
		if ( ! weight.toString().isEmpty() )
			resp += weight.toString()+ "\n";
		if ( ! armor.toString().isEmpty() )
			resp += armor.toString() + "\n";
		if ( ! block.toString().isEmpty() )
			resp += block.toString() + "\n";
		if ( ! parry.toString().isEmpty() )
			resp += parry.toString() + "\n";
		
		return resp;
	}
}











