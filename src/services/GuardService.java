package services;

public interface GuardService extends CharacterService{
	
	public int getId();
	public Move getBehaviour();
	public CharacterService getTarget();
	public int getTimeInHole();
	
	/**
	 * \inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
	 * 			&& getHeight() < getTarget().getHeight()
	 * 			&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
	 * 				|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
	 * 				|| (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 *			&& Math.abs(getTarget().getHeight().getHeight()) < Math.abs(getTarget().getWidth()-getWidth()|)) {
	 *			getBehaviour() == Move.Up;
	 * 	
	 * \inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
	 * 			&& getHeight() > getTarget().getHeight()
	 * 			&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
	 * 				|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
	 * 				|| (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 *			&& Math.abs(getTarget().getHeight().getHeight()) < Math.abs(getTarget().getWidth()-getWidth()|)) {
	 *			getBehaviour() == Move.Down;
	 *
	 *
	 *\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
	 *			|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
	 *			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
	 *			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
	 *			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
	 *				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 *			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
	 *				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 * 			&& getWidth() > getTarget().getWidth()
	 *			&& Math.abs(getTarget().getHeight().getHeight()) > Math.abs(getTarget().getWidth()-getWidth()|)) {
	 *			getBehaviour() == Move.Left;
	 *
	 *
	 *	 *\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
	 *			|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
	 *			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
	 *			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
	 *			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
	 *				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 *			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
	 *				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 * 			&& getWidth() < getTarget().getWidth()
	 *			&& Math.abs(getTarget().getHeight().getHeight()) > Math.abs(getTarget().getWidth()-getWidth())) {
	 *			getBehaviour() == Move.Right;
	 *
	 *
	 * *\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
	 *			|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
	 *			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
	 *			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
	 *			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
	 *				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 *			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
	 *				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 * 			&& getWidth() == getTarget().getWidth()
	 *			&& Math.abs(getTarget().getHeight().getHeight()) > Math.abs(getTarget().getWidth()-getWidth())) {
	 *			getBehaviour() == Move.Neutral;
	 */
	
	
	/**
	 * \pre : getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL
	 * \post : if(getWidth()@pre==0) {
	 * 				getWidth()==getWidth()@pre;
	 * 				getHeight()==getHeight()@pre;
	 * 		}
	 * \post : if(getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1)==CellNature.MTL ||
	 * 				getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1)==CellNature.PLT) {
	 * 					getWidth()==getWidth()@pre;
	 * 					getHeight()==getHeight()@pre;
	 * 				}
	 * \post : if(\exists C Character \in getEnv().getCellContent(getWidth()@pre -1 , getHeight()@pre+1)){
	 * 				getWidth() == getWidth()@pre;
	 * 				getHeight()==getHeight()@pre;
	 * 			}
	 * \post : if(getWidth()@pre != 0 && (getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1)!= CellNature.MTL||
	 * 									getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1)!= CellNature.PLT)
	 * 									&& !(\exists C Character \in getEnv().getCellContent(getWidth()@pre -1 , getHeight()@pre+1) {
	 * 				getWidth() == getWidth()@pre-1;
	 * 				getHeight() == getHeight@pre+1;
	 * 
	 */
	public void ClimbLeft();
	
	/**
	 * \pre : getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL
	 * \post : if(getWidth()@pre==getEnv().getWidth()) {
	 * 				getWidth()==getWidth()@pre;
	 * 				getHeight()==getHeight()@pre;
	 * 		}
	 * \post : if(getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1)==CellNature.MTL ||
	 * 				getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1)==CellNature.PLT) {
	 * 					getWidth()==getWidth()@pre;
	 * 					getHeight()==getHeight()@pre;
	 * 				}
	 * \post : if(\exists C Character \in getEnv().getCellContent(getWidth()@pre +1 , getHeight()@pre+1)){
	 * 				getWidth() == getWidth()@pre;
	 * 				getHeight()==getHeight()@pre;
	 * 			}
	 * \post : if(getWidth()@pre != getEnv().getWidth() && (getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1)!= CellNature.MTL||
	 * 									getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1)!= CellNature.PLT)
	 * 									&& !(\exists C Character \in getEnv().getCellContent(getWidth()@pre +1 , getHeight()@pre+1) {
	 * 				getWidth() == getWidth()@pre+1;
	 * 				getHeight() == getHeight@pre+1;
	 * 
	 */
	public void ClimbRight();
	
	public void Step();
	
}
