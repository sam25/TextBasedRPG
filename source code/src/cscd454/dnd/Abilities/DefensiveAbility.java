/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 */

package cscd454.dnd.Abilities;

import cscd454.dnd.Characters.CharacterEntity;

public abstract class DefensiveAbility extends ActiveAbility
{
	public DefensiveAbility(CharacterEntity master)
	{
		super(master);
		_abilityType = AbilityType.DEFENSIVE;
	}

	@Override
	protected boolean canCastOn(CharacterEntity target)
	{
		return target.getParty().equals(_master.getParty());
	}
	
}