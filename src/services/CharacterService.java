package services;

public interface CharacterService {
	
	public int getHeight();
	public int getWidth();
	public EnvironnementService getEnv();

	/**
	 * \pre : getEnv().getCellNature(x,y) == CellNature.Emp
	 */
	public void init(ScreenService s,int x, int y);
	
	
	
	/**
	 * \post : getHeight() == getHeight()@pre
	 * \post : if(getWidth()@pre == 0) {
	 *  			getWidth() == getWidth()@pre }
	 *  
	 *  \post : if((getEnv().getCellNature(getWidth()-1, getHeigth()) ==CellNature.MTL) || 
	 *  		 (getEnv().getCellNature(getWidth()-1, getHeigth()) == CellNature.PLT)) {
	 *  			getWidth()==getWidth@pre;
	 *  		}
	 *  
	 *  \post : if(!((getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.LAD) || 
	 *  		 (getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.HDR)) 
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.LAD)
	 *  		&& (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()==0)) {
	 *  			getWidth() == getWidth()@pre;
	 *  		}
	 *  
	 *  \post : if(getEnv().getCellContent(getWidth()-1, getHeight()).getCharacters.size()>0)
	 *  			getWidth() == getWidth()@pre;
	 *  
	 *	\post : if(		getWidth() != 0
	 *
	 *					&& ((getEnv().getCellNature(getWidth()-1, getHeight()) != CellNature.MTL)
	 *					&& (getEnv().getCellNature(getWidth()-1, getHeight()) != CellNature.PLT))
	 *
	 *					&&( (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR))
	 *
	 *					|| ((getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
	 *					
	 *					||(getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()>0)
	 *
	 *					&& (getEnv().getCellContent(getWidth()-1, getHeight()).getCharacters.size()==0))
	 *			{
	 *				getWidth() == getWidth()@pre -1;
	 *			}
	 *			
	 */
	public void goLeft();
	
	
	
	
	
	
	/**
	 * \post : getHeight() == getHeight()@pre
	 * \post : if(getWidth()@pre == 0) {
	 *  			getWidth() == getWidth()@pre }
	 *  
	 *  \post : if((getEnv().getCellNature(getWidth()+1, getHeigth()) ==CellNature.MTL) || 
	 *  		 (getEnv().getCellNature(getWidth()+1, getHeigth()) == CellNature.PLT)) {
	 *  			getWidth()==getWidth()@pre;
	 *  		}
	 *  
	 *  \post : if(!((getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.LAD) || 
	 *  		 (getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.HDR)) 
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.LAD)
	 *  		&& (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()==0)) {
	 *  			getWidth() == getWidth()@pre;
	 *  		}
	 *  
	 *  \post : if(getEnv().getCellContent(getWidth()+1, getHeight()).getCharacters.size()>0)
	 *  			getWidth() == getWidth()@pre;
	 *  
	 *	\post : if(		getWidth() != 0
	 *
	 *					&& ((getEnv().getCellNature(getWidth()+1, getHeight()) != CellNature.MTL)
	 *					&& (getEnv().getCellNature(getWidth()+1, getHeight()) != CellNature.PLT))
	 *
	 *					&&( (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR))
	 *
	 *					|| ((getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
	 *					
	 *					||(getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()>0)
	 *
	 *					&& (getEnv().getCellContent(getWidth()+1, getHeight()).getCharacters.size()==0))
	 *			{
	 *				getWidth() == getWidth()@pre +1;
	 *			}
	 *			
	 */
	public void goRight();
	
	
	/**
	 * \post : getWidth() == getWidth()@pre
	 * \post : if(getHeigth()@pre == getEnv().getHeigth()) 
	 *  			getHeigth() == getHeigth()()@pre 
	 *  
	 *  \post : if((getEnv().getCellNature(getWidth(), getHeigth()+1) ==CellNature.MTL) || 
	 *  		 (getEnv().getCellNature(getWidth()+1, getHeigth()+1) == CellNature.PLT)) {
	 *  			getHeigth() == getHeigth()()@pre 
	 *  		}
	 *  
	 *  \post : if(getEnv().getCellContent(getWidth(), getHeight()+1).getCharacters.size()>0)
	 *  			getWidth() == getWidth()@pre;
	 *  
	 *	\post : if(	(getHeight() != getEnv().getHeight())
	 *
	 *				&& ((getEnv().getCellNature(getWidth(), getHeight()+1) != CellNature.MTL
	 *				|| getEnv().getCellNature(getWidth(), getHeight()+1) != CellNature.PLT))
	 *
	 *				&& ((getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
	 *				&& (getEnv().getCellNature(getWidth(), getHeight()+1) == CellNature.LAD))
	 *					
	 *
	 *				&& (getEnv().getCellContent(getWidth(), getHeight()+1).getCharacters.size()==0))
	 *			{
	 *				getHeight() == getHeight()@pre+1;
	 *			}
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
	 *  \post : if( (getHeight() != 0)
 *  				&& ((getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT))
 *					&& ((getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
	 *				&& (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
	 *				&& (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()==0)) {
	 *						getHeight() == getHeight()@pre-1;
	 *				}
	 *  
	 */
	public void goDown();
	
	
}

