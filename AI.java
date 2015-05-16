import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;


class AI extends JFrame {
    private Matrix mtx;
    private PathTree pathTree;

    private JLabel [] jMatrix;

    enum Side {
    	UP, DOWN, LEFT, RIGHT
    };

    public AI(Matrix matrix, int drnC, int drnR) {
        this.mtx = matrix;
        this.pathTree = new PathTree();

        jMatrix = fillMatrix(mtx);

        this.mtx.initializeDrone(drnC, drnR);
        System.out.println("Initial state:");

        this.mtx.printMatrix();

        n=-2;

        this.treeFill(drnC, drnR, pathTree.root);

        this.pathTree.printTree();
    }

/*
    public JLabel [] fillMatrix(Matrix mtx) {
    	if ( !(mtx.cLength()==0 || mtx.rLength()==0 ) ) {
	    	JLabel [] jMatrix = new JLabel[ mtx.rLength() ][ mtx.cLength() ];

	    	for(int i=0; i<jMatrix.length; i++) {
	    		for (int j=0; j<jMatrix[0].length; j++) {
	    			JLabel jL = new JLabel( mtx.matrix[i][j] );

	    			

	    		}
	    	}

    	} else {

    	}
    }
*/

    public void path(int tarC, int tarR, Tree4 root) {
    	
    }

    private ArrayList<Tree4> arrPast;

    public void do(Tree4 node, boolean solution) {
    	for( Side s : Side.values() ) {
    		if ( mtx.check() )

    		arrPast.add(node);

    	}


    }

  	public Msg check(int c, int r, Side s) {
    	if ( (c<=matrix.length-1 && c>=0) && (m<=matrix[c].length-1 && m>=0) )
    		return ( matrix[c][r]==0 ) ? Msg.BLANK : Msg.DRONE_BLOCKED;
    	else
    		return Msg.LOC_OOB;
    }


}