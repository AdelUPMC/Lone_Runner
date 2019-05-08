package contracts;

import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import decorators.ScreenDecorator;
import services.CellNature;
import services.ScreenService;

public class ScreenContract extends ScreenDecorator {

	public ScreenContract(ScreenService delegate) {
		super(delegate);
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	public void init(int h, int w) throws PostConditionError, PreConditionError {
		//pre: h > 0
		//pre: w > 0
		if(h<0) {
			throw new PreConditionError("Hauteur négative à l'initialisation");
		}
		if(w<0) {
			throw new PreConditionError("Largeur négative à l'initialisation");
		}
		super.init(h, w);
		//post : getHeight() = h
		if(getHeight() != h)
			throw new PostConditionError("La hauteur n'a pas été correctement initialisée");
		//post : getWidth() = w
		if(getWidth() != w)
			throw new PostConditionError("La largeur n'a pas été correctement initialisée");
		
		/*post : forall(x) in [0;getWidth()[
		           forall(y) in [0;getHeight()[
		              getCellNature(x,y) = CellNature.EMP*/
		for(int i = 0; i<w; i++) {
			for(int j = 0; j<h; j++) {
				if(getCellNature(i, j) != CellNature.EMP) {
					throw new PostConditionError("Les cases ne sont pas vides à l'initialisation");
				}
			}
		}
	}
	
	
	public void dig(int x, int y) throws PostConditionError, PreConditionError {
		ScreenService atPre = null;
		try {
			atPre = (ScreenService) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pre: getCellNature(x,y) = CellNature.PLT
		if(getCellNature(x, y) != CellNature.PLT)
			throw new PreConditionError("La cible de \"dig\" n'est pas une plateforme");
		
		super.dig(x, y);
		
		//post : getCellNature(x,y) = CellNature.HOL
		if(getCellNature(x, y) != CellNature.HOL)
			throw new PostConditionError("Le trou n'as pas été creusé");
		
		 /*post : forall(u) in [0; getWidth()[ 
		            forall(v) in [0;getHeight()[, 
		               if(x!= u || y != v) 
		                   getCellNature(u,v) = getCellNature(u,v)@pre */
		for(int i = 0; i<getWidth(); i++) {
			for(int j = 0; j<getHeight(); j++) {
				if(x != i || y != j) {
					if(getCellNature(x, y) != atPre.getCellNature(x, y))
						throw new PostConditionError("Des cases autres que la cases cibles ont été modifiés");
				}
			}
		}
	}


		public void fill(int x, int y) throws PostConditionError, PreConditionError {
			ScreenService atPre = null;
			try {
				atPre = (ScreenService) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//pre: getCellNature(x,y) = CellNature.HOL
			if(getCellNature(x, y) != CellNature.HOL)
				throw new PreConditionError("La cible de \"fill\" n'est pas un trou");
			
			super.fill(x, y);
			
			//post : getCellNature(x,y) = CellNature.PLT
			if(getCellNature(x, y) != CellNature.PLT)
				throw new PostConditionError("Le trou n'as pas été rebouché");
			
			 /*post : forall(u) in [0; getWidth()[ 
			            forall(v) in [0;getHeight()[, 
			               if(x!= u || y != v) 
			                   getCellNature(u,v) = getCellNature(u,v)@pre */
			for(int i = 0; i<getWidth(); i++) {
				for(int j = 0; j<getHeight(); j++) {
					if(x != i || y != j) {
						if(getCellNature(x, y) != atPre.getCellNature(x, y))
							throw new PostConditionError("Des cases autres que la cases cibles ont été modifiés");
					}
				}
			}
		}
}
