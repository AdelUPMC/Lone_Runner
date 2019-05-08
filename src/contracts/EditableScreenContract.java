package contracts;

import java.util.HashMap;
import java.util.Map;
import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import decorators.EditableScreenDecorators;
import javafx.util.Pair;
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
	
	
	/**
	 * pre : 0<= y < getHeight() && 0 <=x<=getWidth()
	 * post : forall(u) in [0; getWidth()[ 
	* 			forall(v) in [0;getHeight()[
	* 				if(x!= u || y != v)
	* 					getCellNature(u,v) = getCellNature(u,v)@pre
	 * @throws InvariantError 
	 * @throws PreConditionError 
	 * @throws PostConditionError 
	 */
	
	public void setNature(int x, int y, CellNature c) throws InvariantError, PreConditionError, PostConditionError {
		//pre
		if(x<0)throw new PreConditionError("setNature pre: x<0");
		if(x>getWidth())throw new PreConditionError("setNature pre: x>getWidth()");
		if(y<0)throw new PreConditionError("setNature pre: y<0");
		if(y>getHeight())throw new PreConditionError("setNature pre: y>getHeight()");
	
		//capture
		Map<Pair<Integer,Integer>,CellNature> cellnatures_atPre= new HashMap<>();
		for(int u=0;x<this.getWidth();u++) {
			for(int v=0;v<this.getHeight();v++) {
				cellnatures_atPre.put(new Pair<Integer, Integer>(u,v),getCellNature(u,v));
			}
		}
		
		
		this.checkInvariant();
		super.setNature(x, y, c);
		this.checkInvariant();
		
		//post
		for(int u=0;x<this.getWidth();u++) {
			for(int v=0;v<this.getHeight();v++) {
				if(x!= u || y != v)
					if(getCellNature(u,v) != cellnatures_atPre.get(new Pair<Integer, Integer>(u,v))) throw new PostConditionError("setNature post:getCellNature(u,v) != cellnatures_atPre(u,v)");
			}
		}
	
	}
	
	


}
