package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestIdentifySpam {
	@ParameterizedTest
	@CsvSource({"40419228399", "678192288", "192838"})
	void testInvalidSpamNumber(long number) {
		TelephoneChecker checker = new TelephoneChecker();
		
		
		assertThrows(IllegalArgumentException.class,
					()->{
					//ACT - unit being tested (generates exception)
					checker.identifySpam(number);
					}
					);
		
	}

	@ParameterizedTest
	@CsvSource({"4079238, false", "6781281922, false", "4111922838, true", "9111922838, true", "9991922838, true", "9001922838, true", "8881922838, true", "8001922838, true"})
	void test(long number, boolean expectedResult) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.identifySpam(number);
		
		assertEquals(expectedResult, result, "checking if " + number + " was reported as valid");
	}
}
