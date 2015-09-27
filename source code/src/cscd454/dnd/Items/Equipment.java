package cscd454.dnd.Items;

import cscd454.dnd.Stats.*;

public abstract class Equipment extends PrimaryStatHolder implements Item {

	private Weight weight;
	private String name, desc;
	private int levelReq;
	private StatHolder _stats;
		
	public Equipment(StatHolder stats, 
					 String name, 
					 String description, 
					 int levelReq)
	{
		super(stats);
		_stats = stats;
		this.weight = stats.getWeight();
		this.name = name;
		this.desc = description;
		this.levelReq = levelReq;
	}
	
	@Override
	public Weight getWeight() {	return weight; }
	
	@Override
	public String getName() { return name; }
	
	@Override
	public boolean isEquipable() { return true; }   
	
	public String getDesc() { return desc; }
	
	public int getLevelReq() { return levelReq; }
	
	public StatHolder getStatHolder() { return _stats; }
	
	public String toString() { return _stats.toString(); }
}
