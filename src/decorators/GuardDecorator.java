package decorators;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import services.CharacterService;
import services.EnvironnementService;
import services.GuardService;
import services.Move;
import services.ScreenService;

public abstract class GuardDecorator implements GuardService {
	private GuardService delegate;

	public GuardDecorator(GuardService delegate) {
		super();
		this.delegate = delegate;
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getId() {
		return delegate.getId();
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public Move getBehaviour() {
		return delegate.getBehaviour();
	}

	public EnvironnementService getEnv() {
		return delegate.getEnv();
	}

	public CharacterService getTarget() {
		return delegate.getTarget();
	}

	public void init(ScreenService s, int x, int y) throws PreConditionError, InvariantError {
		delegate.init(s, x, y);
	}

	public int getTimeInHole() {
		return delegate.getTimeInHole();
	}

	public void ClimbLeft() throws PreConditionError, PostConditionError, InvariantError {
		delegate.ClimbLeft();
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

	public void ClimbRight() throws PreConditionError, InvariantError, PostConditionError {
		delegate.ClimbRight();
	}

	public void goDown() throws InvariantError, PreConditionError, PostConditionError {
		delegate.goDown();
	}

	public void Step() {
		delegate.Step();
	}
	

}
