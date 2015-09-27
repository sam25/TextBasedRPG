/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 */

package cscd454.dnd.Abilities;

import java.util.ArrayList;
import cscd454.dnd.Characters.CharacterEntity;

public abstract class AOEOffensiveAbility extends OffensiveAbility
{

	public AOEOffensiveAbility(CharacterEntity master)
	{
		super(master);
	}

	@Override
	protected ArrayList<CharacterEntity> getTargets(CharacterEntity target)
	{
		ArrayList<CharacterEntity> targets = new ArrayList<>();
		ArrayList<CharacterEntity> targetParty = target.getParty().getParty();
		int id = targetParty.indexOf(target);

		if (id >= 0 && id < targetParty.size())
			for (int i = Math.max(0, id - 1); i < Math.min(id + 2,
					targetParty.size()); i++)
				targets.add(targetParty.get(i));

		return targets;
	}
}
