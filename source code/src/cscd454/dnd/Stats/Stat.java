/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 * 
 * Stat Class
 */

package cscd454.dnd.Stats;

import cscd454.dnd.Utils.Output;
import cscd454.dnd.Utils.OverflowChecker;

public abstract class Stat{

	private double value, calcValue;
	private String type;
	
	protected Stat(double value, String type)
	{		
		if(value < 0 )
			value = 0;
		else		
			this.value = value;
		this.type = type;
	}
	
	public double getValue() { return value;	}
	protected void setValue(double val)	{ value = val; }
	
	public String getType() { return type; }
	
	protected double add(double value)
	{
		if(OverflowChecker.doubleAdditionCausesOverflow(getValue(), value))
		{
			Output.getInstance().error("Addition of (" + getValue() + " + " + value + ") causes overflow");
			return getValue();
		}
		
		return getValue() + value;
	}
	
	protected double subtract(double value)
	{		
		if(OverflowChecker.doubleAdditionCausesOverflow(getValue(), value))
		{
			Output.getInstance().error("Subtraction of (" + getValue() + " - " + value + ") causes overflow");
			return getValue();
		}
		
		
		calcValue = getValue() - value;
		
		return calcValue >= 0 ? calcValue : 0;
	}
	
	protected double multiply(double value)
	{
		if(OverflowChecker.doubleMultiplicationCausesOverflow(getValue(), value))
		{
			Output.getInstance().error("Multiplication of (" + getValue() + " * " + value + ") causes overflow");
			return getValue();
		}
		
		calcValue = getValue() * value;
		
		return calcValue >= 0 ? calcValue : 0;
	}
	
	protected double divide(double value)
	{
		if(OverflowChecker.doubleMultiplicationCausesOverflow(getValue(), 1/value))
		{
			Output.getInstance().error("Division of (" + getValue() + " / " + value + ") causes overflow");
			return getValue();
		}
		
		calcValue = getValue() + value;
		
		return calcValue >= 0 ? calcValue : 0;
	}
	
	@Override
	public String toString()
	{
		if ( value != 0 )
			return type + ": " + (int) value;
		return "";
	}
	
	public boolean valueGreaterThan(Stat s)
	{
		return this.value > s.value ? true : false;
	}
	
	public boolean valueEquals(Stat s)
	{
		return this.value == s.value ? true : false;
	}
	
	public boolean valueLessThan(Stat s)
	{
		return this.value < s.value ? true : false;
	}
}
