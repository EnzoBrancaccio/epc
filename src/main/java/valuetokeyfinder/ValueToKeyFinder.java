package valuetokeyfinder;

import java.util.ArrayList;
import java.util.HashMap;

import de.exxcellent.challenge.calculator.Calculator;
import de.exxcellent.challenge.exceptions.InputDataException;

/**
 * 
 * Provides methods to find values to specific keys,
 * for example based on more complex operations,
 * like value to a key based on 
 * minimal difference between values of other keys.
 * 
 * @author Enzo Brancaccio
 *
 */
public class ValueToKeyFinder {
	
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
	public int findValueToKeyBasedOnMinimalDifference(ArrayList<HashMap<String, Integer>> listOfHashMaps, String keyOfValueToFind, String keyOfFirstOperand, String keyOfSecondOperand) {
		Calculator calc = new Calculator();
		
		// initializing the minimal difference with the highest integer
		int minDiff = Integer.MAX_VALUE;
		int valueToFind = 0;
		
		if (!listOfHashMaps.isEmpty()) {
			// go through each hashMap and get the key and 2 operands
			for (HashMap<String, Integer> hashMap : listOfHashMaps) {
				int x = 0;
				int y = 0;
				int val = 0;
				if (hashMap.containsKey(keyOfFirstOperand)) {
					x = hashMap.get(keyOfFirstOperand);
				} else {
					throw new InputDataException("First operand not found");
				}
				if (hashMap.containsKey(keyOfSecondOperand)) {
					y = hashMap.get(keyOfSecondOperand);
				} else {
					throw new InputDataException("Second operand not found");
				}
				if (hashMap.containsKey(keyOfValueToFind)) {
					val = hashMap.get(keyOfValueToFind);
				} else {
					throw new InputDataException("Key of value to find not found");
				}
				int diff = calc.subtract(x, y);

				// change only if "less than", in case of equality first is kept
				if (diff < minDiff) {
					minDiff = diff;
					valueToFind = val;
				}
			}
		} else {
			throw new InputDataException("Input data not found");
		}
		
		return valueToFind;
	}

}
