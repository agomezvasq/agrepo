import java.util.Arrays;

class Matrix {
    public Tree4N [][] matrix;

/*
    public enum Msg {
        LOC_OOB,
        DRONE_BLOCKED,
    };

    public void throwEx(final Msg msg) {
        switch (msg) {
            case LOC_OOB:
                System.out.println("Out of Matrix bounds.")
            case DRONE_BLOCKED:
                System.out.println("Blocked by an obstacle. "); break;
        }
    }
*/

    public Matrix(int c, int r, int [] args) {
        this.matrix=new Tree4[c][r];
        //Solution is stored in (args[0], args[1])
        this.matrix[ args[0] ][ args[1] ] = 2;
    }

    public Matrix(int [][] matrix, int [] sol) {
        this.matrix = matrix;
        this.matrix[ sol[0] ][ sol[1] ] = 2;
    }

    public void printMatrix() {
        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[i].length; j++)
        		System.out.printf( matrix[i][j] + ( ( matrix[i][j]<0 ) ? "" : " " ) + " " );
        	System.out.println("");
        }
        System.out.println("");
    }   

    public void initializeDrone(int c, int r) {
        if ( correct(c,r) )
            matrix[c][r]=2;
    }

  

    public int rLength() { return ( this.matrix!=null ) this.matrix.length     : 0; }
    public int cLength() { return ( this.matrix!=null ) this.matrix[0].length  : 0; }
}