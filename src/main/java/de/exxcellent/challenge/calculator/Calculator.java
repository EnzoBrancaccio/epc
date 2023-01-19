package de.exxcellent.challenge.calculator;

/**
 * 
 * Class Calculator provides basic mathematical operations
 * like calculating the difference between two numbers
 * 
 * @author Enzo Brancaccio
 * 
 *
 */
public class Calculator {

	/**
	 * 
	 * Subtracts y from x and returns the result.
	 * User is responsible for correct order of operands x and y.
	 * 
	 * @param x (int, first operand)
	 * @param y (int, second operand)
	 * @return diff (int, result of x - y)
	 */
	public int calculateDifference(int x, int y) {
		int diff = x - y;
		return diff;
	}

}
