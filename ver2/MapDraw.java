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

		GridLayout grdL=new GridLayout(gW,gH);

		this.lPane=new JPanel( grdL );
		lPane.setMinimumSize( new Dimension( gW*32, gH*32 ) );
		init();
	
		add(lPane);

		this.setContentPane(lPane);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}

	public void init() {
		try {
			for (int i=0; i<graph.map.length; i++) {
				for (int j=0; j<graph.map[0].length; j++) {
					Latem latem=new Latem( graph.map[i][j], i, j );
					
					lPane.add(latem);
				}
			}
		} catch (Exception e) {
			System.out.println( "E|MG:"+e.getMessage() );
		}
	}

	//
	public static void main(String [] args) {
		//
	}
}