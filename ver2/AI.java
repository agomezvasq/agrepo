import java.util.ArrayList;

public class AI {

	private MapGraph map;

	private KStack sol;

	public AI(MapGraph map) {
		this.map=map;
		this.sol=new KStack();
	}

	public Atom btck(Atom atom) {
		if ( atom.flavor==MapGraph.SOLUT )
			return atom;

		for ( Atom c : atom.conn ) {
			if (c!=null) {
				System.out.println(c.flavor);
				Atom a=btck(c);
				if (a!=null) {
					sol.push(a);
					return a;
				}	
			}
		}

		return null;
	}

	public void paintStack() {
		while ( !sol.empty() ) {
			Atom b=sol.pop();
			
			System.out.println("at");
		}
	}
}