package de.exxcellent.challenge.calculator;

import java.util.ArrayList;
import java.util.HashMap;

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
	 * For searching for a specific value to a given key 
	 * in a HashMap (key: String, value: Integer),
	 * based on finding the minimal difference between two values,
	 * to which the keys also have to be given.
	 * If >= 2 items have the same minimal difference, only
	 * the first found specific value is given.
	 * 
	 * For example, we want value v for which the difference
	 * between x and y is the smallest. 
	 * So we supply the keys for v, x and y.
	 * For each item in the list, the difference between x and y is determined.
	 * For the first item with the minimal difference, v is returned.
	 * 
	 * @param listOfHashMaps (list of HashMaps (String, Int)
	 * @param keyOfFirstOperand (String, name of first key and operand)
	 * @param keyOfSecondOperand (String, name of second key and operand)
	 * @param keyOfValueToFind (String, name of the key of the value to return)
	 * @return valueToFind (int, value found by the algorithm)
	 */
	public int findMinimalDifference(ArrayList<HashMap<String, Integer>> listOfHashMaps, String keyOfValueToFind, String keyOfFirstOperand, String keyOfSecondOperand) {
		int smallestDiff = Integer.MAX_VALUE;
		int valueToFind = 0;
		
		if (!listOfHashMaps.isEmpty()) {
			for (HashMap<String, Integer> hashMap : listOfHashMaps) {
				int x = 0;
				int y = 0;
				int val = 0;
				if (hashMap.containsKey(keyOfFirstOperand)) {
					x = hashMap.get(keyOfFirstOperand);
				}
				if (hashMap.containsKey(keyOfSecondOperand)) {
					y = hashMap.get(keyOfSecondOperand);
				}
				if (hashMap.containsKey(keyOfValueToFind)) {
					val = hashMap.get(keyOfValueToFind);
				}
				int diff = subtract(x, y);

				if (diff < smallestDiff) {
					smallestDiff = diff;
					valueToFind = val;
				}
			}
		}
		
		return valueToFind;
	}

}
