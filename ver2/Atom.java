class Atom {

	public Atom [] conn;
	public int flavor;

	public int x;
	public int y;

	public Atom( Atom cUP,
				 Atom cRT,
				 Atom cDW,
				 Atom cLT,
				 int flavor, int x, int y ) {
		this.conn=new Atom [] { cUP,
							 	cRT,
							 	cDW,
							 	cLT };

		this.x=x;
		this.y=y;

		this.flavor=flavor;
	}
}