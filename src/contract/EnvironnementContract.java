package contract;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import decorators.EnvironnementDecorator;
import impl.Collection_Set;
import impl.Item;
import impl.ItemType;
import services.CellNature;
import services.CharacterService;
import services.EditableScreen;
import services.EnvironnementService;

public class EnvironnementContract extends EnvironnementDecorator {

	public EnvironnementContract(EnvironnementService env) {
		super(env);
	}

	//invariants
	public void checkInvariant() throws InvariantError, PreConditionError {
		//inv1
		for(int x=0; x<getWidth();x++) {
			for(int y=0; x<getHeight();y++) {
				for(CharacterService c1 : this.getCellContent(x, y).getCharacters()) {
					for(CharacterService c2 : this.getCellContent(x, y).getCharacters()) {
						if(!c1.equals(c2)) throw new InvariantError("inv1");
					}
				}
			}
		}
		
		//inv2
		for(int x=0; x<getWidth();x++) {
			for(int y=0; x<getHeight();y++) {
				if(getCellNature(x,y)==CellNature.MTL||getCellNature(x,y)==CellNature.PLT){
					if(getCellContent(x,y).getCharacters().size()>0) throw new InvariantError("inv2 expected characters null but it isn't");
					if(getCellContent(x,y).getItems().size()>0) throw new InvariantError("inv2 expected items null but it isn't");
				}
			}
		}
		
		//inv3
		for(int x=0; x<getWidth();x++) {
			for(int y=0; x<getHeight();y++) {
				for(Item item : this.getCellContent(x, y).getItems()) {
					if(item.getNature() ==ItemType.Treasure){
						if(getCellNature(x,y) != CellNature.EMP)  throw new InvariantError("inv3 expected CellNature.EMP but got "+getCellNature(x,y));
						if(getCellNature(x,y-1)!=CellNature.PLT && getCellNature(x,y-1)!=CellNature.MTL) throw new InvariantError("inv3 expected CellNature.PLT or CellNature.MTL  but got "+getCellNature(x,y));
					}
				}
			}
		}
								
	}
	public void init(EditableScreen s) throws InvariantError, PostConditionError, PreConditionError {
		//pas de preconditions
		
		super.init(s);
		this.checkInvariant();
		
		//post
		for(int x=0; x<getWidth();x++) {
			for(int y=0; x<getHeight();y++) {
				if(getCellNature(x,y)!=getScreen().getCellNature(x,y)) throw new PostConditionError("post init : getCellNature(x,y)!=getScreen().getCellNature(x,y)");
			}
		}
	}
	
	public Collection_Set getCellContent(int x, int y) throws PreConditionError {

		//pre : 0<=y<getHeight() && 0<=x<getWidth() 
		if(x<0) throw new PreConditionError("Pre getCellContent: x<0");
		if(x>getWidth()) throw new PreConditionError("Pre getCellContent: x>getWidth()");
		if(y<0) throw new PreConditionError("Pre getCellContent: y<0");
		if(y>getHeight()) throw new PreConditionError("Pre getCellContent: y>getHeight()");
		
		return this.getCellContent(x, y);
	}
	//

	

}
