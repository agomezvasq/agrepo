class Atom {

	public Atom [] conn;
	public int flavor;

	public Atom( Atom connUP,
				 Atom connDW,
				 Atom connLT,
				 Atom connRT,
				 int flavor ) {
		this.conn=new Atom [] { connUP,
								connDW,
								connLT,
								connRT };

		this.flavor=flavor;
	}

	public void printA() {
		System.out.print( this.flavor + "\n" );

		for ( Atom a : conn ) {
			a.printA();
		}
	}
}