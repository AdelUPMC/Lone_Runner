package contracts;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import decorators.GuardDecorator;
import services.CellNature;
import services.CharacterService;
import services.GuardService;
import services.Move;

public class GuardContract extends GuardDecorator{
	public GuardContract(GuardService delegate) {
		super(delegate);
	}
	
	public void checkInvariant() throws PreConditionError, InvariantError {
		/*\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
	  			&& getHeight() < getTarget().getHeight()
	  			&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
	  				|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
	  				|| (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 			&& Math.abs(getTarget().getHeight() - getHeight()) < Math.abs(getTarget().getWidth()-getWidth())) {
	 			getBehaviour() == Move.Up; */
			if((getEnv().getCellNature(getWidth(), getHeight())== CellNature.LAD)
				&& getHeight() < getTarget().getHeight()
				&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
					|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
					|| getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0)
				&& Math.abs(getTarget().getHeight() - getHeight()) < Math.abs(getTarget().getWidth()-getWidth())) 
			{
				if(getBehaviour()!=Move.Up)
					throw new InvariantError("Le garde prend le mauvais chemin");
			}
		
		/*\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
		  			&& getHeight() > getTarget().getHeight()
		  			&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
		  				|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
		  				|| (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
		 			&& Math.abs(getTarget().getHeight() - getHeight()) < Math.abs(getTarget().getWidth()-getWidth())) {
		 			getBehaviour() == Move.Down;*/
		
			if((getEnv().getCellNature(getWidth(), getHeight())== CellNature.LAD)
					&& getHeight() > getTarget().getHeight()
					&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
						|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
						|| getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0)
					&& Math.abs(getTarget().getHeight() - getHeight()) < Math.abs(getTarget().getWidth()-getWidth())) 
			{
					if(getBehaviour()!=Move.Down)
						throw new InvariantError("Le garde prend le mauvais chemin");
			}

		 /*\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
		 			|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
		 			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
		 			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
		 			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
		 				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
		 			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
		 				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
		  			&& getWidth() > getTarget().getWidth()
		 			&& Math.abs(getTarget().getHeight().getHeight()) > Math.abs(getTarget().getWidth()-getWidth()|)) {
		 			getBehaviour() == Move.Left;*/
	
			if(		getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL
					|| (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR)
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT)
					||( getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL)
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP )
					&& (getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0)
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL )
					&& (getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0)
					&& (getWidth() > getTarget().getWidth())
					&& (Math.abs(getTarget().getHeight()-getHeight()) > (Math.abs(getTarget().getWidth()-getWidth()))))
			{
				if(getBehaviour()!=Move.Left)
					throw new InvariantError("Le garde prend le mauvais chemin");
			}
			
		/*\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
				 			|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
				 			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
				 			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
				 			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
				 				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
				 			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
				 				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
				  			&& getWidth() < getTarget().getWidth()
				 			&& Math.abs(getTarget().getHeight() - getHeight()) > Math.abs(getTarget().getWidth()-getWidth())) {
				 			getBehaviour() == Move.Right;*/
			if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
					|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
					|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
					|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
						&& (getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0))
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
						&& (getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0))
					&& getWidth() < getTarget().getWidth()
					&& Math.abs(getTarget().getHeight()-getHeight()) > Math.abs(getTarget().getWidth()-getWidth())) {
						if(getBehaviour()!=Move.Right)
							throw new InvariantError("Le garde prend le mauvais chemin");
			}
		
		/*\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
				 *			|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
				 *			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
				 *			|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
				 *			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
				 *				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
				 *			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
				 *				&& (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
				 * 			&& getWidth() == getTarget().getWidth()
				 *			&& Math.abs(getTarget().getHeight()- getHeight()) > Math.abs(getTarget().getWidth()-getWidth())) {
				 *			getBehaviour() == Move.Neutral;*/
	
			if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
					|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
					|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
					|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
						&& (getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0))
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
						&& (getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0))
					&& getWidth() == getTarget().getWidth()
					&& Math.abs(getTarget().getHeight()-getHeight()) > Math.abs(getTarget().getWidth()-getWidth())) {
						if(getBehaviour()!=Move.Neutral)
							throw new InvariantError("Le garde prend le mauvais chemin");
			}
	}
	
	
	public void ClimbLeft() throws PreConditionError, PostConditionError, InvariantError {
		checkInvariant();
		int x = getWidth();
		int y = getHeight();
		//pre : getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL
		if(getEnv().getCellNature(getWidth(), getHeight())==CellNature.HOL)
			throw new PreConditionError("Le garde veut sortir d'un trou mais n'est pas dans un trou");
		super.ClimbLeft();
		checkInvariant();
		
		/*\post : if(getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1)==CellNature.MTL ||
		  				getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1)==CellNature.PLT) {
		  					getWidth()==getWidth()@pre;
		  					getHeight()==getHeight()@pre;*/
		if(getEnv().getCellNature(x-1, y+1)==CellNature.MTL
				|| getEnv().getCellNature(x-1, y+1)==CellNature.PLT) {
			if(getWidth()!= x || getHeight() != y) {
				throw new PostConditionError("Le garde ne devait pas sortir du trou");	
			}
		}
		
		/*\post : if(\exists C Character \in getEnv().getCellContent(getWidth()@pre -1 , getHeight()@pre+1)){
	  				getWidth() == getWidth()@pre;
	  				getHeight()==getHeight()@pre;*/
		
		if(getEnv().getCellContent(x-1, y+1).getCharacters().size() > 0) {
			if(getWidth()!= x || getHeight() != y) {
				throw new PostConditionError("Le garde ne devait pas sortir du trou");
			}
		}
		
		
		/*\post : if(getWidth()@pre != 0 && !(getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1) == CellNature.MTL||
					getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1) == CellNature.PLT)
						&& !(\exists C Character \in getEnv().getCellContent(getWidth()@pre -1 , getHeight()@pre+1) {
				  				getWidth() == getWidth()@pre-1;
				  				getHeight() == getHeight@pre+1;*/
		
		
		if(x!=0  
				&& !(getEnv().getCellNature(x-1, y+1) !=CellNature.MTL
				|| getEnv().getCellNature(x-1, y+1) !=CellNature.PLT)
				&& !(getEnv().getCellContent(x-1, y+1).getCharacters().size() > 0)) {
			if(getWidth()!= x-1 || getHeight()!= y+1) {
				throw new PostConditionError("Erreur lors de la sortie du trou, du guarde");
			}
		}

	}

	public void ClimbRight() throws PreConditionError, InvariantError, PostConditionError {
		checkInvariant();
		int x = getWidth();
		int y = getHeight();
		//pre : getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL
		if(getEnv().getCellNature(getWidth(), getHeight())==CellNature.HOL)
				throw new PreConditionError("Le guarde veut sortir d'un trou mais n'est pas dans un trou");
		super.ClimbRight();
		checkInvariant();
		
		/*\post : if(getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1)==CellNature.MTL ||
		  				getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1)==CellNature.PLT) {
		  					getWidth()==getWidth()@pre;
		  					getHeight()==getHeight()@pre;*/
		if(getEnv().getCellNature(x+1, y+1)==CellNature.MTL
				|| getEnv().getCellNature(x+1, y+1)==CellNature.PLT) {
			if(getWidth()!= x || getHeight() != y) {
				throw new PostConditionError("Le guarde ne devait pas sortir du trou");
				
			}
		}
		
		/*\post : if(\exists C Character \in getEnv().getCellContent(getWidth()@pre +1 , getHeight()@pre+1)){
	  				getWidth() == getWidth()@pre;
	  				getHeight()==getHeight()@pre;*/
		
		if(getEnv().getCellContent(x+1, y+1).getCharacters().size() > 0) {
			if(getWidth()!= x || getHeight() != y) {
				throw new PostConditionError("Le guarde ne devait pas sortir du trou");
			}
		}
		
		
		/*\post : if(getWidth()@pre != 0 && !(getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1) == CellNature.MTL||
					getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1) == CellNature.PLT)
						&& !(\exists C Character \in getEnv().getCellContent(getWidth()@pre -1 , getHeight()@pre+1) {
				  				getWidth() == getWidth()@pre+1;
				  				getHeight() == getHeight@pre+1;*/
		
	
		if(		x!=0  
				&& !(getEnv().getCellNature(x+1, y+1) !=CellNature.MTL
				|| getEnv().getCellNature(x+1, y+1) !=CellNature.PLT)
				&& !(getEnv().getCellContent(x+1, y+1).getCharacters().size() > 0)) {
			if(getWidth()!= x+1 || getHeight()!= y+1) {
				throw new PostConditionError("Erreur lors de la sortie du trou, du guarde");
			}
		}

	}


	public int getId() {
		return super.getId();
	}


	public Move getBehaviour() {
		return super.getBehaviour();
	}


	public CharacterService getTarget() {
		return super.getTarget();
	}


	public int getTimeInHole() {
		return super.getTimeInHole();
	}

	public void Step() {
		super.Step();
	}

}
