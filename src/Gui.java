
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JPanel {

	int w = 688;
	int h = 768;// me e ndreq heigth width
	public Gui() {
		
	}

	public Gui(Frog f,AllObstacles o, ControllKeys k,GameDet g) {
		JLabel bg = new JLabel();
		JFrame frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setSize(w, 740);
		frame.setResizable(false);

		frame.addKeyListener(k);		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		setLayout(null);	
		bg.setIcon(new ImageIcon("Images\\Bg\\bgnoline.png"));
		bg.setBounds(0,0,w,h);
		//add(f.fLifes());
		add(f.gif);
		//add(f);
		//add(t);
		add(g.timer());
		add(g.lifes());
		for(int i =0;i<o.car().size();i++) {

			for(int j=0;j<o.car().get(i).length;j++) {

				this.add(o.car().get(i)[j]);
			}
		}
		for(int i =0;i<5;i++) {

			this.add(g.frogs()[i]);			
		}

		for(int i =0;i<o.turTree().size();i++) {

			for(int j=0;j<o.turTree().get(i).length;j++) {

				this.add(o.turTree().get(i)[j]);
			}
		}
		add(bg);
		
	}
	public void paintComponent(Graphics g) {
		repaint();
	}

}
