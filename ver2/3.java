class K4Node {
	
	public K4Node [] chldrn;
	public Data dat;

	public K4Node( Data dat,
				   K4Node nUP,
				   K4Node nDOWN,
				   K4Node nLEFT,
				   K4Node nRIGHT ) {
		this.chldrn = new K4Node[] { nUP, 
									 nDOWN, 
									 nLEFT, 
									 nRIGHT };
		this.dat=dat;
	}

	public final int maxHeight() {
		int max=0;
		for (K4Node k : chldrn) {
			if (k!=null) {
				int h=k.maxHeight();
				if ( h>max )
					max=h;
			}
		}
		return max+1;
	}
}