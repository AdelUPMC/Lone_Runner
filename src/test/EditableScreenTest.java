package test;

import services.CellNature;
import services.CharacterService;
import services.EditableScreen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import contracts.EditableScreenContract;

public class EditableScreenTest {
	private EditableScreenContract edtScreen;
	
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
	private void testCellNature() throws PostConditionError, PreConditionError, InvariantError {
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
	private void testDig() throws PostConditionError, PreConditionError, InvariantError {
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
	private void testFill() throws PostConditionError, PreConditionError, InvariantError {
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
	
}
