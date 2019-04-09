package services;

public interface ScreenService {
	
	public int getHeight();
	public int getWidth();
	
	/**
	 * pre : 0<=y<=getHeight() && 0<=x<=getWidth() 
	 */
	public CellNature getCellNature(int x, int y);
	
	/**
	* pre: h > 0
	* pre: w > 0
	* post : Height(init(h,w)) = h
	* post : Width(init(h,w)) = w
	* post : forall(x) in [0;getWidth()[
	* 			 forall(y) in [0;getHeight()[, getCellNature(x,y) = EMP
	 */
	public void init(int h, int w);
	
	/**
	* pre: getCellNature(x,y) = PLT
	* post : getCellNature(x,y) = HOL
	* post : forall(x) in [0; getWidth()[ 
	* 			forall(y) in [0;getHeight()[, 
	* 				if(x!= u || y != v) 
	* 					getCellNature(x,y) = getCellNature(x,y)@pre
	 */
	public void dig(int x, int y);
	
	/**
	* pre: CellNature(S,x,y) = HOL
	* post : getCellNature(x,y) = PLT
	* post : forall(x) in [0; getWidth()[ 
	* 			forall(y) in [0;getHeight()[, 
						if(x!= u || y != v) 
		* 					getCellNature(x,y) = getCellNature(x,y)@pre
	 */
	public void fill(int x, int y);
	
}
