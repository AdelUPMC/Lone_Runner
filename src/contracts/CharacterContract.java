package contracts;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import decorators.CharacterDecorator;
import services.CellNature;
import services.CharacterService;
import services.ScreenService;

public class CharacterContract extends CharacterDecorator {

	public CharacterContract(CharacterService delegate) {
		super(delegate);
	}
	
	public void checkInvariant() throws InvariantError, PreConditionError {
	
		//inv1
		if(			(this.getEnv().getCellNature(getWidth(), getHeigth())!=CellNature.EMP)
				&&	(this.getEnv().getCellNature(getWidth(), getHeigth())!=CellNature.HOL)
				&&	(this.getEnv().getCellNature(getWidth(), getHeigth())!=CellNature.LAD)
				&&	(this.getEnv().getCellNature(getWidth(), getHeigth())!=CellNature.HDR)
		) throw new InvariantError("inv1 : expected EMP,HOL,LAD,HDR but got "+getEnv().getCellNature(getWidth(), getHeigth()));
		
		//inv2
		if(getEnv().getCellContent(getWidth(), getHeigth()).getCharacters().size()>0){
			for(CharacterService c: this.getEnv().getCellContent(getWidth(),getHeigth()).getCharacters()) {
				if(!c.equals(this))throw new InvariantError("inv2: c!=this");
			}
		}
		
	}
	
	public void init(ScreenService s,int x, int y) throws PreConditionError, InvariantError {
		 //pre : getEnv().getCellNature(x,y) == CellNature.Emp
		if(getEnv().getCellNature(x,y) != CellNature.EMP) throw new PreConditionError("pre init :getEnv().getCellNature(x,y) != CellNature.EMP ");
		
		super.init(s, x, y);
		checkInvariant();
	}
	
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
	public void goLeft() throws InvariantError, PreConditionError, PostConditionError {
		checkInvariant();
		int getWidth_atPre=getWidth();
		int getHeigth_atPre= getHeigth();
		super.goLeft();
		//post1:
		if(getHeigth() != getHeigth_atPre) throw new PostConditionError("goLeft() post1: getHeight() != getHeigh_atPre");
		
		//post2:
		 if(getWidth_atPre== 0) {
			 if(getWidth() != getWidth_atPre) throw new PostConditionError("goLeft() post2: getWidth() != getWidth_atPre");
		}
		
		 //post3:
		 if(	(getEnv().getCellNature(getWidth()-1, getHeigth()) ==CellNature.MTL) 
			 || (getEnv().getCellNature(getWidth()-1, getHeigth()) == CellNature.PLT)) {
			 
			 	if(getWidth()!=getWidth_atPre) throw new PostConditionError("goLeft() post3: getWidth()!=getWidth_atPre");
		 }
		 
		 /*post4:if(!((getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.LAD) || 
		 *  		 (getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.HDR)) 
		 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
		 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
		 *  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.LAD)
		 *  		&& (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters.size()==0)) {
		 *  			getWidth() == getWidth()@pre;
		 *  */
		 if(!((getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.LAD) || 
				  		 (getEnv().getCellNature(getWidth(), getHeigth()) ==CellNature.HDR)) 
				  		&& (getEnv().getCellNature(getWidth(), getHeigth()-1) != CellNature.PLT)
				  		&& (getEnv().getCellNature(getWidth(), getHeigth()-1) != CellNature.MTL)
				  		&& (getEnv().getCellNature(getWidth(), getHeigth()-1) != CellNature.LAD)
				  		&& (getEnv().getCellContent(getWidth(), getHeigth()-1).getCharacters().size()==0)) 
		 {
			 //todo
		 }
	}
		 
		 
		 
	}

	
	


