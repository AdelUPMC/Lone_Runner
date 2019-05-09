package impl;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import services.CellNature;
import services.EditableScreen;
import utils.Pair;

public class EditableScreenImpl extends Screen implements EditableScreen  {

	

	public EditableScreenImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isPlayable() {
		for(int x=0;x<this.getWidth();x++) {
			if(this.getCellNature(x, 0)!=CellNature.MTL)return false;
			for(int y=0;y<this.getHeight();y++) {
				if(this.getCellNature(x, y)==CellNature.HOL) return false;
			}
		}
		return true;
	}

	@Override
	public void setNature(int x, int y, CellNature c) throws InvariantError, PreConditionError, PostConditionError {
		this.getScreen().put(new Pair<Integer,Integer>(x,y),c);
	}

	

}
