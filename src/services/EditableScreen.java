package services;

public interface EditableScreen extends ScreenService{

	//Ne pas oublier l'invariants de minimisation pour playable
	
	/**
	 * pre : 0<= h <= getHeight() && 0<= w <= getWidth()
	 * post : forall(x) in [0; getWidth()[ 
	* 			forall(y) in [0;getHeight()[, x!= u or y != v  => getCellNature(x,y) = getCellNature(x,y)@pre
	 */
	public void setNature(int h, int w, CellNature c);
}
