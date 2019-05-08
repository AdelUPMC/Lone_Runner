package services;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;

public interface CharacterService {
	
	public int getHeight();
	public int getWidth();
	public EnvironnementService getEnv();

	
	/**
	 * \inv1: getEnv().getCellNature(getWidth(),getHeigth()) == CellNature.EMP
	 * 			|| getEnv().getCellNature(getWidth(),getHeigth()) == CellNature.HOL
	 * 			|| getEnv().getCellNature(getWidth(),getHeigth()) == CellNature.LAD
	 * 			||getEnv().getCellNature(getWidth(),getHeigth()) == CellNature.HDR
	 * 
	 * \inv2: if(getEnv().getCellContent(getWidth(), getHeight()).getCharacters.size()>0){
	 * 		\forall CharacterService c in getEnv().getCellContent.getCharacters()
	 * 			c.equals(this);
	 * 	}
	 */
	
	
	/**
	 * \pre : getEnv().getCellNature(x,y) == CellNature.EMP
	 * @throws PreConditionError 
	 * @throws InvariantError 
	 */
	public void init(ScreenService s,int x, int y) throws PreConditionError, InvariantError;
	
	
	
	/**
	 * \post1 : getHeight() == getHeight()@pre
	 * \post2 : if(getWidth()@pre == 0) {
	 *  			getWidth() == getWidth()@pre }
	 *  
	 *  \post3 : if((getEnv().getCellNature(getWidth()-1, getHeigth()) ==CellNature.MTL) || 
	 *  		 (getEnv().getCellNature(getWidth()-1, getHeigth()) == CellNature.PLT)) {
	 *  			getWidth()==getWidth@pre;
	 *  		}
	 *  
	 *  \post4 : if(!((getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.LAD) || 
	 *  		 (getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.HDR)) 
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.LAD)
	 *  		&& (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()==0)) {
	 *  			getWidth() == getWidth()@pre;
	 *  		}
	 *  
	 *  \post5 : if(getEnv().getCellContent(getWidth()-1, getHeight()).getCharacters.size()>0)
	 *  			getWidth() == getWidth()@pre;
	 *  
	 *	\post6 : if(		getWidth() != 0
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
	 * @throws PreConditionError 
	 * @throws InvariantError 
	 * @throws PostConditionError 
	 *			
	 */
	public void goLeft() throws InvariantError, PreConditionError, PostConditionError;
	
	
	
	
	
	
	/**
	 * \post : getHeight() == getHeight()@pre
	 * \post : if(getWidth()@pre == getEnv().getWidth()) {
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
	 * @throws PreConditionError 
	 * @throws InvariantError 
	 * @throws PostConditionError 
	 *			
	 */
	public void goRight() throws InvariantError, PreConditionError, PostConditionError;
	
	
	/**
	 * \post1 : getWidth() == getWidth()@pre
	 * 
	 * \post2 : if(getHeigth()@pre == getEnv().getHeight()) {
	 *  			getHeigth() == getHeigth()@pre }
	 *  
	 *  \post3 : if(getEnv().getCellNature(getWidth(), getHeigth()-1) == CellNature.PLT 
	 *  		|| (getEnv().getCellNature(getWidth(), getHeigth()-1) == CellNature.PLT) ) {
	 *  			getHeight() == getHeight()@pre;
	 *  		}
	 *  
	 *  \post3 : if(\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)){
	 *  				getHeight() == getHeight()@pre;
	 *  		} 
	 *  
	 *  \post4 : if( (getHeight() != getEnv().getHeight())
	 *  				&& ((getEnv().getCellNature(getWidth(), getHeight()+1) != CellNature.MTL)
	 *					|| (getEnv().getCellNature(getWidth(), getHeight()+1) != CellNature.PLT))
     *					&& ((getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
	 *				&& (getEnv().getCellNature(getWidth(), getHeight()+1) == CellNature.LAD))
	 *				&& (getEnv().getCellContent(getWidth(), getHeight()+1).getCharacters.size()==0)) {
	 *						getHeight() == getHeight()@pre+1;
	 *				}
	 *  
	 *  
	 *  
	 */
	
	
	public void goUp() throws InvariantError, PreConditionError, PostConditionError;
	
	
	/**
	 * \post1 : getWidth() == getWidth()@pre
	 * 
	 * \post2 : if(getHeigth()@pre == 0 ) {
	 *  			getHeigth() == getHeigth()@pre }
	 *  
	 *  \post3 : if(getEnv().getCellNature(getWidth(), getHeigth()-1) == CellNature.PLT 
	 *  		|| (getEnv().getCellNature(getWidth(), getHeigth()-1) == CellNature.PLT) ) {
	 *  			getHeight() == getHeight()@pre;
	 *  		}
	 *  
	 *  \post3 : if(getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()>0)){
	 *  				getHeight() == getHeight_atPre;
	 *  		} 
	 *  
	 *  \post4 : if( (getHeight() != 0)
 *  				&& ((getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
 *					|| (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT))
 *					&& ((getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
	 *				&& (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
	 *				&& (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()==0)) {
	 *						getHeight() == getHeight()@pre-1;
	 *				}
	 * @throws PreConditionError 
	 * @throws InvariantError 
	 * @throws PostConditionError 
	 *  
	 *  
	 *  
	 */
	public void goDown() throws InvariantError, PreConditionError, PostConditionError;
	
	
}

