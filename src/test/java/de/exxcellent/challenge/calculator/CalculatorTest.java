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
	
	@Test
	void testSubtractSmallerOperand() {
		assertEquals(4, calc.subtractSmallerOperand(7, 3));
		assertEquals(4, calc.subtractSmallerOperand(3, 7));
		
		assertNotEquals(4, calc.subtractSmallerOperand(8, 3));
		assertNotEquals(4, calc.subtractSmallerOperand(3, 8));
	}

}