import java.util.ArrayList;

class KNode {
	
	public ArrayList<KNode> chldrn;
	public int card;

	public KNode( KNode fChild,
				   int card ) {
		this.chldrn=new ArrayList<KNode>();

		if (fChild!=null)
			this.chldrn.add(fChild);

		this.card=card;
	}

	public final int maxHeight() {
		int max=0;
		for (KNode k : chldrn) {
			if (k!=null) {
				int h=k.maxHeight();
				if ( h>max )
					max=h;
			}
		}
		return max+1;
	}
}