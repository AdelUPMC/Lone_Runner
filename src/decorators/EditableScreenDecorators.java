package decorators;

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
	
	public void setNature(int x, int y, CellNature c) {
		delegate.setNature(x, y, c);
	}


}

