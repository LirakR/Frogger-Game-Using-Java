import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameDet {
	
	private JLabel timer = new JLabel();
	private JLabel [] goal = new JLabel[5];
	private JLabel lifes = new JLabel();
	private JLabel score = new JLabel("Score");
	
	
public GameDet() {
	
	for(int i=0;i<5;i++) {
		goal[i]= new JLabel();
		goal[i].setIcon(new ImageIcon("Images\\frog\\frog1D.png"));
		goal[i].setBounds(24+(144*i), 25, 48, 48);
		goal[i].setVisible(false);
	}
//******************************************************************************************************************
	timer.setIcon(new ImageIcon("Images\\bg\\bgwithline.png"));
	timer.setBounds(250,670,240,20);
//******************************************************************************************************************
	lifes.setIcon(new ImageIcon("images\\frog\\froglifes.png"));
	lifes.setBounds(570, 670, 150, 20);
}

public void decreaseTime() {
	timer.setBounds((int)timer.getLocation().getX()+4, 670, timer.getWidth()-4, 20);
}
public void resetTimer() {
	timer.setBounds(250,670,240,20);
}
public JLabel timer() {
	return timer;
}
//******************************************************************************************************************
public void restart() {
	for(int i=0;i<goal.length;i++) {
		goal[i].setVisible(false);
	}
	timer.setBounds(250,670,240,20);
	lifes.setBounds(570, 670, 150, 20);
}

public JLabel[] frogs() {
	return goal;
}

//******************************************************************************************************************
public void decreaseLife() {
	System.out.println(2);
	lifes.setBounds((int)lifes.getLocation().getX()+32, 670, 150, 20);
}
public JLabel lifes() {

	return lifes;
}
//******************************************************************************************************************
public void score() {
	
}
}
