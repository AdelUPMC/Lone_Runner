package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import impl.Screen;


public class ScreenServiceTests {

	//objectif:préconditions de init
	private Screen s= new Screen();
	@Test
	public void testPre()  {
		
		try {
			s.init(50, 60);
			assertTrue(s.getHeight()>0);
			assertTrue(s.getWidth()>0);
		} catch (PostConditionError | PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
