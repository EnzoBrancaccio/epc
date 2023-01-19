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
	
	/**
	 * 
	 * Finds the smallest difference between two integers
	 * from a list of HashMaps (key: String, value: Int)
	 * when two keys are given, and returns it.
	 * Method is not finished yet.
	 * 
	 * @param listOfHashMaps (list of HashMaps (String, Int)
	 * @param key1 (String, name of first key and operand)
	 * @param key2 (String, name of second key and operand)
	 * @return
	 */
	public int findSmallestDifference(ArrayList<HashMap<String, Integer>> listOfHashMaps, String key1, String key2) {
		int smallestDiff = Integer.MAX_VALUE;
		
		if (!listOfHashMaps.isEmpty()) {
			for (HashMap<String, Integer> hashMap : listOfHashMaps) {
				int x = 0;
				int y = 0;
				if (hashMap.containsKey(key1)) {
					x = hashMap.get(key1);
				}
				if (hashMap.containsKey(key2)) {
					y = hashMap.get(key2);
				}
				int diff = calculateDifference(x, y);

				if (diff < smallestDiff) {
					smallestDiff = diff;
				}
			}
		}
		
		return smallestDiff;
	}

}
