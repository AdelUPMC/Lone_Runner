package contracts;

import decorators.EditableScreenDecorators;
import services.CellNature;
import services.EditableScreen;

public class EditableScreenContract  extends EditableScreenDecorators{

	public EditableScreenContract(EditableScreen delegate) {
		super(delegate);
	}

}
