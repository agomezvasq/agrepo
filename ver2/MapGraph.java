public class MapGraph {

//static block
	public final static int DRONE=2;
	public final static int BLANK=0;
	public final static int OBSTL=1;
	public final static int SOLUT=3;

//


	public Atom [][] map;

	public MapGraph(int h, int w) {
		map = new Atom[h][w];

		iMap();		
		gen();
	}

	public MapGraph(int [][] matrix) {	
		map = new Atom[ matrix.length ][ matrix[0].length ];

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
									BLANK );
	}

	public void fast() {
		
	}

	//to print all the map call method gen()
	public void gen() {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if ( i>0 && 
					 map[i-1][j].flavor!=OBSTL )
					map[i][j].conn[0]=map[i-1][j];

				if ( j>0 && 
					 map[i][j-1].flavor!=OBSTL )
					map[i][j].conn[2]=map[i][j-1];

				if ( i<map.length-1 && 
					 map[i+1][j].flavor!=OBSTL )
					map[i][j].conn[1]=map[i+1][j];

				if ( j<map[0].length-1 && 
					 map[i][j+1].flavor!=OBSTL )
					map[i][j].conn[3]=map[i][j+1];

				print(i,j);
			}
			p();
		}

		AI ai = new AI(this);
		if ( map[0][0]!=null )
			ai.btck( map[0][0] );
		ai.paintStack();
	}

    public void swOBSTL(int a, int b) {
		if ( a<map.length && b<map[0].length ) 
			if ( map[a][b].flavor==BLANK )
				map[a][b].flavor=OBSTL;
			else
				map[a][b].flavor=BLANK;
	}


/*
*   O↓→ ← O↓→ ← O↓→ ← O↓→ ← O↓→ ← O↓  
*  ↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑D↓→ ←↑O↓  
*  ↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓  
*  ↑O↓→ ←↑X↓→ ←↑X↓→ ←↑X↓→ ←↑O↓→ ←↑O↓  
*  ↑O↓→ ←↑O↓→ ←↑X↓→ ←↑X↓→ ←↑O↓→ ←↑O↓  
*  ↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓  
*  ↑O → ←↑Ω → ←↑O → ←↑O → ←↑O → ←↑O   
*
* MapGraph concept
*
* Input matrix
* 000000
* 000020 
* 000000 
* 011100 
* 001100 
* 000000
* 030000
*/

	public void print(int a, int b) {
		switch (map[a][b].flavor) {
			case BLANK: p("O"); break;
			case SOLUT: p("Ω"); break;
			case OBSTL: p("X"); break;
		}

		if (b!=0) p("←");
		else	  s();

		if (a!=0) p("↑");
		else      s();

		if (a!=map.length-1) 	p("↓");
		else 				   	s();

		if (b!=map[0].length-1) p("→");
		else 				   	s();

		s();
	}

	public void p(String s) { System.out.print(s);    }
	public void s()		    { System.out.print(" ");  }
	public void p()		    { System.out.println(""); }
}