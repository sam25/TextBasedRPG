/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 */

package cscd454.dnd.Abilities;

import java.util.ArrayList;
import java.util.Random;
import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;

public abstract class ActiveAbility implements Ability
{
	protected String _name;
	protected String _description;
	protected CharacterEntity _master;
	protected CharacterType _type;
	protected int _level;
	protected int _baseValue;
	protected double _scaling;
	protected int _perLevel;
	protected Random _gen;
	protected AbilityType _abilityType;

	public ActiveAbility(CharacterEntity master)
	{
		_master = master;
		_level = 1;
		_gen = new Random();
	}
	
	public void setValues(int basevalue, double scaling, int perlevel)
	{
		_baseValue = basevalue;
		_scaling = scaling;
		_perLevel = perlevel;
	}
	
	public void setValues(ActiveAbility other)
	{
		_baseValue = other._baseValue;
		_scaling = other._scaling;
		_perLevel = other._perLevel;
	}

	public void castAbility(CharacterEntity target)
	{
		if (!canCastOn(target))
		{
			System.out.println("Invalid target!");
			return;
		}
		ArrayList<CharacterEntity> targets = getTargets(target);
		applyAbility(targets);
	}

	protected void checkCompatibility()
	{
		if (_master.getType() != _type)
			throw new IllegalArgumentException(
					"Incompatible ability for this class of character");
	}

	protected abstract boolean canCastOn(CharacterEntity target);

	protected abstract ArrayList<CharacterEntity> getTargets(
			CharacterEntity target);

	protected abstract void applyAbility(ArrayList<CharacterEntity> targets);

	@Override
	public String toString()
	{
		return _name + " : " + _description;
	}

	public String getName()
	{
		return _name;
	}

	public void setName(String name)
	{
		_name = name;
	}

	public String getDescription()
	{
		return _description;
	}

	public void setDescription(String description)
	{
		_description = description;
	}

	public int getLevel()
	{
		return _level;
	}

	public void levelUp()
	{
		_level++;
	}
	
	public void setMaster(CharacterEntity master)
	{
		_master = master;
	}

	public int getBaseValue()
	{
		return _baseValue;
	}

	public double getScaling()
	{
		return _scaling;
	}

	public int getPerLevel()
	{
		return _perLevel;
	}
	
	public String getValues()
	{
		return "("+_baseValue+"|"+_scaling+"|"+_perLevel+")";
	}
	
	public AbilityType getAbilityType()
	{
		return _abilityType;
	}
}
