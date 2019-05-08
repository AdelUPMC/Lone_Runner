package services;

import impl.Collection_Set;

public interface EnvironnementService extends ScreenService{
	
		/**
		 *  pre : 0<=y<getHeight() && 0<=x<getWidth() 
		 * 
		 */
		public Collection_Set getCellContent(int x, int y);
		public EditableScreen getScreen();
		
		/**
		 *  post : \forall x in [0;getWidth()[ 
		 *  			\forall y in [0;getHeight()[
		 *  					getCellNature(x,y)==getScreen().getCellNature(x,y)
		 *  				
		 * 
		 */
		public void init(EditableScreen s);
		
		
		/**
		 * 
		 * \inv: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[,
						\forall Character c1 in getCellContent(x,y).getCharacters()
							\forall Character c2 in getCellContent(x,y).getCharacters()
								c1 == c2
			
			\inv: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[
						if(getCellNature(x,y)==MTL||getCellNature(x,y)==PLR){
							getCellContent(x,y).getCharacters().size()==0;
							getCellContent(x,y).getItems().size()==0;
						}
			\inv: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[
						\forall item in getCellContent(x,y).getItems()
							if(item.getNature() ==ItemType.Treasure){
								getCellNature(x,y) == EMP && (getCellNature(x,y-1)==PLT||getCellNature(x,y-1)==MTL);
							}
					
		 */
	
	
}
