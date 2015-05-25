import java.util.ArrayList;

public class AI {

//static block
	public final static int UP=0;
	public final static int DW=1;
	public final static int LT=2;
	public final static int RT=3;

	public final static int STAY=-1;

/*
	static {
		UP=0; 	 
		DW=1; 	  
		LT=2;    
		RT=3;
	}
*/
//

	private MapGraph map;

	public AI(MapGraph map) {
		this.map=map;
	}

	ArrayList<KNode> sol;

	public KNode find(Atom atom, int side) {
		if ( side>3 )
			return null;

		if ( atom.conn[side]==null || atom.conn[side].flavor==MapGraph.OBSTL ) 
			return find( atom, side+1 );

		if ( atom.conn[side].flavor==MapGraph.SOLUT )
			return new KNode( null, STAY );

		//if BLANK
		if ( atom.conn[side].flavor==MapGraph.BLANK ) {
			KNode kPSol = new KNode( find( atom.conn[side], UP ), side );
			sol.add( kPSol );

			if (sol!=null) {
				KNode bestS = sol.get(0);
				
				for (KNode pSol : sol) 
					if ( pSol.maxHeight()<bestS.maxHeight() ) 
						bestS=pSol;

				return bestS;
			}
		}
		return null;
	}
}