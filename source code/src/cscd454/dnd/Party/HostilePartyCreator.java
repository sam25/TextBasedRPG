package cscd454.dnd.Party;

import java.util.Random;

import cscd454.dnd.Abilities.Ability;
import cscd454.dnd.Abilities.AbilityInfoHandler;
import cscd454.dnd.Abilities.HostileAbilityFactory;
import cscd454.dnd.Abilities.SOFireBall;
import cscd454.dnd.Abilities.SOSwingAx;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Characters.EnemyInfoHandler;
import cscd454.dnd.Characters.HostileCharacter;
import cscd454.dnd.Stats.Armor;
import cscd454.dnd.Stats.BasicStat;
import cscd454.dnd.Stats.StatHolder;
import cscd454.dnd.Stats.Weight;
import cscd454.dnd.Utils.Output;

public class HostilePartyCreator implements PartyCreator
{
	protected int _difficulty;
	protected boolean _boss;
	private final int BASE_STAT_AMOUNT = 5;
	protected HostileAbilityFactory _factory;

	public HostilePartyCreator(int difficulty, boolean boss)
	{
		_difficulty = (int)Math.log(difficulty);
		_factory = new HostileAbilityFactory();
		_boss = boss;
	}

	public void changeDifficulty(int difficulty)
	{
		_difficulty = (int)Math.log(difficulty);
	}

	@Override
	public Party createParty()
	{
		Random gen = new Random();
		CharacterType[] monsters = {CharacterType.GOBLINMAGE, CharacterType.GOBLINWARRIOR, CharacterType.OGRE, CharacterType.ORCROGUE, CharacterType.ORCWARRIOR};
		int numberOfCharacters = _difficulty*2+1;
		Party hostileParty = new Party(PartyType.BAD);
		HostileCharacter monster;
		CharacterType type;
		Ability spell;
		
		Output.getInstance().debug("Creating a hostile party of "+numberOfCharacters);
		
		for(int i=0; i<numberOfCharacters; i++)
		{
			type = monsters[gen.nextInt(monsters.length)];
			Output.getInstance().debug("Monster "+i+": "+type.toString());
			monster = EnemyInfoHandler.getInstance().getHostileCharacterInfo(type, hostileParty, _difficulty);
			spell = _factory.createAbility(type.toString(), monster);
			Output.getInstance().debug("Learning spell: "+spell.toString());
			monster.learnAbility(spell);
			hostileParty.addMember(monster);
		}
		if(_boss)
		{
			type = CharacterType.TROLLBOSS;
			monster = EnemyInfoHandler.getInstance().getHostileCharacterInfo(type, hostileParty, _difficulty);
			spell = _factory.createAbility(type.toString(), monster);
			monster.learnAbility(spell);
			hostileParty.addMember(monster);
		}

		return hostileParty;
	}
}