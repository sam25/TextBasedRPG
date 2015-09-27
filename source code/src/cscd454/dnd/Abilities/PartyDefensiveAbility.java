/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 */

package cscd454.dnd.Abilities;

import java.util.ArrayList;
import cscd454.dnd.Characters.CharacterEntity;

public abstract class PartyDefensiveAbility extends DefensiveAbility
{

	public PartyDefensiveAbility(CharacterEntity master)
	{
		super(master);
	}

	@Override
	protected ArrayList<CharacterEntity> getTargets(CharacterEntity target)
	{
		ArrayList<CharacterEntity> targets = new ArrayList<>();
		for (CharacterEntity character : target.getParty().getParty())
			targets.add(character);
		return targets;
	}
}
