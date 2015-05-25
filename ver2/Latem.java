import java.awt.*;
import javax.swing.*;

public class Latem extends JLabel {
	
	public int pA;
	public int pB;

	public Latem(Atom atom, int pA, int pB) {
		this.setPreferredSize(32,32);
		this.setBackground(Color.WHITE);
		this.setBorder( BorderFactory.createLineBorder(Color.GRAY, 1) );

		this.pA=pA;
		this.pB=pB;

		this.setFont( new Font("Segoe UI", Font.BOLD, 24) );
		this.setToolTipText( "{"pa+","+pB+"}" );

		URL ico;
		switch ( atom.flavor ) {
			case MapGraph.DRONE: 
				ico = getClass().getResource("drone.png");  break;
			case MapGraph.OBSTL:
				ico = getClass().getResource("orb.png");    break;
			case MapGraph.SOLUT:
				ico = getClass().getResource("target.png"); break;
		}
		if (ico!=null)
			this.setImageIcon( new ImageIcon(ico).getImage() );		
	}

	public void color()   { this.setBackground(Color.CYAN);  }
	public void uncolor() { this.setBackground(Color.WHITE); }

}