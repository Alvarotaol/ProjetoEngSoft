import static org.junit.Assert.*;
import models.TimeFutebol;

import org.junit.Test;


public class timeFutebolTest {
	
	@Test
	public void testCase1(){
		TimeFutebol timeTest = new TimeFutebol("nomeDoTime", "CNPJDoTime", "2014");
		
		assertTrue(timeTest != null);
	}

}
