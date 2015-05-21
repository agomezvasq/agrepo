import java.util.ArrayList;

public class AI {

	private MapGraph map;

	public AI(MapGraph map) {
		this.map=map;
	}

	ArrayList<KNode> sol;
	int nSol;

	public KNode find(Atom atom, int side) {
		if ( side>3 )
			return null;

		if ( atom.conn[side]==null || atom.conn[side].flavor==MapGraph.OBSTL ) 
			return find( atom, side+1 );

		if ( atom.conn[side].flavor==MapGraph.SOLUT )
			return new KNode( null, STAY );

		//if BLANK
		if ( atom.conn[side]==MapGraph.BLANK ) {
			KNode kPSOl = new KNode( find( atom.conn[side], UP ), side );
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