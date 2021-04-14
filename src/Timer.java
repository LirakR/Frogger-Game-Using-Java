import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Timer extends JLabel {
	
	public Timer() {
		setIcon(new ImageIcon("Images\\bg\\bgwithline.png"));
		setBounds(250,670,240,20);				
	}

	public void decrease() {
		setBounds((int)getLocation().getX()+4, 670, getWidth()-4, 20);
	}
	public void restart() {
		setBounds(250,670,240,20);
	}

}
