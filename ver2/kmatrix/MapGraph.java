package kmatrix;

public class MapGraph {

//static block
	public final static int DRONE=2;
	public final static int BLANK=0;
	public final static int OBSTL=1;
	public final static int SOLUT=3;

//


	public Atom [][] map;

	public Atom drone;
	public Atom solut;

	public MapGraph(int h, int w) {
		map = new Atom[h][w];

		this.mD=mD;

		this.drone=null;
		this.solut=null;

		iMap();		
		gen();
	}

	public MapGraph(int [][] matrix) {	
		map = new Atom[ matrix.length ][ matrix[0].length ];

		this.mD=mD;

		iMap();
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				//unknown objs get replaced with OBSTL[1] in the graph matrix
				if ( matrix[i][j]>=0 && matrix[i][j]<=4 )
					map[i][j].flavor=matrix[i][j];
				else
					matrix[i][j]=1;
			}
		} 
		gen();
	}

	public void iMap() {
		for (int k=0; k<map.length; k++)
			for (int l=0; l<map[0].length; l++)
				map[k][l]=new Atom( null,
									null,
									null,
									null,
									BLANK, k, l );
	}

	public MapDraw mD;
	public void setAlpha(MapDraw mD) { this.mD=mD; }

	public void ai() {
		AI ai = new AI(this,drone,solut);
		ai.findBest();
	}

	//to print all the map call method gen()
	public void gen() {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if ( map[i][j].flavor==DRONE )
					drone=map[i][j];

				if ( map[i][j].flavor==SOLUT )
					solut=map[i][j];

				if ( map[i][j].flavor!=OBSTL ) {
					if ( i>0 && 
						 map[i-1][j].flavor!=OBSTL )
						map[i][j].conn[0]=map[i-1][j];

					if ( j>0 && 
						 map[i][j-1].flavor!=OBSTL )
						map[i][j].conn[3]=map[i][j-1];

					if ( i<map.length-1 && 
						 map[i+1][j].flavor!=OBSTL )
						map[i][j].conn[2]=map[i+1][j];

					if ( j<map[0].length-1 && 
						 map[i][j+1].flavor!=OBSTL )
						map[i][j].conn[1]=map[i][j+1];	

				}
			}
		}
	}
}