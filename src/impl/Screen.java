package impl;

import java.util.HashMap;

import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import services.CellNature;
import services.ScreenService;
import utils.Pair;

public class Screen implements ScreenService {

	private HashMap<Pair<Integer,Integer>,CellNature> screen;
	private int width;
	private int height;
	public Screen(int width, int height) {
		this.width=width;
		this.height=height;
		screen= new HashMap<Pair<Integer,Integer>,CellNature>();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CellNature getCellNature(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(int h, int w) throws PostConditionError, PreConditionError {
		// TODO Auto-generated method stub

	}

	@Override
	public void dig(int x, int y) throws PostConditionError, PreConditionError {
		// TODO Auto-generated method stub

	}

	@Override
	public void fill(int x, int y) throws PostConditionError, PreConditionError {
		// TODO Auto-generated method stub

	}

}
