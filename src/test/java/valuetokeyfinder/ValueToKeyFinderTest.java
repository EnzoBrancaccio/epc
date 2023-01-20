package valuetokeyfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;

import de.exxcellent.challenge.exceptions.InputDataException;

public class ValueToKeyFinderTest {
	
	ValueToKeyFinder vtk;
	
	@BeforeEach
	void setup() {
		vtk = new ValueToKeyFinder();
	}
	
	@Test
	void testMinimalDifference() {
		ArrayList<HashMap<String, Integer>> listOfTestMaps = new ArrayList<HashMap<String, Integer>>();
		
		// has the minimal difference (1)
		HashMap<String, Integer> testMap1 = new HashMap<>();
		testMap1.put("op2", 1);
		testMap1.put("op1", 2);
		testMap1.put("key", 3);
		
		// difference: 5
		HashMap<String, Integer> testMap2 = new HashMap<>();
		testMap2.put("op2", 5);
		testMap2.put("op1", 10);
		testMap2.put("key", 20);
		
		// difference: 10
		HashMap<String, Integer> testMap3 = new HashMap<>();
		testMap3.put("op2", 10);
		testMap3.put("op1", 20);
		testMap3.put("key", 30);
		
		// difference: 1 (to show that only first found value is returned)
		HashMap<String, Integer> testMap4 = new HashMap<>();
		testMap4.put("op2", 1);
		testMap4.put("op1", 2);
		testMap4.put("key", 7);
		
		listOfTestMaps.add(testMap1);
		listOfTestMaps.add(testMap2);
		listOfTestMaps.add(testMap3);
		listOfTestMaps.add(testMap4);
		
		assertEquals(3, vtk.findValueToKeyBasedOnMinimalDifference(listOfTestMaps, "key", "op1", "op2"));
		assertNotEquals(7, vtk.findValueToKeyBasedOnMinimalDifference(listOfTestMaps, "key", "op1", "op2"));
		
		ArrayList<HashMap<String, Integer>> listOfTestMaps234 = new ArrayList<HashMap<String, Integer>>();
		
		// missing testMap1 so testMap4 has min difference
		listOfTestMaps234.add(testMap2);
		listOfTestMaps234.add(testMap3);
		listOfTestMaps234.add(testMap4);
		
		assertNotEquals(3, vtk.findValueToKeyBasedOnMinimalDifference(listOfTestMaps234, "key", "op1", "op2"));
		assertEquals(7, vtk.findValueToKeyBasedOnMinimalDifference(listOfTestMaps234, "key", "op1", "op2"));
		
		// Testing if the custom exception is thrown
		// first: missing op1
		assertThrows(InputDataException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				vtk.findValueToKeyBasedOnMinimalDifference(listOfTestMaps, "key", "", "op2");			
			}		
		});
		
		// second: missing op2
		assertThrows(InputDataException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				vtk.findValueToKeyBasedOnMinimalDifference(listOfTestMaps, "key", "op1", "");			
			}		
		});
		
		// third: missing key
		assertThrows(InputDataException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				vtk.findValueToKeyBasedOnMinimalDifference(listOfTestMaps, "", "op1", "op2");			
			}		
		});
	}
	
}
