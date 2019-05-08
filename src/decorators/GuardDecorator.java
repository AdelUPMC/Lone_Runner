package decorators;

import services.CharacterService;
import services.EnvironnementService;
import services.GuardService;
import services.Move;
import services.ScreenService;

public class GuardDecorator implements GuardService {
	private GuardService delegate;

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

	public void init(ScreenService s, int x, int y) {
		delegate.init(s, x, y);
	}

	public int getTimeInHole() {
		return delegate.getTimeInHole();
	}

	public void ClimbLeft() {
		delegate.ClimbLeft();
	}

	public void goLeft() {
		delegate.goLeft();
	}

	public void goRight() {
		delegate.goRight();
	}

	public void goUp() {
		delegate.goUp();
	}

	public void ClimbRight() {
		delegate.ClimbRight();
	}

	public void goDown() {
		delegate.goDown();
	}

	public void Step() {
		delegate.Step();
	}
	

}
