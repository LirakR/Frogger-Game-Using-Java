import javax.swing.JOptionPane;

public class GameController {
	
	
	

	private Logic logic = new Logic();
	private AllObstacles o;
	private Frog f;
	private FrogGoal fg;
	int	count;
	int timer;
	int goal;
	int gif;
	

	public GameController(AllObstacles obs,Frog frog,FrogGoal fg){
		o=obs;
		f=frog;
		this.fg=fg;
	}

	public void run() {
		while(true) {
			if(timer%31==0) {
				f.t.decrease();
			}
			timer++;
//			if(adasds) {
//				gif=0;
//			}
//			if(gif==10) {
//				
//			}
			//gif++;
			logic.ofScreen(f);
			
			logic.movingObjects(o.car(), 0, false);
			logic.movingObjects(o.car(), 1, true);
			
			logic.movingObjects(o.turTree(),0, false);
			logic.movingObjects(o.turTree(),1, true);
			
			if(logic.goal(f,fg.forgs())) {				
				goal++;
			}			
			
		
			for(int i=0;i<o.car().size();i++) {
				for(int j=0;j<o.car().get(i).length;j++) {
					logic.collisionWithCars(f,o.car().get(i)[j]);
				}
			}

			count=0;
			if(f.getY()<313&&f.getY()>72) {
				for(int i=0;i<o.turTree().size();i++) {
					for(int j=0;j<o.turTree().get(i).length;j++) {
						if(logic.moveWithFloats(f,o.turTree().get(i)[j])) {
							count=1;
						}
						else count=2;
					}
				}
				
				if(count==2) {
					f.destroy();
				}
			}
	
			
			if(f.t.getWidth()==0) {
				f.destroy();
				}
			
			if(f.life<1) {
				JOptionPane.showMessageDialog(null,"Ju humbet :)");
				f.reset();
				fg.resetGoal();
			}
			
			if(goal>4) {
				JOptionPane.showMessageDialog(null, "You Win!");
				
				f.reset();
				goal=0;
				fg.resetGoal();
			}
			
			
			try {
				Thread.sleep(32);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}




