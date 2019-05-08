package decorators;

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
	
	public void init(int h, int w) {
		delegate.init(h, w);
	}

	public void dig(int x, int y) {
		delegate.dig(x, y);
	}
	
	public void fill(int x, int y) {
		delegate.fill(x, y);
	}


}
