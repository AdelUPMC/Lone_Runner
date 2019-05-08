package services;

public interface EditableScreen extends ScreenService{
	
	public boolean isPlayable();
	
	//Ne pas oublier l'invariants de minimisation pour playable
	
	
		
	/**
	 * pre : 0<= y < getHeight() && 0 <=x<=getWidth()
	 * post : forall(u) in [0; getWidth()[ 
	* 			forall(v) in [0;getHeight()[
	* 				if(x!= u || y != v)
	* 					getCellNature(u,v) = getCellNature(u,v)@pre
	 */
	public void setNature(int x, int y, CellNature c);
	
	/**
	 *  \inv:  isPlayable()==true
	 * 	\inv:forall(x) in [0; getWidth()[ 
	 * 			forall(y) in [0;getHeight()[
	 * 				getCellNature(x,y)!=HOL
	 * \inv:forall(x) in [0; getWidth()[
	 * 	 	getCellNature(x,0)=MTL
	 */
}
