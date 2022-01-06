import javax.swing.JOptionPane;

public class GameController {	

	private Logic logic = new Logic();
	private AllObstacles o;
	private Frog f;
	private GameDet g;
	private Gui gui;
	int	count;
	int timer;
	int goal;
	//int gif;
	
	public GameController(AllObstacles obs,Frog frog,GameDet gd,Gui gui){
		this.gui=gui;
		o=obs;
		f=frog;
		g=gd;
	}
	public void dead() {
		f.destroy();
		g.decreaseLife();
		g.resetTimer();
	}

	public void run() {
		while(true) {
			if(timer%31==0) {
				g.decreaseTime();
				}
			timer++;
			

			logic.ofScreen(f);
			
			logic.movingObjects(o.car(), 0, false);
			logic.movingObjects(o.car(), 1, true);
			
			logic.movingObjects(o.turTree(),0, false);
			logic.movingObjects(o.turTree(),1, true);
			
			if(logic.goal(f,g.frogs())[0]) {				
				goal++;
			}else if(logic.goal(f,g.frogs())[1]) {
				dead();
			}
			
		
			for(int i=0;i<o.car().size();i++) {
				for(int j=0;j<o.car().get(i).length;j++) {
					if(logic.collisionWithCars(f,o.car().get(i)[j])) {
						dead();
					}
				}
			}

			count=0;
			if(f.getY()<313&&f.getY()>72) {
				for(int i=0;i<o.turTree().size();i++) {
					for(int j=0;j<o.turTree().get(i).length;j++) {
						if(logic.moveWithFloats(f,o.turTree().get(i)[j])) {
							count=1;
						}
					}
				}
				
				if(count<1) {
					dead();
				}
			}
	
			
			if(g.timer().getWidth()==0) {
				dead();
				}
			
			if(g.lifes().getX()>650) {
				JOptionPane.showMessageDialog(gui,"Ju humbet :)");
				g.restart();
			}
			
			if(goal>4) {
				JOptionPane.showMessageDialog(gui, "You Win!");
				goal=0;
				g.restart();
			}
			
			
			try {
				Thread.sleep(32);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}




