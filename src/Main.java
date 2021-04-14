

import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t = new Timer();
		Frog f = new Frog(300,601,48,new ImageIcon("images\\Frog\\frog1U.png"),t);
		FrogGoal fg = new FrogGoal();

		AllObstacles a=new AllObstacles();
		ControllKeys c = new ControllKeys(f);
		new Gui(f,a,c,t,fg);
		GameController game = new GameController(a, f,fg);
		game.run();
	}
}
