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
	 * Subtracts int y from int x and returns the result.
	 * User is responsible for correct order of operands x and y.
	 * 
	 * @param x (int, first operand)
	 * @param y (int, second operand)
	 * @return diff (int, result of x - y)
	 */
	public int subtract(int x, int y) {
		int diff = x - y;
		return diff;
	}
	
	/**
	 * 
	 * Subtract int y from int x if x is greater than y,
	 * else subtract x from y.
	 * To ensure user gets the absolute difference.
	 * 
	 * @param x (int, operand)
	 * @param y (int, operand)
	 * @return diff (int, result of greater operand - smaller operand)
	 */
	public int subtractSmallerOperand(int x, int y) {
		int diff = 0;
		if (x >= y) {
			diff = x - y;
		} else {
			diff = y - x;
		}
		
		return diff;
	}

}