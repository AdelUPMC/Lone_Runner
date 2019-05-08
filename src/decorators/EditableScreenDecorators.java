package decorators;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import services.CellNature;
import services.EditableScreen;

public abstract class EditableScreenDecorators implements EditableScreen{
	private final EditableScreen delegate;
	
	public EditableScreenDecorators(EditableScreen delegate) {
		this.delegate = delegate;
	}
	
	
	public boolean isPlayable() {
		return delegate.isPlayable();
	}
	
	public void setNature(int x, int y, CellNature c) throws InvariantError, PreConditionError, PostConditionError {
		delegate.setNature(x, y, c);
	}

	
	public int getHeight() {
		return delegate.getHeight();
	}
	public int getWidth() {
		return delegate.getWidth();
	}
	
	public CellNature getCellNature(int x, int y) {
		return delegate.getCellNature(x, y);
	}
	
	public void init(int h, int w) throws PostConditionError, PreConditionError {
		delegate.init(h, w);
	}

	public void dig(int x, int y) throws PostConditionError, PreConditionError {
		delegate.dig(x, y);
	}
	
	public void fill(int x, int y) throws PostConditionError, PreConditionError {
		delegate.fill(x, y);
	}

	

}

