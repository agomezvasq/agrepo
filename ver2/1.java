public class MapGraph {

	private int [][] matrix;

	public MapGraph(int [][] matrix) {
		LinkedList queue = new LinkedList();

		for (int i=0; i<matrix[0].length; i++) {
			for (int j=0; j<matrix.length; j++) {

				queue.add( new MapNode() );
			}
		}

	}
}