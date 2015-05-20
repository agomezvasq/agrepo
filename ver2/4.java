public class KTree {
	
	private K4Node root;

	public KTree(K4Node root) {
		this.root=root;
	}

	public final int maxHeight() { return root.maxHeight(); } 
}