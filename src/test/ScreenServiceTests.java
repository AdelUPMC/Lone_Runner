package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import impl.Screen;
import services.CellNature;
import utils.Pair;


public class ScreenServiceTests {

	//objectif:préconditions de init
	private Screen s= new Screen();
	
	@Test
	public void testInitPrePos()  {
		try {
			s.init(50, 60);
			assertTrue(s.getHeight()>0);
			assertTrue(s.getWidth()>0);
		} catch (PostConditionError | PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInitPreNeg()  {
		
		try {
			s.init(-20, 30);
			assertFalse(s.getHeight()>0);
			assertTrue(s.getWidth()>0);
		} catch (PostConditionError | PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//objectif:postconditions de init
	@Test
	public void testInitPostPos()  {
		try {
			s.init(50, 60);
			for(int x=0;x<s.getWidth();x++) {
				for(int y=0;y<s.getHeight();y++) {
					Pair<Integer,Integer> p=new Pair<Integer,Integer>(x,y);
					assertTrue(s.getScreen().get(p) == CellNature.EMP);
				}
			}
		} catch (PostConditionError | PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
