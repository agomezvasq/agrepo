package kmatrix;

import java.util.ArrayList;

public class AI {

//static block
	public final static int UP=0;
	public final static int RT=1;
	public final static int DW=2;
	public final static int LT=3;

//

	private MapGraph map;

	private Atom drone;
	private Atom solut;

	ArrayList<Atom> aP;

	private KStack sol;

	public AI(MapGraph map, Atom drone, Atom solut) {
		this.map=map;
		this.sol=new KStack();

		this.drone=drone;
		this.solut=solut;

		aP=new ArrayList<Atom>();
	}

	public int [] heuristics(Atom origin) {
		int [] sides=new int[] {UP,
								LT,
								RT,
								DW};

		int dy=solut.a-origin.a;
		int dx=origin.b-solut.b;				

		if (dx>dy) {
			sides[UP]=RT;
			sides[RT]=UP;
			sides[DW]=LT;
			sides[LT]=DW;

			if (dy>0) {
				sides[RT]=LT;
				sides[LT]=RT;
			}
			if (dx>0) {
				sides[UP]=DW;
				sides[DW]=UP;
			}
		}

		if (dy>0) {
			sides[UP]=DW;
			sides[DW]=UP;
		}
		if (dx>0) {
			sides[RT]=LT;
			sides[LT]=RT;
		}

		return sides;
	}


	public void findBest() {
		if ( btck(drone)!=null )
			paintStack();
	}

	public Atom btck(Atom atom) {
		if ( atom.flavor==MapGraph.SOLUT ) {
			sol.push(atom);
			return atom;	
		}

		aP.add(atom);
		for ( int n : heuristics(atom) ) {
			Atom c=atom.conn[n];
			if ( c!=null && !aP.contains(c) ) {	
				Atom a=btck(c);
				if ( a!=null ) {
					sol.push(a);
					return atom;
				}
			}
		}

		return null;
	}

	public void paintStack() {
		while ( !sol.empty() ) {
			Atom b=sol.pop();

			map.mD.grid[ b.a ][ b.b ].color();
			System.out.println("{"+b.a+","+b.b+"}");
		}
	}
}