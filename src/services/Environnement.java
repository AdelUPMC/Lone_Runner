package services;

public interface Environnement extends ScreenService{
	
		/**
		 * 
		 * \inv: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[,
						\forall Character c1 in CellContent(E,x,y)
							\forall c2 in CellContent(E,x,y)
								c1 = c2
			
			\inv: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[
					if(CellNature(E,x,y)==MTL or CellNature(E,x,y)==PLR){
						CellContent(x,y) = null;
					}
			\inv: \forall x in [0;getWidth()[ 
					\forall y in [0;getHeight()[
						if()
					
		 */
	
	
}
