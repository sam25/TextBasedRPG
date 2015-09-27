
package cscd454.dnd.Utils;
/* Bryan Anders
 * Sami Awwad
 * Samir Ouahhabi
 * 
 * Team abeeseesdee
 * 
 * Overflow checker  class
 */

import java.lang.Math;

public final class OverflowChecker 
{
	public static boolean integerAdditionCausesOverflow(int int1, int int2)
	{
		long sum = (long) int1 + (long) int2;
		
		return sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE;
	}
	
	public static boolean integerMultiplicationCausesOverflow(int int1, int int2)
	{
		long sum = (long) int1 * (long) int2;
		
		return sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE;
	}
	
	public static boolean longAdditionCausesOverflow(long long1, long long2)
	{
		return Long.MAX_VALUE - Math.abs(long1) < Math.abs(long2);
	}
	
	public static boolean longMultiplicationCausesOverflow(long long1, long long2)
	{
		return Long.MAX_VALUE / Math.abs(long1) < Math.abs(long2);
	}
	
	public static boolean doubleAdditionCausesOverflow(double double1, double double2)
	{
		return Double.MAX_VALUE - Math.abs(double1) < Math.abs(double2);
	}
	
	public static boolean doubleMultiplicationCausesOverflow(double double1, double double2)
	{
		return Double.MAX_VALUE / Math.abs(double1) < Math.abs(double2);
	}
}
