package services;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import impl.Collection_Set;

public interface EnvironnementService extends ScreenService{
	
		/**
		 *  pre : 0<=y<getHeight() && 0<=x<getWidth() 
		 * @throws PreConditionError 
		 * 
		 */
		public Collection_Set getCellContent(int x, int y) throws PreConditionError;
		public EditableScreen getScreen();
		
		/**
		 *  post : \forall x in [0;getWidth()[ 
		 *  			\forall y in [0;getHeight()[
		 *  					getCellNature(x,y)==getScreen().getCellNature(x,y)
		 * @throws InvariantError 
		 * @throws PostConditionError 
		 * @throws PreConditionError 
		 *  				
		 * 
		 */
		public void init(EditableScreen s) throws InvariantError, PostConditionError, PreConditionError;
		
		
		/**
		 * 
		 * \inv1: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[,
						\forall Character c1 in getCellContent(x,y).getCharacters()
							\forall Character c2 in getCellContent(x,y).getCharacters()
								c1 == c2
			
			\inv2: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[
						if(getCellNature(x,y)==CellNature.MTL||getCellNature(x,y)==CellNature.PLT){
							getCellContent(x,y).getCharacters().size()==0;
							getCellContent(x,y).getItems().size()==0;
						}
			\inv3: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[
						\forall item in getCellContent(x,y).getItems()
							if(item.getNature() ==ItemType.Treasure){
								getCellNature(x,y) == CellNature.EMP && (getCellNature(x,y-1)==CellNature.PLT||getCellNature(x,y-1)==CellNature.MTL);
							}
					
		 */
		//
	
}
