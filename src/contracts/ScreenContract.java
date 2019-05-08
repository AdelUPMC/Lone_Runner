package contracts;

import java.util.HashMap;
import java.util.Map;

import Exceptions.PostConditionError;
import Exceptions.PreConditionError;
import decorators.ScreenDecorator;
import javafx.util.Pair;
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
		//pre: getCellNature(x,y) = CellNature.PLT
		if(getCellNature(x, y) != CellNature.PLT)
			throw new PreConditionError("La cible de \"dig\" n'est pas une plateforme");
		
		
		
		//capture
		Map<Pair<Integer,Integer>,CellNature> cellnatures_atPre= new HashMap<>();
		for(int u=0;x<this.getWidth();u++) {
			for(int v=0;v<this.getHeight();v++) {
				cellnatures_atPre.put(new Pair<Integer, Integer>(u,v),getCellNature(u,v));
			}
		}
		super.dig(x, y);
		
		//post : getCellNature(x,y) = CellNature.HOL
		if(getCellNature(x, y) != CellNature.HOL)
			throw new PostConditionError("Le trou n'as pas été creusé");
		
		 /*post : forall(u) in [0; getWidth()[ 
		            forall(v) in [0;getHeight()[, 
		               if(x!= u || y != v) 
		                   getCellNature(u,v) = getCellNature(u,v)@pre */
		//post
		for(int u=0;x<this.getWidth();u++) {
			for(int v=0;v<this.getHeight();v++) {
				if(x!= u || y != v)
					if(getCellNature(u,v) != cellnatures_atPre.get(new Pair<Integer, Integer>(u,v))) throw new PostConditionError("setNature post:getCellNature(u,v) != cellnatures_atPre(u,v)");
			}
		}
	}


		public void fill(int x, int y) throws PostConditionError, PreConditionError {
			
			//pre: getCellNature(x,y) = CellNature.HOL
			if(getCellNature(x, y) != CellNature.HOL)
				throw new PreConditionError("La cible de \"fill\" n'est pas un trou");
			//capture
			Map<Pair<Integer,Integer>,CellNature> cellnatures_atPre= new HashMap<>();
			for(int u=0;x<this.getWidth();u++) {
				for(int v=0;v<this.getHeight();v++) {
					cellnatures_atPre.put(new Pair<Integer, Integer>(u,v),getCellNature(u,v));
				}
			}
			
			super.fill(x, y);
			
			//post : getCellNature(x,y) = CellNature.PLT
			if(getCellNature(x, y) != CellNature.PLT)
				throw new PostConditionError("Le trou n'as pas été rebouché");
			
			 /*post : forall(u) in [0; getWidth()[ 
			            forall(v) in [0;getHeight()[, 
			               if(x!= u || y != v) 
			                   getCellNature(u,v) = getCellNature(u,v)@pre */
			//post
			for(int u=0;x<this.getWidth();u++) {
				for(int v=0;v<this.getHeight();v++) {
					if(x!= u || y != v)
						if(getCellNature(u,v) != cellnatures_atPre.get(new Pair<Integer, Integer>(u,v))) throw new PostConditionError("setNature post:getCellNature(u,v) != cellnatures_atPre(u,v)");
				}
			}
		}
}
