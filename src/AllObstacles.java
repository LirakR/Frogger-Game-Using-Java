import java.util.ArrayList;
import java.util.Random;

public class AllObstacles{
		
	private ArrayList<Obstacle[]> car = new ArrayList<Obstacle[]>();
	private ArrayList<Obstacle[]> turTree = new ArrayList<Obstacle[]>();
	private String[] carsPic= {"Images\\Cars\\kcarL.png","Images\\Cars\\gcarR.png","Images\\Cars\\zcarL.png","Images\\Cars\\ycarR.png","Images\\Cars\\bcarL.png"};
	private String[] turTreePic= {"Images\\Wood\\mwood.png","Images\\Turtle\\2turtlesl.png","Images\\Wood\\lwood.png","Images\\\\Wood\\\\swood.png","Images\\Turtle\\3turtlesr.png"};
	private Random r = new Random();
	private int[]carsNum={2,3,2,2,3};
	private int[]turTreeNum= {2,2,2,2,2};
	
	
	public AllObstacles() {
		carsDistance(150);
		turTreeDistance(150);
	}

	public void carsDistance(int distanca) {
		
		for(int i=0;i<5;i++) {

			car.add(new Obstacle[carsNum[i]]);
		}

		for(int i=0;i<car.size();i++) {

			car.get(i)[0]=new Obstacle(r.nextInt(672),361+(i*48),48,carsPic[i]);
		}

		for(int i=0;i<car.size();i++) {

			for(int j=1;j<car.get(i).length;j++) {

				car.get(i)[j]= new Obstacle(car.get(i)[0].getX()+distanca*j*2,car.get(i)[0].getY(),48,carsPic[i]);
			}
		}		
	}
	
	public void turTreeDistance(int distanca) {

		for(int i=0;i<5;i++) {

			turTree.add(new Obstacle[turTreeNum[i]]);			
		}

		for(int i=0;i<turTree.size();i++) {

			turTree.get(i)[0]=new Obstacle(r.nextInt(672),73+(i*48),48,turTreePic[i]);
		}

		for(int i=0;i<turTree.size();i++) {

			for(int j=1;j<turTree.get(i).length;j++) {

				turTree.get(i)[j]= new Obstacle(turTree.get(i)[0].getX()+distanca*j*2,turTree.get(i)[0].getY(),48,turTreePic[i]);
			}
		}

		
	}
	
	public ArrayList<Obstacle[]> car(){
		return car;
	}
	
	public ArrayList<Obstacle[]> turTree(){
		
		return turTree;
	}
}

