package kmatrix;

import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.net.URL;

class About extends JFrame {
	
	private JPanel cPane;
	private JLabel icon;
	private JLabel ln;
	private JLabel ly;
	private JLabel la;

	public About() {
		Image im=null;
		try {
			im=ImageIO.read( getClass().getResource("icon.png") );
		} catch (Exception e) {
			System.out.println( "E:"+e.getMessage() );
		}
		this.setIconImage(im);

		icon=new JLabel();
		URL ico = getClass().getResource("icon.png");
		if (ico!=null)
			icon.setIcon( new ImageIcon(ico) );

		ln=new JLabel("kmatrix");
		ly=new JLabel("2015. Estructuras de Datos I. Universidad EAFIT 2015-1.");
		la=new JLabel("Andrés Gómez  |  Sebastián Gómez  |  Edwin Bedoya");

		ln.setFont( new Font("Segoe UI Light", Font.PLAIN, 16) );
		ly.setFont( new Font("Segoe UI Light", Font.PLAIN, 8)  );
		la.setFont( new Font("Segoe UI Light", Font.PLAIN, 11) );

		ln.setForeground(Color.WHITE);
		ly.setForeground(Color.LIGHT_GRAY);
		la.setForeground(Color.LIGHT_GRAY);

		cPane=new JPanel();
		cPane.setLayout( new BoxLayout( cPane, BoxLayout.PAGE_AXIS ) );
		cPane.setBackground(Color.DARK_GRAY);

		this.setResizable(false);
		cPane.setPreferredSize( new Dimension(400,247) );

		icon.setAlignmentX(Component.CENTER_ALIGNMENT);
		ln.setAlignmentX(Component.CENTER_ALIGNMENT);
		ly.setAlignmentX(Component.CENTER_ALIGNMENT);
		la.setAlignmentX(Component.CENTER_ALIGNMENT);

		cPane.add( Box.createVerticalGlue() );
		cPane.add(icon);
		cPane.add(ln);
		cPane.add(ly);
		cPane.add(la);
		cPane.add( Box.createVerticalGlue() );

		this.add(cPane);
		this.setContentPane(cPane);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

}