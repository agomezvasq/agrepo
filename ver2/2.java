public class Backtrack {

	private MapGraph map;

	public final static int DRONE;
	public final static int BLANK;
	public final static int OBSTL;
	public final static int SOLUT;

	static {
		DRONE=2;
		BLANK=0;
		OBSTL=1;
		SOLUT=3;
	}

		/*
	*public static int getFlavorStuff(Flavor flavor) {
	*	switch (flavor) {
	*		case DRONE: return 2; break;
	*		case BLANK: return 0; break;
	*		case OBSTL: return 1; break;
	*		case SOLUT: return 3; break;
	*	}
	*}
	*/


	public Backtrack(MapGraph map) {
		this.map=map;
	}

	/*
	*	B -
	* A 0 0 0 0 0 
	* | 0 1 0 2 0  
	*   0 0 0 0 0
	*   0 1 1 1 0
	*   0 0 1 1 0
	*   0 3 0 0 0
	*
	* 0=BLNK, 1=OBST, 2=DRON, 3=SOLT
	*/

	public void Backtrack(Atom atom) {
		for ( Atom a : atom.conn[] ) {
			if ( a.flavor==DRONE )
		}		
	}
}