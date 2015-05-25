import java.awt.*;
import java.swing.*;

import java.lang.Exception;

abstract class Mat extends JFrame implements ActionListener {

	private JPanel cPane;
	private ButtonGroup tPane;

	private JToggleButon sT;
	private JToggleButon fT;
	private JButton br;

	private JFileChooser jF;

	private Font sUI;

	private String mS;

	public Mat() {
		br=new JButton("matrix");
		sT=new JToggleButon("slow");
		fT=new JToggleButon("fast");

		sUI=new Font( "Segoe UI Light", Font.PLAIN, 16 );

		mS="";

		br.setFont(sUI);
		sT.setFont(sUI);
		fT.setFont(sUI);

		br.setPreferredSize(200,150);

		tPane=new JPanel( new GridLayout(1,2) );

		fT.setSelected(true);

		sT.setEnabled(false);
		fT.setEnabled(false);

		tPane.add(sT);
		tPane.add(fT);

		cPane= new JPanel();
		cPane.setLayout( new BoxLayout( cPane, BoxLayout.PAGE_AXIS ) );

		cPane.add(tPane);

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
			byte [] m=Files.readAllBytes( Paths.getPath(mS) );

			int c=0;
			for (int i=0; i<m.length; i++)
				if ( m[i]==10 )
					c++;

			int [][] matrix=new int[ m.length ][ c ];

			int j=0, k=0;
			while ( m[j]!=null ) {
				if ( m[j]==10 ) {
					k++; 
					j=0; continue;
				}
				int [j][k]=(int) m[j*k]-48;
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
			if ( jT.showOpenDialog(this)==JFileChooser.APPROVE_OPTION ) {
				this.mS=JFileChooser.getSelectedFile().getPath();

				sT.setEnabled(true);
				fT.setEnabled(true);

				init();
			}
		}
	}

	//
	public static void main(String [] args) {
		//
	}
}