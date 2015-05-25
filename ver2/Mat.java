import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.Exception;

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

		fT.setSelected(true);

		sT.setEnabled(false);
		fT.setEnabled(false);

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
	}

	//
	public void init() {
		try {
			//complicated parsing. Don't breath this!
			byte [] m=Files.readAllBytes( Paths.get(mS) );

			int c=0;
			for (int i=0; i<m.length; i++)
				if ( m[i]==10 )
					c++;

			int [][] matrix=new int[ m.length ][ c ];

			int j=0, k=0;
			while ( j<m.length ) {
				if ( m[j]==10 ) {
					k++; 
					j=0; continue;
				}
				matrix[j][k]=(int) m[j*k]-48;
				j++;
			}

			MapGraph graph=new MapGraph(matrix);

			MapDraw dr=new MapDraw(graph);

		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}


	}

	public void actionPerformed(ActionEvent e) {
		if ( e.getActionCommand().equals("matrix") ) {
			if ( jF.showOpenDialog(this)==JFileChooser.APPROVE_OPTION ) {
				this.mS=jF.getSelectedFile().getPath();

				sT.setEnabled(true);
				fT.setEnabled(true);

				init();

				cPane.remove(br);
				this.pack();
			}
		}
	}

	//
	public static void main(String [] args) {
		Mat mat=new Mat();
		mat.setLocationRelativeTo(null);
		mat.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mat.setResizable(false);
		mat.setVisible(true);
	}
}