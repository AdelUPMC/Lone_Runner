package services;

public interface CharacterService {
	
	public int getHeight();
	public int getWidth();
	public EnvironnementService getEnv();

	/**
	 * \pre : getEnv.getCellNature(hgt, wdt) == CellNature.Emp
	 */
	public void init(int hgt, int wdt);
	
	/**
	 * \post : getHeight() == getHeight()@pre
	 * \post : if(getWidth()@pre == 0) {
	 *  			getWidth() == getWidth()@pre }
	 *  
	 *  \post : if((getEnv().getCellNature(getWidth()-1, getHeigth()) ==CellNature.MTL) || 
	 *  		 (getEnv().getCellNature(getWidth()-1, getHeigth()) == CellNature.PLT)) {
	 *  			getWidth()==getWidth@pre;
	 *  		}
	 *  \post : if(!((getEnv().getCellNature(getWidth()-1, getHeigth()) ==CellNature.LAD) || 
	 *  		 (getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.HDR)) 
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
	 *  		&& (getCellContent(getWidth(), getHeight()-1 != Character))) {
	 *  			getWidth() == getWidth()@pre;
	 *  		}
	 *  \post : if(\exists C Character \in getEnv().getCellContent(getWidth() -1 , getHeight())){
	 *  				getWidth() == getWidth()@pre;
	 *  } 
	 *  
	 *	\post : if(((getWidth() != 0) && (getEnv().getCellNature(getWidth()-1, getHeight()) != CellNature.MTL
	 *				|| getEnv().getCellNature(getWidth()-1, getHeight()) != CellNature.PLT)
	 *					&&( (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
	 *					|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
	 *					&& !(\exists C Character \in getEnv().getCellContent(getWidth() -1 , getHeight())) {
	 *						getWidth() == getWidth()@pre-1;
	 *				}
	 */
	public void goLeft();
	
	/**
	 * \post : getHeigth() == getHeigth()@pre
	 * 
	 * \post : if(getWidth()@pre == getEnv().getWidth() ) {
	 *  			getWidth() == getWidth()@pre 
	 *  		}
	 *  
	 *  \post : if((getEnv().getCellNature(getWidth()+1, getHeigth()) == CellNature.MTL) || 
	 *  		 (getEnv().getCellNature(getWidth()+1, getHeigth()) == CellNature.PLT)) {
	 *  			getWidth() == getWidth@pre;
	 *  		}
	 *  
	 *  \post : if(!((getEnv().getCellNature(getWidth()+1, getHeigth()) ==CellNature.LAD) || 
	 *  		 (getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.HDR)) 
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
	 *  		&& (getCellContent(getWidth(), getHeight()+1 != Character))) {
	 *  			getWidth() = getWidth()@pre;
	 *  		}
	 *  \post : if(\exists C Character \in getEnv().getCellContent(getWidth() +1 , getHeight())){
	 *  				getWidth() == getWidth()@pre;
	 *  } 
	 *  
	 *	\post : if(((getWidth() != getEnv().getWidth() ) && (getEnv().getCellNature(getWidth()+1, getHeight()) != CellNature.MTL
	 *				|| getEnv().getCellNature(getWidth()+1, getHeight()) != CellNature.PLT)
	 *					&&( (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
	 *					|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
	 *					&& !(\exists C Character \in getEnv().getCellContent(getWidth() +1 , getHeight())) {
	 *						getWidth() == getWidth()@pre+1;
	 *				}
	 */
	public void goRight();
	
	/**
	 * \post : getWidth() == getWidth()@pre
	 * 
	 * \post : if(getHeigth()@pre == getEnv().getHeigth() ) {
	 *  			getHeigth() == getHeigth()@pre }
	 *  
	 *  \post : if(getEnv().getCellNature(getWidth(), getHeigth()+1) == CellNature.PLT 
	 *  		|| (getEnv().getCellNature(getWidth(), getHeigth()+1) == CellNature.PLT) ) {
	 *  			getHeight() == getHeight()@pre;
	 *  		}
	 *  
	 *  \post : if(\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()+1)){
	 *  				getHeight() == getHeight()@pre;
	 *  		} 
	 *  
	 *  \post : if( getHeight() != getEnv().getHeight() 
	 *  			&& (getEnv().getCellNature(getWidth(), getHeight()+1) != CellNature.MTL
	 *				|| getEnv().getCellNature(getWidth(), getHeight()+1) != CellNature.PLT)
	 *				&& getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
	 *				&& getEnv().getCellNature(getWidth(), getHeight()+1) == CellNature.LAD
	 *				&& !(\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()+1))) {
	 *						getHeight() == getHeight()@pre+1;
	 *				}
	 *  
	 */
	public void goUp();
	
	
	/**
	 * \post : getWidth() == getWidth()@pre
	 * 
	 * \post : if(getHeigth()@pre == 0 ) {
	 *  			getHeigth() == getHeigth()@pre }
	 *  
	 *  \post : if(getEnv().getCellNature(getWidth(), getHeigth()-1) == CellNature.PLT 
	 *  		|| (getEnv().getCellNature(getWidth(), getHeigth()-1) == CellNature.PLT) ) {
	 *  			getHeight() == getHeight()@pre;
	 *  		}
	 *  
	 *  \post : if(\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)){
	 *  				getHeight() == getHeight()@pre;
	 *  		} 
	 *  
	 *  \post : if(getHeight() != 0
 *  			&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
 *					|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
 *					&& getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
	 *				&& getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD
	 *				&& !(\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1))) {
	 *						getHeight() == getHeight()@pre-1;
	 *				}
	 *  
	 */
	public void goDown();
	
	
}

