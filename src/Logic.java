import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public class Logic {
	private int speed = new Random().nextInt(2)+2;

	public Logic() {
		
	}
	
	public boolean moveWithFloats(Frog f, Obstacle o) {
		boolean rez=false;
		if(f.getY()==o.getY()) {

			if(f.getX()+f.getWidth()/2>o.getX()&&f.getX()+f.getWidth()/2<o.getX()+o.getWidth()) {

				f.setX(f.getX()+o.speed());
				f.gif.setBounds((int)f.gif.getLocation().getX()+o.speed(), f.gif.getY(),f.gif.getWidth(),f.gif.getHeight());
				rez=true;
			}
		}
		return rez;
	}
	
	
	public void collisionWithCars(Frog f,Obstacle o) {

		if(f.getY()==o.getY()) {

			if(f.getX()+f.getWidth()>o.getX()&&f.getX()<o.getX()+o.getWidth()) {

				f.destroy();

			}			
		}
	}

	public void ofScreen(Frog f) {

		if(f.getX()+48>672) {

			
			if(f.getY()<649&&f.getY()>600) {
				f.setX(628);
			f.gif.setBounds(f.getX()-48, (int)f.gif.getLocation().getY(), f.gif.getWidth(),f.gif.getHeight());
			}else {
				if(f.getX()+64>628) {
					f.destroy();
				}	
			}
			
		}else if(f.getX()<0) {
		
			if(f.getY()<649&&f.getY()>600) {
				f.setX(0);
				f.gif.setBounds(0, (int)f.gif.getLocation().getY(),f.gif.getWidth(),f.gif.getHeight());
				}else {
					if(f.getX()-50<0) {
						f.destroy();
					}	
	
				}
		
			
		}
	}

	public void movingObjects(ArrayList<Obstacle[]> a,int r,boolean lr) {

		for(int i =r;i<a.size();i+=2) {

			for(int j=0;j<a.get(i).length;j++) {

				a.get(i)[j].move(lr,speed +i);
				if(a.get(i)[j].getX()>672) {
					a.get(i)[j].setX(a.get(i)[j].getX()-672-a.get(i)[j].getWidth());			
				}
				else if (a.get(i)[j].getX()<0-a.get(i)[j].getWidth()) {
					a.get(i)[j].setX(a.get(i)[j].getX()+672+a.get(i)[j].getWidth());	
				}
			}
		}
	}
	public boolean goal(Frog f,JLabel[] g) {
		boolean rez=false;
		int place=-1;
		int count =0;
		for(int i=0;i<5*144;i+=144) {
			if(f.getY()<73&&f.getX()>=10+i&&f.getX()<56+i) {
				place=i/144;
				count =1;
			}
		}
		
		if(f.getY()<73&&count<1) {
			f.destroy();
		}

		if(place>=0) {
			if(!g[place].isVisible()) {
				g[place].setVisible(true);
				rez=true;
				f.setX(336);
				f.setY(601);
				f.gif.setBounds(f.getX(), f.getY(), 96, 96);
				f.t.restart();
			}else {
				f.setY(f.getY()+48);
				f.gif.setBounds(f.getX(), f.getY(), 96, 96);
			}
		}
		return rez;
	}
}
