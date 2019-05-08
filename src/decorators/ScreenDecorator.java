package decorators;

import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import services.CellNature;
import services.ScreenService;

public abstract class ScreenDecorator implements ScreenService{
	private final ScreenService delegate;

	public ScreenDecorator (ScreenService delegate) {
		this.delegate = delegate;
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
