package tests;

import services.CellNature;
import utils.Pair;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import contracts.EditableScreenContract;
import impl.EditableScreenImpl;

public class EditableScreenTest {
	private EditableScreenImpl e= new EditableScreenImpl();
	private EditableScreenContract edtScreen= new EditableScreenContract(e);
	
	@Test
	public void testsetNaturePos() throws PostConditionError, PreConditionError, InvariantError {
		edtScreen.init(50,50);
		edtScreen.getDelegate().setNature(25, 12, CellNature.PLT);
		assertTrue(edtScreen.getCellNature(25, 12).equals(CellNature.PLT));
	}
	
	@Test
	public void testsetNaturePostPos() throws PostConditionError, PreConditionError, InvariantError {
		edtScreen.init(50,50);
		HashMap<Pair<Integer,Integer>,CellNature> capture= new HashMap<Pair<Integer,Integer>,CellNature>(((EditableScreenImpl)edtScreen.getDelegate()).getScreen());
		edtScreen.getDelegate().setNature(25, 12, CellNature.PLT);
		
		for(int x=0;x<edtScreen.getWidth();x++) {
			for(int y=0;y<edtScreen.getHeight();y++) {
				if((x!=25)||(y!=12)) {
					Pair<Integer,Integer> p1= new Pair<Integer,Integer>(x,y);
					assertTrue(capture.get(p1).equals(((EditableScreenImpl)edtScreen.getDelegate()).getScreen().get(p1)));
				}
			}
		}
	}
	/*
	@Test
	public void testPre() throws PostConditionError, PreConditionError, InvariantError {
		edtScreen.init(50, 60);
		for(int i = 0; i<edtScreen.getWidth();i++) {
			edtScreen.setNature(i, 0, CellNature.MTL);
		}

		
		for(int i = 0; i<50;i++) {
			edtScreen.setNature(i, 1, CellNature.PLT);
		}
		
		edtScreen.setNature(10, 20, CellNature.HDR);
		
		edtScreen.setNature(8, 45, CellNature.PLT);
		edtScreen.setNature(8, 46, CellNature.PLT);
		
	}
	
	@Test
	public void testCellNature() throws PostConditionError, PreConditionError, InvariantError {
		edtScreen.init(50, 60);
		for(int i = 0; i<edtScreen.getWidth();i++) {
			edtScreen.setNature(i, 0, CellNature.MTL);
		}

		
		for(int i = 0; i<50;i++) {
			edtScreen.setNature(i, 1, CellNature.PLT);
		}
		
		edtScreen.setNature(10, 20, CellNature.HDR);
		
		edtScreen.setNature(8, 45, CellNature.PLT);
		edtScreen.setNature(8, 46, CellNature.PLT);
		
		for(int i = 0; i < edtScreen.getWidth(); i++) {
			assertEquals(CellNature.MTL, edtScreen.getCellNature(i, 0)); 
		}
		for(int i = 0; i < edtScreen.getWidth(); i++) {
			assertEquals(CellNature.PLT, edtScreen.getCellNature(i, 1)); 
		}
		assertEquals(CellNature.PLT, edtScreen.getCellNature(10, 20));
		assertEquals(CellNature.PLT, edtScreen.getCellNature(8, 45));
		assertEquals(CellNature.PLT, edtScreen.getCellNature(8, 46));
		
		assertEquals(CellNature.EMP, edtScreen.getCellNature(42, 40));
	}
	
	@Test
	public void testDig() throws PostConditionError, PreConditionError, InvariantError {
		edtScreen.init(50, 60);
		for(int i = 0; i<edtScreen.getWidth();i++) {
			edtScreen.setNature(i, 0, CellNature.MTL);
		}

		for(int i = 0; i<50;i++) {
			edtScreen.setNature(i, 1, CellNature.PLT);
		}
		
		edtScreen.dig(5, 0);
		assertEquals(CellNature.MTL, edtScreen.getCellNature(5, 0));

		edtScreen.dig(5, 1);
		edtScreen.dig(6, 1);
		edtScreen.dig(7, 1);
		assertEquals(CellNature.HOL, edtScreen.getCellNature(5, 1));
		assertEquals(CellNature.HOL, edtScreen.getCellNature(6, 1));
		assertEquals(CellNature.HOL, edtScreen.getCellNature(7, 1));

		edtScreen.dig(5, 2);
		assertEquals(CellNature.EMP, edtScreen.getCellNature(5, 2));

		
	}
	
	
	@Test
	public void testFill() throws PostConditionError, PreConditionError, InvariantError {
		edtScreen.init(50, 60);
		for(int i = 0; i<edtScreen.getWidth();i++) {
			edtScreen.setNature(i, 0, CellNature.MTL);
		}

		for(int i = 0; i<50;i++) {
			edtScreen.setNature(i, 1, CellNature.PLT);
		}
		
		edtScreen.fill(5, 0);
		assertEquals(CellNature.MTL, edtScreen.getCellNature(5, 0));

		edtScreen.dig(15, 1);
		edtScreen.dig(16, 1);
		assertEquals(CellNature.HOL, edtScreen.getCellNature(15, 1));
		assertEquals(CellNature.HOL, edtScreen.getCellNature(16, 1));
		edtScreen.fill(15, 1);
		edtScreen.fill(16, 1);
		assertEquals(CellNature.PLT, edtScreen.getCellNature(15, 1));
		assertEquals(CellNature.PLT, edtScreen.getCellNature(16, 1));

		edtScreen.fill(5, 2);
		assertEquals(CellNature.EMP, edtScreen.getCellNature(5, 2));

	}
	*/
	
}
