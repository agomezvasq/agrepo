package kmatrix;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

import java.lang.Exception;

class Mat extends JFrame implements ActionListener {

	private JPanel cPane;

	private JButton br;
	private JButton at;

	private JFileChooser jF;

	private Font sUI;

	private String mS;

	public Mat() {
		Image im=null;
		try {
			im=ImageIO.read( getClass().getResource("icon.png") );
		} catch (Exception e) {
			System.out.println( "E:"+e.getMessage() );
		}
		this.setIconImage(im);

		br=new JButton("matrix");
		at=new JButton("about");

		jF=new JFileChooser();

		sUI=new Font( "Segoe UI Light", Font.PLAIN, 16 );

		mS="";

		br.setFont(sUI);
		at.setFont(sUI);

		br.setPreferredSize( new Dimension(120, 37) );
		at.setPreferredSize( new Dimension(120, 37) );

		br.setFocusPainted(false);
		br.setContentAreaFilled(false);

		at.setFocusPainted(false);
		at.setContentAreaFilled(false);

		cPane= new JPanel();
		//cPane.setLayout( new BoxLayout( cPane, BoxLayout.PAGE_AXIS ) );
		cPane.setLayout( new BorderLayout() );

		cPane.add(br, BorderLayout.PAGE_START);
		cPane.add(at, BorderLayout.PAGE_END	);

		br.addActionListener(this);
		at.addActionListener(this);

		this.add(cPane);
		this.pack();

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	//
	public void init() {
		try {
			List<String> m=Files.readAllLines( Paths.get(mS),
										    Charset.defaultCharset() );

			int [][] matrix=new int[ m.size() ][ m.get(0).length() ];
			for (int i=0; i<m.size(); i++) {
				for (int j=0; j<m.get(0).length(); j++) {
					System.out.print( m.get(i).charAt(j)+" " );
					matrix[i][j]=Integer.parseInt( m.get(i).charAt(j)+"" );
				}
				System.out.println();
			}
				
			MapGraph graph=new MapGraph(matrix);
			MapDraw dr=new MapDraw(graph);
			graph.setAlpha(dr);
			graph.ai();

		} catch (Exception e) {
			System.out.println( "E|M:"+e.getMessage() );
		}
	}

	public void actionPerformed(ActionEvent e) {
		if ( e.getActionCommand().equals("matrix") ) {
			if ( jF.showOpenDialog(this)==JFileChooser.APPROVE_OPTION ) {
				this.mS=jF.getSelectedFile().getPath();

				init();
			}
		}
		if ( e.getActionCommand().equals("about") ) {
			About at=new About();
		}
	}

	//
	public static void main(String [] args) {
		Mat mat=new Mat();
	}
}