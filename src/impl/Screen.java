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
	public Screen() {
		screen= new HashMap<Pair<Integer,Integer>,CellNature>();
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	public HashMap<Pair<Integer,Integer>,CellNature> getScreen(){
		return screen;
	}
	
	@Override
	public CellNature getCellNature(int x, int y) {
		Pair<Integer,Integer> p= new Pair<Integer,Integer>(x,y);
		return getScreen().get(p);
	}

	@Override
	public void init(int h, int w) throws PostConditionError, PreConditionError {
		this.width=w;
		this.height=h;
		for(int x=0;x<w;x++) {
			for(int y=0;y<h;y++) {
				Pair<Integer, Integer> p= new Pair<Integer, Integer>(x,y);
				getScreen().put(p, CellNature.EMP);
			}
		}
	}

	@Override
	public void dig(int x, int y) throws PostConditionError, PreConditionError {
		Pair<Integer,Integer> p= new Pair<Integer,Integer>(x,y);
		getScreen().put(p,CellNature.HOL);

	}

	@Override
	public void fill(int x, int y) throws PostConditionError, PreConditionError {
		Pair<Integer,Integer> p= new Pair<Integer,Integer>(x,y);
		getScreen().put(p,CellNature.PLT);
	}

}
