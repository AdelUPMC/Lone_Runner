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
		if(			(this.getEnv().getCellNature(getWidth(), getHeight())!=CellNature.EMP)
				&&	(this.getEnv().getCellNature(getWidth(), getHeight())!=CellNature.HOL)
				&&	(this.getEnv().getCellNature(getWidth(), getHeight())!=CellNature.LAD)
				&&	(this.getEnv().getCellNature(getWidth(), getHeight())!=CellNature.HDR)
		) throw new InvariantError("inv1 : expected EMP,HOL,LAD,HDR but got "+getEnv().getCellNature(getWidth(), getHeight()));
		
		//inv2
		if(getEnv().getCellContent(getWidth(), getHeight()).getCharacters().size()>0){
			for(CharacterService c: this.getEnv().getCellContent(getWidth(),getHeight()).getCharacters()) {
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
	
	
	public void goLeft() throws InvariantError, PreConditionError, PostConditionError {
		//pre inv
		this.checkInvariant();
		int getWidth_atPre=getWidth();
		int getHeight_atPre= getHeight();
		super.goLeft();
		//post inv
		this.checkInvariant();
		//post1:
		if(getHeight() != getHeight_atPre) throw new PostConditionError("goLeft() post1: getHeight() != getHeigh_atPre");
		
		//post2:
		 if(getWidth_atPre== 0) {
			 if(getWidth() != getWidth_atPre) throw new PostConditionError("goLeft() post2: getWidth() != getWidth_atPre");
		}
		
		 //post3:
		 if(	(getEnv().getCellNature(getWidth()-1, getHeight()) ==CellNature.MTL) 
			 || (getEnv().getCellNature(getWidth()-1, getHeight()) == CellNature.PLT)) {
			 
			 	if(getWidth()!=getWidth_atPre) throw new PostConditionError("goLeft() post3: getWidth()!=getWidth_atPre");
		 }
		 
		 //post4:
		 if(!((getEnv().getCellNature(getWidth(), getHeight()) ==CellNature.LAD) || 
				  		 (getEnv().getCellNature(getWidth(), getHeight()) ==CellNature.HDR)) 
				  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
				  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
				  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.LAD)
				  		&& (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters().size()==0)) 
		 {
			 if(getWidth() != getWidth_atPre) throw new PostConditionError("goLeft() post4: getWidth()!=getWidth_atPre");
		 }
		 
		 //post5:
		 
		 if(getEnv().getCellContent(getWidth()-1, getHeight()).getCharacters().size()>0) {
			 if(getWidth() != getWidth_atPre)throw new PostConditionError("goLeft() post5: getWidth()!=getWidth_atPre");
		 }
		 
		 //post6:
		 if(		getWidth() != 0
				 && ((getEnv().getCellNature(getWidth()-1, getHeight()) != CellNature.MTL)
				 && (getEnv().getCellNature(getWidth()-1, getHeight()) != CellNature.PLT))
				 &&( (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
				 || (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR))
				 || ((getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT)
				 || (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL)
				 || (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
				 ||(getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters().size()>0)
				 && (getEnv().getCellContent(getWidth()-1, getHeight()).getCharacters().size()==0))
		 {
				 
			 if(getWidth() != getWidth_atPre -1)throw new PostConditionError("goLeft() post6: getWidth() != getWidth_atPre -1");
		 }
			  					 	 
	}
	
	public void goRight() throws InvariantError, PreConditionError, PostConditionError {
		//pre inv
				this.checkInvariant();
				int getWidth_atPre=getWidth();
				int getHeight_atPre= getHeight();
				super.goRight();
				//post inv
				this.checkInvariant();
				//post1:
				if(getHeight() != getHeight_atPre) throw new PostConditionError("goRight() post1: getHeight() != getHeigh_atPre");
				
				//post2:
				 if(getWidth_atPre== this.getEnv().getWidth()) {
					 if(getWidth() != getWidth_atPre) throw new PostConditionError("goRight() post2: getWidth() != getWidth_atPre");
				}
				
				 //post3:
				 if(	(getEnv().getCellNature(getWidth()+1, getHeight()) ==CellNature.MTL) 
					 || (getEnv().getCellNature(getWidth()+1, getHeight()) == CellNature.PLT)) {
					 
					 	if(getWidth()!=getWidth_atPre) throw new PostConditionError("goRight() post3: getWidth()!=getWidth_atPre");
				 }
				 
				 //post4:
				 if(!((getEnv().getCellNature(getWidth(), getHeight()) ==CellNature.LAD) || 
						  		 (getEnv().getCellNature(getWidth(), getHeight()) ==CellNature.HDR)) 
						  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT)
						  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
						  		&& (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.LAD)
						  		&& (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters().size()==0)) 
				 {
					 if(getWidth() != getWidth_atPre) throw new PostConditionError("goRight() post4: getWidth()!=getWidth_atPre");
				 }
				 
				 //post5:
				 
				 if(getEnv().getCellContent(getWidth()+1, getHeight()).getCharacters().size()>0) {
					 if(getWidth() != getWidth_atPre)throw new PostConditionError("goRight() post5: getWidth()!=getWidth_atPre");
				 }
				 
				 //post6:
				 if(		getWidth() != 0
						 && ((getEnv().getCellNature(getWidth()+1, getHeight()) != CellNature.MTL)
						 && (getEnv().getCellNature(getWidth()+1, getHeight()) != CellNature.PLT))
						 &&( (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
						 || (getEnv().getCellNature(getWidth(), getHeight()) == CellNature.HDR))
						 || ((getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT)
						 || (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.MTL)
						 || (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
						 ||(getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters().size()>0)
						 && (getEnv().getCellContent(getWidth()+1, getHeight()).getCharacters().size()==0))
				 {
						 
					 if(getWidth() != getWidth_atPre +1)throw new PostConditionError("goRight() post6: getWidth() != getWidth_atPre +1");
				 }
		
	}
	public void goUp() throws InvariantError, PreConditionError, PostConditionError {
		this.checkInvariant();
		int getWidth_atPre=getWidth();
		int getHeight_atPre= getHeight();
		super.goUp();
		this.checkInvariant();
		
		//
		
		//post1:
		if(getWidth() != getWidth_atPre)throw new PostConditionError("goUp() post1: getWidth() == getWidth_atPre");
		
		//post2:
		if(getHeight_atPre == getEnv().getHeight() ) {
			 if(getHeight() !=getHeight_atPre) throw new PostConditionError("goUp() post2: getHeight() !=getHeight_atPre");
		}
		
		//post3:
		 if(getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT 
			|| (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.PLT) ) {
				  			if(getHeight() != getHeight_atPre)throw new PostConditionError("goUp() post3: getHeight() !=getHeight_atPre");
		}
		 //post4:
		 if( (getHeight() != getEnv().getHeight())
				 && ((getEnv().getCellNature(getWidth(), getHeight()+1) != CellNature.MTL)
				 || (getEnv().getCellNature(getWidth(), getHeight()+1) != CellNature.PLT))
				 && ((getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
				 && (getEnv().getCellNature(getWidth(), getHeight()+1) == CellNature.LAD))
				 && (getEnv().getCellContent(getWidth(), getHeight()+1).getCharacters().size()==0)) 
		 {
			 if(getHeight() != getHeight_atPre+1)throw new PostConditionError("goUp() post4: getHeight() !=getHeight_atPre+1");
		 }

	}
	
	public void goDown() throws InvariantError, PreConditionError, PostConditionError  {
		this.checkInvariant();
		int getWidth_atPre=getWidth();
		int getHeight_atPre= getHeight();
		super.goDown();
		this.checkInvariant();
		
		//post1:
		if(getWidth() != getWidth_atPre)throw new PostConditionError("goDown() post1: getWidth() == getWidth_atPre");
		
		
		//post2 : 
		if(getHeight_atPre ==0) {
			 if(getHeight() != getHeight_atPre) throw  new PostConditionError("goDown() post2: getHeight() != getHeight_atPre");
		}
		//post3:
		if(this.getEnv().getCellContent(this.getWidth(), this.getHeight()).getCharacters().size()>0) {
			if(getHeight() != getHeight_atPre)throw  new PostConditionError("goDown() post3: getHeight() != getHeight_atPre");
		}
	
		//post4:
		 if(     (getHeight() != 0)
				 && ((getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.MTL)
				 || (getEnv().getCellNature(getWidth(), getHeight()-1) != CellNature.PLT))
				 && ((getEnv().getCellNature(getWidth(), getHeight()) == CellNature.LAD)
				 && (getEnv().getCellNature(getWidth(), getHeight()-1) == CellNature.LAD))
				 && (getEnv().getCellContent(getWidth(), getHeight()-1).getCharacters().size()==0)) 
		 {
			 if(getHeight() != getHeight_atPre-1)throw  new PostConditionError("goDown() post4: getHeight() != getHeight_atPre-1");
		 }
		
	}
		 
		 
	}

	
	


