

import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Timer t = new Timer();
		Frog f = new Frog(300,601,48,new ImageIcon("images\\Frog\\frog1U.png"));
		GameDet g = new GameDet();

		AllObstacles a=new AllObstacles();
		ControllKeys c = new ControllKeys(f);
		Gui gui =new Gui(f,a,c,g);
		GameController game = new GameController(a, f,g,gui);
		game.run();
	}
}
