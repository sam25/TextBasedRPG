package cscd454.dnd.Characters;

public enum CharacterType
{
	WARRIOR("Warrior"), ROGUE("Rogue"), CLERIC("Cleric"), WIZARD("Wizard"), VENDOR("Vendor"), 
	COMPANION("Companion"), QUESTNPC("Quest Npc"), TROLLBOSS("Troll Boss"), 
	GOBLINWARRIOR("Goblin Warrior"), GOBLINMAGE("Goblin Mage"), OGRE("Ogre"),
	ORCROGUE("Orc Rogue"), ORCWARRIOR("Orc Warrior");
	
	private String charType;
	
	private CharacterType(String type) { charType = type; }  
	
	public String toString() { return charType; }
}
