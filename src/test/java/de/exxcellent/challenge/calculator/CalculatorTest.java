package de.exxcellent.challenge.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CalculatorTest {
	
	Calculator calc;
	
	@BeforeEach
	void setup() {
		calc = new Calculator();
	}
	
	@Test
	void testSubtract() {
		assertEquals(5, calc.subtract(10, 5));
		assertNotEquals(5, calc.subtract(11, 5));
	}

}