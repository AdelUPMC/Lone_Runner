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
	 *  		 (getEnv().getCellNature(getWidth()-1, getHeigth()) ==CellNature.PLT)) {
	 *  			getWidth()=getWidth@pre;
	 *  		}
	 *  \post : if(!((getEnv().getCellNature(getWidth()-1, getHeigth()) ==CellNature.LAD) || 
	 *  		 (getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.HDR)) 
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
	 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
	 *  		&& (getCellContent(getWidth(), getHeight()-1 != Character) {
	 *  			getWidth() = getWidth()@pre;
	 *  		}
	 */
	public void goLeft();
	
	public void goRight();
	
	public void goUp();
	
	public void goDown();
	
	
}

