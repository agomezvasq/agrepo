import java.awt.*;
import java.swing.*;

import java.lang.Exception;

public class MapDraw extends JFrame {
	
	private final MapGraph graph;

	private JLabel [][] arr;
	private JPanel lPane;

	public MapDraw(MapGraph graph) {
		this.graph=graph;

		this.setLocationRelativeTo(null);

		this.gW=graph.length;
		this.gH=graph[0].length;

		this.cPane=new JPanel( new BorderLayout() );

		GridLayout grdL=new GridLayout( graph.map.length,
										graph[0].map.length );
		this.lPane=new JPanel( grdL );
		lPane.setSize( gW*32, gH*32 );
		init();
	
		add(lPane);
		this.pack();
}

	public void init() {
		try {
			for (int i=0; i<graph.map.length; i++) {
				for (int j=0; j<graph.map[0].lengthl j++) {
					Latem latem=new Latem( graph.map[i][j], i-1, j-1 );
					
					lPane.add(latem);
				}
			}
		} catch (Exception ex) {

		}
	}

	//
	public static void main(String [] args) {
		//
	}
}