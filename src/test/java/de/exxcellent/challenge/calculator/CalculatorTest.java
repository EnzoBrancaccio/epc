package de.exxcellent.challenge.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculatorTest {
	
	Calculator calc;
	
	@BeforeEach
	void setup() {
		calc = new Calculator();
	}
	
	@Test
	void testDifference() {
		assertEquals(5, calc.calculateDifference(10, 5));
		assertNotEquals(5, calc.calculateDifference(11, 5));
	}
	
	@Test
	void testSmallestDifference() {
		ArrayList<HashMap<String, Integer>> listOfTestMaps = new ArrayList<HashMap<String, Integer>>();
		HashMap<String, Integer> testMap1 = new HashMap<>();
		
		testMap1.put("key1", 1);
		testMap1.put("key2", 2);
		testMap1.put("key3", 3);
		
		HashMap<String, Integer> testMap2 = new HashMap<>();
		
		testMap2.put("key1", 5);
		testMap2.put("key2", 10);
		testMap2.put("key3", 20);
		
		HashMap<String, Integer> testMap3 = new HashMap<>();
		
		testMap3.put("key1", 10);
		testMap3.put("key2", 20);
		testMap3.put("key3", 30);
		
		listOfTestMaps.add(testMap1);
		listOfTestMaps.add(testMap2);
		listOfTestMaps.add(testMap3);
		
		assertEquals(1, calc.findSmallestDifference(listOfTestMaps, "key2", "key1"));
	}

}
