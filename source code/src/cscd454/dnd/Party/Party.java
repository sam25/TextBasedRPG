package cscd454.dnd.Party;

import java.util.ArrayList;
import java.util.Iterator;
import cscd454.dnd.Characters.CharacterEntity;

public class Party implements Iterable<CharacterEntity>
{
	protected PartyType _type;
	protected ArrayList<CharacterEntity> _members;

	public Party(PartyType type)
	{
		_type = type;
		_members = new ArrayList<CharacterEntity>();
	}

	@Override
	public Iterator<CharacterEntity> iterator()
	{
		return _members.iterator();
	}

	public void addMember(CharacterEntity member)
	{
		_members.add(member);
	}

	public ArrayList<CharacterEntity> getParty()
	{
		return _members;
	}

	public PartyType getType()
	{
		return _type;
	}

	public void setType(PartyType type)
	{
		_type = type;
	}

	public void rest()
	{
		for (CharacterEntity player : _members)
			player.rest();
	}

	public boolean isDead()
	{
		boolean alive = false;
		for (CharacterEntity ce : this)
			if (!ce.isDead())
			{
				alive = true;
				break;
			}
		return !alive;
	}
}
