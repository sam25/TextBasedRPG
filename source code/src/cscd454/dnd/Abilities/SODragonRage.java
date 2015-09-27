package cscd454.dnd.Abilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import cscd454.dnd.Characters.CharacterEntity;
import cscd454.dnd.Characters.CharacterType;
import cscd454.dnd.Utils.Output;

public class SODragonRage extends SingleTargetOffensiveAbility
{

	public SODragonRage(CharacterEntity master)
	{
		super(master);
		_type = CharacterType.ROGUE;
		checkCompatibility();
		_name = "Dragon Rage";
		_description = "Perform a powerful roundhouse kick while shouting 'ROADHOUSE!' in a Peter Griffin voice.";
	}

	@Override
	protected void applyAbility(ArrayList<CharacterEntity> targets)
	{
		double damage = _master.getStats().getStrength().getValue() * _scaling;
		damage += _baseValue + _perLevel * _level;
		if (_gen.nextInt(100) <= _master.getStats().getDexterity().getValue())
			damage *= 2;
		for (CharacterEntity character : targets)
		{
			if (character.isDead())
				continue;
			Output.getInstance().info(
					_master.getName() + " casts " + _name + " on "
							+ character.getName());
			roadHouse();
			character.inflictDamage(damage);
		}
	}

	private void roadHouse()
	{
		InputStream in;
		try
		{
			in = new FileInputStream("roadHouse.wav");
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
