package decorators;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import services.CharacterService;
import services.EnvironnementService;
import services.ScreenService;

public abstract class CharacterDecorator implements CharacterService {
	private CharacterService delegate;

	public CharacterDecorator(CharacterService delegate) {
		super();
		this.delegate = delegate;
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public EnvironnementService getEnv() {
		return delegate.getEnv();
	}

	public void init(ScreenService s, int x, int y) throws PreConditionError, InvariantError {
		delegate.init(s, x, y);
	}

	public void goLeft() throws InvariantError, PreConditionError, PostConditionError {
		delegate.goLeft();
	}

	public void goRight() throws InvariantError, PreConditionError, PostConditionError {
		delegate.goRight();
	}

	public void goUp() throws InvariantError, PreConditionError, PostConditionError {
		delegate.goUp();
	}

	public void goDown() throws InvariantError, PreConditionError, PostConditionError {
		delegate.goDown();
	}
	

}
