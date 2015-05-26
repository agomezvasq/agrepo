import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

import java.lang.Exception;
import java.io.IOException;

class Mat extends JFrame implements ActionListener {

	private JPanel cPane;
	private JPanel tPane;
	private ButtonGroup group;

	private JToggleButton sT;
	private JToggleButton fT;
	private JButton br;

	private JFileChooser jF;

	private Font sUI;

	private String mS;

	public Mat() {
		br=new JButton("matrix");
		sT=new JToggleButton("slow");
		fT=new JToggleButton("fast");

		jF=new JFileChooser();

		sUI=new Font( "Segoe UI Light", Font.PLAIN, 16 );

		mS="";

		br.setFont(sUI);
		sT.setFont(sUI);
		fT.setFont(sUI);

		br.setPreferredSize( new Dimension(-1, 40) );

		tPane=new JPanel( new GridLayout(1,2) );

		group=new ButtonGroup();

		sT.setSelected(true);

		sT.setEnabled(false);
		fT.setEnabled(false);

		sT.setBorderPainted(false);
		sT.setFocusPainted(false);
		//sT.setContentAreaFilled(false);

		fT.setBorderPainted(false);
		fT.setFocusPainted(false);
		//fT.setContentAreaFilled(false);

		tPane.add(sT);
		tPane.add(fT);

		group.add(sT);
		group.add(fT);

		//br.setBorderPainted(false);
		br.setFocusPainted(false);
		br.setContentAreaFilled(false);

		cPane= new JPanel();
		//cPane.setLayout( new BoxLayout( cPane, BoxLayout.PAGE_AXIS ) );
		cPane.setLayout( new BorderLayout() );

		cPane.add(br, 	 BorderLayout.PAGE_START);
		cPane.add(tPane, BorderLayout.PAGE_END  );

		sT.addActionListener(this);
		fT.addActionListener(this);
		br.addActionListener(this);

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
			//complicated parsing. Don't breath this!
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
				
/*
			byte [] m=Files.readAllBytes( Paths.get(mS) );

			int i=1;
			while (m[i-1]!=10)
				i++;

			int [][] matrix=new int[ m.length/(i-1)-1 ][ i-1 ];

			int j=0, k=0;
			for (byte b : m) {
				System.out.print(b+" ");
				if (b!=10) {
					matrix[k][j]=m[k*i+j]-48;
					j++;
				} else {
					k++; j=0;
					System.out.println();
				}
			}
*/

			MapGraph graph=new MapGraph(matrix);
			MapDraw dr=new MapDraw(graph);
			graph.setAlpha(dr);
			graph.ai();

		} catch (Exception e) {
			System.out.println( "E|M:"+e.getMessage() );
		}


	}

	public void slow() {

	}

	public void fast() {
		
	}

	public void actionPerformed(ActionEvent e) {
		if ( e.getActionCommand().equals("matrix") ) {
			if ( jF.showOpenDialog(this)==JFileChooser.APPROVE_OPTION ) {
				this.mS=jF.getSelectedFile().getPath();

				sT.setEnabled(true);
				fT.setEnabled(true);

				init();
			}
		}
	}

	public void stateChanged(ChangeEvent e) {
		JToggleButton b=(JToggleButton)e.getSource();
		if ( b.isSelected() ) {
			if ( b.getText().equals("slow") )
				slow();
			if ( b.getText().equals("fast") )
				fast();
		}
	}

	//
	public static void main(String [] args) {
		Mat mat=new Mat();
	}
}