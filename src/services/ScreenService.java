package services;

import Exceptions.PostConditionError;
import Exceptions.PreConditionError;

public interface ScreenService {
	
	public int getHeight();
	public int getWidth();
	
	/**
	 * pre : 0<=y<getHeight() && 0<=x<getWidth() 
	 */
	public CellNature getCellNature(int x, int y);
	
	/**
	* pre: h > 0
	* pre: w > 0
	* post : getHeight() = h
	* post : getWidth() = w
	* post : forall(x) in [0;getWidth()[
	* 			 forall(y) in [0;getHeight()[
	* 				getCellNature(x,y) = CellNature.EMP
	 * @throws PostConditionError 
	 * @throws PreConditionError 
	 */
	public void init(int h, int w) throws PostConditionError, PreConditionError;
	
	/**
	* pre: getCellNature(x,y) = CellNature.PLT
	* post : getCellNature(x,y) = CellNature.HOL
	* post : forall(x) in [0; getWidth()[ 
	* 			forall(y) in [0;getHeight()[, 
	* 				if(x!= u || y != v) 
	* 					getCellNature(x,y) = getCellNature(x,y)@pre
	 * @throws PostConditionError 
	 * @throws PreConditionError 
	 */
	public void dig(int x, int y) throws PostConditionError, PreConditionError;
	
	/**
	* pre: getCellNature(x,y) = CellNature.HOL
	* post : getCellNature(x,y) = CellNature.PLT
	* post : forall(u) in [0; getWidth()[ 
	* 			forall(v) in [0;getHeight()[, 
						if(x!= u || y != v) 
		* 					getCellNature(u,v) = getCellNature(u,v)@pre
	 * @throws PostConditionError 
	 * @throws PreConditionError 
	 */
	public void fill(int x, int y) throws PostConditionError, PreConditionError;
	
}
