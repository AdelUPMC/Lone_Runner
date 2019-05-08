package decorators;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import impl.Collection_Set;
import services.CellNature;
import services.EditableScreen;
import services.EnvironnementService;

public abstract class EnvironnementDecorator implements EnvironnementService {
	private EnvironnementService delegate;

	public EnvironnementDecorator(EnvironnementService delegate) {
		super();
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

	public Collection_Set getCellContent(int x, int y) throws PreConditionError {
		return delegate.getCellContent(x, y);
	}

	public void init(int h, int w) throws PostConditionError, PreConditionError {
		delegate.init(h, w);
	}

	public EditableScreen getScreen() {
		return delegate.getScreen();
	}

	public void init(EditableScreen s) throws InvariantError, PostConditionError, PreConditionError {
		delegate.init(s);
	}

	public void dig(int x, int y) throws PostConditionError, PreConditionError {
		delegate.dig(x, y);
	}

	public void fill(int x, int y) throws PostConditionError, PreConditionError {
		delegate.fill(x, y);
	}
	
	

}
