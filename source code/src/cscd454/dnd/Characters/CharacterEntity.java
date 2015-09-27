package cscd454.dnd.Characters;

import java.util.ArrayList;

import cscd454.dnd.Abilities.Ability;
import cscd454.dnd.Party.Party;
import cscd454.dnd.Stats.Armor;
import cscd454.dnd.Stats.Health;
import cscd454.dnd.Stats.StatHolder;
import cscd454.dnd.Utils.Output;

public abstract class CharacterEntity
{
	protected String _name;
	protected CharacterType _type;
	protected StatHolder _stats;
	protected Health _health;
	protected Health _maxHealth;
	protected Party _party;
	protected ArrayList<Ability> _abilities;
	protected boolean _isDead;
	protected int _level;

	public CharacterEntity(StatHolder stats, CharacterType type, Party party)
	{
		_stats = stats;
		_type = type;
		_party = party;
		_isDead = false;
		_abilities = new ArrayList<Ability>();
		_level = 1;
	}

	public abstract void playTurn(Party otherParty);

	public void learnAbility(Ability ability)
	{
		if (isDead())
			return;
		_abilities.add(ability);
	}

	public void inflictDamage(double amount)
	{
		if (isDead())
			return;
		double damage = amount * 100 / (100 + _stats.getArmor().getValue());
		Health lostHp = new Health(damage);
		_health = _health.sufferAttack(lostHp);
		Output.getInstance().printlnMessage(
				_name + " takes " + (int) damage + " damage.");
		if (_health.getValue() <= 0)
		{
			Output.getInstance().printlnMessage(_name + " has been slain");
			_isDead = true;
		} else
			Output.getInstance().printlnMessage(
					_name + " has " + (int)_health.getValue() + " hp left");
	}

	public void applyHeal(double amount)
	{
		double hp = Math
				.min(amount, _maxHealth.getValue() - _health.getValue());
		_health = _health.receiveHeal(new Health(hp));

		Output.getInstance().printlnMessage(
				_name + " heals for " + (int) hp + " hp. (" + _health + "/"
						+ _maxHealth + ").");
	}

	public void grantArmor(double amount)
	{
		if (isDead())
			return;
		Armor arm = new Armor(amount);
		_stats.getArmor().add(arm);
		Output.getInstance().printlnMessage(
				_name + " receives " + arm.getValue() + " armor.");
	}

	public void reduceArmor(double amount)
	{
		if (isDead())
			return;
		Armor arm = new Armor(amount);
		_stats.getArmor().subtract(arm);
		Output.getInstance().printlnMessage(
				_name + " loses " + arm.getValue() + " armor.");
	}

	public CharacterType getType()
	{
		return _type;
	}

	public void setType(CharacterType type)
	{
		_type = type;
	}

	public void setHealth(Health hp)
	{
		_health = hp.getInstance();
	}

	public Health getHealth()
	{
		return _health;
	}

	public void setMaxHealth(Health h)
	{
		_maxHealth = h.getInstance();
	}

	public Health getMaxHealth()
	{
		return _maxHealth;
	}

	public Party getParty()
	{
		return _party;
	}

	public void setParty(Party party)
	{
		_party = party;
	}

	public void setDead(boolean b)
	{
		_isDead = b;
	}

	public boolean isDead()
	{
		return _isDead;
	}

	public String getName()
	{
		return _name;
	}

	public void setName(String name)
	{
		_name = name;
	}

	public void rest()
	{
		_isDead = false;
		_health = (Health) _maxHealth.getInstance();
	}

	public StatHolder getStats()
	{
		return _stats;
	}

	public void setStats(StatHolder stats)
	{
		_stats = stats;
	}

	public String toString()
	{
		if (isDead())
			return "x_____x " + _name + " x_____x ... DEAD";
		return _name + " <" + _type.name() + "> (" + _health + "/" + _maxHealth
				+ ")";
	}

	public int getLevel()
	{
		return _level;
	}
}
