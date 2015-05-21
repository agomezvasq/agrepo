import java.awt.*;
import javax.swing.*;

public class Latem extends JLabel {
	
	public int pA;
	public int pB;

	public Latem(Atom atom, int pA, int pB) {
		this.setPreferredSize(32,32);
		this.setBackground(Color.WHITE);
		this.setBorder( BorderFactory.createLineBorder(Color.BLACK, 3) );

		this.pA=pA;
		this.pB=pB;

		this.setFont( new Font("Segoe UI", Font.BOLD, 24) );
		this.setText( atom.flavor );
		this.setToolTipText( "{"pa+","+pB+"}" );
	}

	public void color() {
		this.setBackground(Color.CYAN);
	}

	public
}