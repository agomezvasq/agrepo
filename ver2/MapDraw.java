import java.awt.*;
import javax.swing.*;

import java.lang.Exception;

public class MapDraw extends JFrame {
	
	private final MapGraph graph;

	private int gW;
	private int gH;

	private JLabel [][] arr;
	private JPanel lPane;

	public MapDraw(MapGraph graph) {
		this.graph=graph;

		this.setLocationRelativeTo(null);

		this.gW=graph.map.length;
		this.gH=graph.map[0].length;

		GridLayout grdL=new GridLayout( graph.map.length,
										graph.map[0].length );
		this.lPane=new JPanel( grdL );
		lPane.setSize( gW*32, gH*32 );
		init();
	
		add(lPane);

		this.setContentPane(lPane);
		this.pack();
}

	public void init() {
		try {
			for (int i=0; i<graph.map.length; i++) {
				for (int j=0; j<graph.map[0].length; j++) {
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