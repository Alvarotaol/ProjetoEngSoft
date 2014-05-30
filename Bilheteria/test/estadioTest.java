import static org.junit.Assert.*;
import models.Estadio;

import org.junit.Test;

import play.test.UnitTest;


public class estadioTest extends UnitTest {
	
	@Test
	public void testCase1(){
		Estadio estadioTest = new Estadio("Arena das Dunas", "BR101", "Potilandia", "Natal", "RN", "59000000");
		
		assertTrue(estadioTest != null);
	}

}
