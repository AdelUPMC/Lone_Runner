package decorators;

import services.CharacterService;
import services.EnvironnementService;
import services.ScreenService;

public class CharacterDecorator implements CharacterService {
	private CharacterService delegate;

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public EnvironnementService getEnv() {
		return delegate.getEnv();
	}

	public void init(ScreenService s, int x, int y) {
		delegate.init(s, x, y);
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

	public void goDown() {
		delegate.goDown();
	}
	

}
