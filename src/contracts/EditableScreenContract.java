package contracts;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import decorators.EditableScreenDecorators;
import services.CellNature;
import services.EditableScreen;

public class EditableScreenContract  extends EditableScreenDecorators{

	public EditableScreenContract(EditableScreen delegate) {
		super(delegate);
	}

	public void checkInvariant() throws InvariantError {
		/**
		 *  \inv:  isPlayable()==
		 * 			\forall(x) in [0; getWidth()[ 
		 * 				getCellNature(x,0)=CellNature.MTL
		 * 				\forall(y) in [0;getHeight()[
		 * 					getCellNature(x,y)!=CellNature.HOL
		 * 	 	
		 */
		
		//inv:
		if (isPlayable()) {
			for(int x=0;x<this.getWidth();x++) {
				if(this.getCellNature(x, 0)!=CellNature.MTL)throw new InvariantError("inv1: getCellNature(x, y)==CellNature.HOL");
				for(int y=0;y<this.getHeight();y++) {
					if(this.getCellNature(x, y)==CellNature.HOL) throw new InvariantError("inv2: getCellNature(x, y)==CellNature.HOL");
					
				}
			}
			
		}
		
		
		
	}

	

}
