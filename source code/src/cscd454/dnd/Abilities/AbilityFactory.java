package cscd454.dnd.Abilities;

import cscd454.dnd.Characters.CharacterEntity;

public interface AbilityFactory
{
	public Ability createAbility(String name, CharacterEntity character);
	public String[] listAbilities();
}
