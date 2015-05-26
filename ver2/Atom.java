class Atom {

	public Atom [] conn;
	public int flavor;

	public Atom( Atom cUP,
				 Atom cDW,
				 Atom cLT,
				 Atom cRT,
				 int flavor ) {
		this.conn=new Atom [] { cUP,
							 	cDW,
							 	cLT,
							 	cRT };

		this.flavor=flavor;
	}
}