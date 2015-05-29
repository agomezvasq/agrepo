package kmatrix;

class Atom {

	public Atom [] conn;
	public int flavor;

	public int a;
	public int b;

	public Atom( Atom cUP,
				 Atom cRT,
				 Atom cDW,
				 Atom cLT,
				 int flavor, int a, int b ) {
		this.conn=new Atom [] { cUP,
							 	cRT,
							 	cDW,
							 	cLT };

		this.a=a;
		this.b=b;

		this.flavor=flavor;
	}
}