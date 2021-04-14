import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FrogGoal {
	//mujm me shti edhe te allobstacles

	JLabel [] g = new JLabel[5];
	public FrogGoal(){
		for(int i=0;i<5;i++) {
			g[i]= new JLabel();
			g[i].setIcon(new ImageIcon("Images\\frog\\frog1D.png"));
			g[i].setBounds(24+(144*i), 25, 48, 48);
			g[i].setVisible(false);
		}
	}
	
	public JLabel[] forgs() {
		return g;
	}
	
	public void resetGoal() {
		for(int i=0;i<g.length;i++) {
			g[i].setVisible(false);
		}
	}
	
}