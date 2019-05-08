package contracts;

import Exceptions.InvariantError;
import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import decorators.GuardDecorator;
import services.CellNature;
import services.CharacterService;
import services.EnvironnementService;
import services.GuardService;
import services.Move;
import services.ScreenService;

public class GuardContract extends GuardDecorator{

	public GuardContract(GuardService delegate) {
		super(delegate);
	}
	
	public void checkInvariant() {
		/*\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
	  			&& getHeight() < getTarget().getHeight()
	  			&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
	  				|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
	  				|| (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
	 			&& Math.abs(getTarget().getHeight() - getHeight()) < Math.abs(getTarget().getWidth()-getWidth())) {
	 			getBehaviour() == Move.Up; */
		try {
			if((getEnv().getCellNature(getWidth(), getHeight())== CellNature.LAD)
				&& getHeight() < getTarget().getHeight()
				&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
					|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
					|| getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0)
				&& Math.abs(getTarget().getHeight() - getHeight()) < Math.abs(getTarget().getWidth()-getWidth())) {
				if(getBehaviour()!=Move.Up)
					throw new InvariantError("Le guarde prend le mauvais chemin");
			}
		} catch (PreConditionError | InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*\inv : if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD
		  			&& getHeight() > getTarget().getHeight()
		  			&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
		  				|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
		  				|| (\exists C Character \in getEnv().getCellContent(getWidth() , getHeight()-1)))
		 			&& Math.abs(getTarget().getHeight() - getHeight()) < Math.abs(getTarget().getWidth()-getWidth())) {
		 			getBehaviour() == Move.Down;*/
		try {
			if((getEnv().getCellNature(getWidth(), getHeight())== CellNature.LAD)
					&& getHeight() > getTarget().getHeight()
					&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL
						|| getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT
						|| getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0)
					&& Math.abs(getTarget().getHeight() - getHeight()) < Math.abs(getTarget().getWidth()-getWidth())) {
					if(getBehaviour()!=Move.Down)
						throw new InvariantError("Le guarde prend le mauvais chemin");
				}
		} catch (PreConditionError | InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		try {
			if(getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL 
					|| getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR
					|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT
					|| getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.EMP 
						&& (getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0))
					|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.HOL 
						&& (getEnv().getCellContent(getWidth() , getHeight()-1).getCharacters().size()>0))
					&& getWidth() > getTarget().getWidth()
					&& Math.abs(getTarget().getHeight()-getHeight()) > Math.abs(getTarget().getWidth()-getWidth())) {
						if(getBehaviour()!=Move.Left)
							throw new InvariantError("Le guarde prend le mauvais chemin");
			}
		} catch (PreConditionError | InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		try {
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
							throw new InvariantError("Le guarde prend le mauvais chemin");
			}
		} catch (PreConditionError | InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		try {
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
							throw new InvariantError("Le guarde prend le mauvais chemin");
			}
		} catch (PreConditionError | InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ClimbLeft() {
		checkInvariant();
		int x = getWidth();
		int y = getHeight();
		//pre : getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL
		if(getEnv().getCellNature(getWidth(), getHeight())==CellNature.HOL)
			try {
				throw new PreConditionError("Le guarde veut sortir d'un trou mais n'est pas dans un trou");
			} catch (PreConditionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		super.ClimbLeft();
		
		/*\post : if(getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1)==CellNature.MTL ||
		  				getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1)==CellNature.PLT) {
		  					getWidth()==getWidth()@pre;
		  					getHeight()==getHeight()@pre;*/
		if(getEnv().getCellNature(x-1, y+1)==CellNature.MTL
				|| getEnv().getCellNature(x-1, y+1)==CellNature.PLT) {
			if(getWidth()!= x || getHeight() != y) {
				try {
					throw new PostConditionError("Le guarde ne devait pas sortir du trou");
				} catch (PostConditionError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/*\post : if(\exists C Character \in getEnv().getCellContent(getWidth()@pre -1 , getHeight()@pre+1)){
	  				getWidth() == getWidth()@pre;
	  				getHeight()==getHeight()@pre;*/
		try {
			if(getEnv().getCellContent(x-1, y+1).getCharacters().size() > 0) {
				if(getWidth()!= x || getHeight() != y) {
					throw new PostConditionError("Le guarde ne devait pas sortir du trou");
				}
			}
		} catch (PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (PostConditionError e) {
			e.printStackTrace();
		}
		
		/*\post : if(getWidth()@pre != 0 && !(getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1) == CellNature.MTL||
					getEnv().getCellNature(getWidth()@pre -1, getHeight()@pre+1) == CellNature.PLT)
						&& !(\exists C Character \in getEnv().getCellContent(getWidth()@pre -1 , getHeight()@pre+1) {
				  				getWidth() == getWidth()@pre-1;
				  				getHeight() == getHeight@pre+1;*/
		
		try {
			if(x!=0  
					&& !(getEnv().getCellNature(x-1, y+1) !=CellNature.MTL
					|| getEnv().getCellNature(x-1, y+1) !=CellNature.PLT)
				&& !(getEnv().getCellContent(x-1, y+1).getCharacters().size() > 0)) {
				if(getWidth()!= x-1 || getHeight()!= y+1) {
					throw new PostConditionError("Erreur lors de la sortie du trou, du guarde");
				}
			}
		} catch (PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PostConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkInvariant();
	}

	public void ClimbRight() {
		checkInvariant();
		int x = getWidth();
		int y = getHeight();
		//pre : getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HOL
		if(getEnv().getCellNature(getWidth(), getHeight())==CellNature.HOL)
			try {
				throw new PreConditionError("Le guarde veut sortir d'un trou mais n'est pas dans un trou");
			} catch (PreConditionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		super.ClimbRight();
		
		/*\post : if(getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1)==CellNature.MTL ||
		  				getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1)==CellNature.PLT) {
		  					getWidth()==getWidth()@pre;
		  					getHeight()==getHeight()@pre;*/
		if(getEnv().getCellNature(x+1, y+1)==CellNature.MTL
				|| getEnv().getCellNature(x+1, y+1)==CellNature.PLT) {
			if(getWidth()!= x || getHeight() != y) {
				try {
					throw new PostConditionError("Le guarde ne devait pas sortir du trou");
				} catch (PostConditionError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/*\post : if(\exists C Character \in getEnv().getCellContent(getWidth()@pre +1 , getHeight()@pre+1)){
	  				getWidth() == getWidth()@pre;
	  				getHeight()==getHeight()@pre;*/
		try {
			if(getEnv().getCellContent(x+1, y+1).getCharacters().size() > 0) {
				if(getWidth()!= x || getHeight() != y) {
					throw new PostConditionError("Le guarde ne devait pas sortir du trou");
				}
			}
		} catch (PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (PostConditionError e) {
			e.printStackTrace();
		}
		
		/*\post : if(getWidth()@pre != 0 && !(getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1) == CellNature.MTL||
					getEnv().getCellNature(getWidth()@pre +1, getHeight()@pre+1) == CellNature.PLT)
						&& !(\exists C Character \in getEnv().getCellContent(getWidth()@pre -1 , getHeight()@pre+1) {
				  				getWidth() == getWidth()@pre+1;
				  				getHeight() == getHeight@pre+1;*/
		
		try {
			if(x!=0  
					&& !(getEnv().getCellNature(x+1, y+1) !=CellNature.MTL
					|| getEnv().getCellNature(x+1, y+1) !=CellNature.PLT)
				&& !(getEnv().getCellContent(x+1, y+1).getCharacters().size() > 0)) {
				if(getWidth()!= x+1 || getHeight()!= y+1) {
					throw new PostConditionError("Erreur lors de la sortie du trou, du guarde");
				}
			}
		} catch (PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PostConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkInvariant();
	}

	public int getHeight() {
		return super.getHeight();
	}

	public int getId() {
		return super.getId();
	}

	public int getWidth() {
		return super.getWidth();
	}

	public Move getBehaviour() {
		return super.getBehaviour();
	}

	public EnvironnementService getEnv() {
		return super.getEnv();
	}

	public CharacterService getTarget() {
		return super.getTarget();
	}

	public void init(ScreenService s, int x, int y) {
		try {
			super.init(s, x, y);
		} catch (PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getTimeInHole() {
		return super.getTimeInHole();
	}


	public void goLeft() {
		try {
			super.goLeft();
		} catch (InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PreConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PostConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goRight() throws InvariantError, PreConditionError, PostConditionError {
		super.goRight();
	}

	public void goUp() throws InvariantError, PreConditionError, PostConditionError {
		super.goUp();
	}

	public void goDown() {
		super.goDown();
	}

	public void Step() {
		super.Step();
	}

	
	
	

}
