import java.util.ArrayList;

import javax.swing.JPanel;

public class CPrototype  {
	//ArrayList<Obstacle[]> a = new ArrayList<Obstacle[]>(5);
	Obstacle[] row1;
	Obstacle[] row2;
	Obstacle[] row3;
	Obstacle[] row4;
	Obstacle[] row5;
	Frog f;
	String[] cars= {"Images\\Cars\\kcarL.png","Images\\Cars\\gcarL.png","Images\\Cars\\zcarR.png","Images\\Cars\\ycarL.png","Images\\Cars\\bcarL.png"};

	Logic logic = new Logic();

	public CPrototype(int[] carsNumber,Frog f) {

//		for(int i=0;i<a.size();i++) {
//
//		a.set(i, new Obstacle[carsNumber[i]]);
//
//		for(int j=0;j<5*(f.getHeight()+2);j+=f.getHeight()+2) {
//
//				a.get(i)[0]=new Obstacle((int)(Math.random()*1000)%600,188+j,35,cars[i]);
//				}
//			}
		row1= new Obstacle[carsNumber[0]];
		row2= new Obstacle[carsNumber[1]];
		row3= new Obstacle[carsNumber[2]];
		row4= new Obstacle[carsNumber[3]];
		row5= new Obstacle[carsNumber[4]];
		row1[0]=new Obstacle((int)(Math.random()*1000)%600,184,33,"Images\\Cars\\kcarL.png");
		row2[0]=new Obstacle((int)(Math.random()*1000)%600,219,33,"Images\\Cars\\gcarL.png");
		row3[0]=new Obstacle((int)(Math.random()*1000)%600,254,33,"Images\\Cars\\zcarR.png");
		row4[0]=new Obstacle((int)(Math.random()*1000)%600,291,33,"Images\\Cars\\ycarL.png");
		row5[0]=new Obstacle((int)(Math.random()*1000)%600,328,33,"Images\\Cars\\bcarL.png");
		this.f=f;
	}

	public Obstacle[] distanceInRows(int row,int distanca) {

		Obstacle[] rez;
//		for(int i =0;i<a.size();i++) {
//			rez=a.get(i);
//		}

		switch(row) {
		case 1:{ rez=row1;  break;}
		case 2:{ rez=row2;  break;}
		case 3:{ rez=row3;  break;}
		case 4:{ rez=row4;  break;}
		case 5:{ rez=row5;	break;}
		default:{ rez=null; break;}
		}

		for(int i=1;i<rez.length;i++) {
			rez[i]=new Obstacle(rez[0].getX()+distanca*i,rez[0].getY(),33,cars[row-1]);
		}


		return  rez;
	}

	public void allRows(JPanel p) {

		Obstacle[] c1= this.distanceInRows(1,150);
		Obstacle[] c2= this.distanceInRows(2,150);
		Obstacle[] c3= this.distanceInRows(3,200);
		Obstacle[] c4= this.distanceInRows(4,250);
		Obstacle[] c5= this.distanceInRows(5,200);

		for (int i=0; i<c1.length;i++) {
			p.add(c1[i]);
//			if(c1[i].getX()>600) {
//				c1[i].setX(c1[i].getX()-600);			
//			}

		}
		for (int i=0; i<c2.length;i++) {
			p.add(c2[i]);
//			if(c2[i].getX()>600) {
//				c2[i].setX(c2[i].getX()-600);		
//			}

		}
		for (int i=0; i<c3.length;i++) {
			p.add(c3[i]);
//			if(c3[i].getX()>600) {
//				c3[i].setX(c3[i].getX()-600);		
//			}

		}
		for (int i=0; i<c4.length;i++) {
			p.add(c4[i]);
//			if(c4[i].getX()>600) {
//				c4[i].setX(c4[i].getX()-600);		
//			}

		}
		for (int i=0; i<c5.length;i++) {
			p.add(c5[i]);
//			if(c5[i].getX()>600) {
//				c5[i].setX(c5[i].getX()-600);		
//			}

		}

		while(true) {

			for(int i=0;i<c1.length;i++) {
				c1[i].move(false,1);
				if(c1[i].getX()>600) {
					c1[i].setX(c1[i].getX()-600-c1[i].getWidth());			
				}
				else if (c1[i].getX()<0-c1[i].getWidth()) {
					c1[i].setX(c1[i].getX()+600+c1[i].getWidth());	
				}
			}

			for(int i=0;i<c2.length;i++) {
				c2[i].move(false,2);
				if(c2[i].getX()>600) {
					c2[i].setX(c2[i].getX()-600-c2[i].getWidth());			
				}
				else if (c2[i].getX()<0-c2[i].getWidth()) {
					c2[i].setX(c2[i].getX()+600+c2[i].getWidth());	
				}
			}
			for(int i=0;i<c3.length;i++) {
				c3[i].move(true,3);
				if(c3[i].getX()>600) {
					c3[i].setX(c3[i].getX()-600-c3[i].getWidth());			
				}
				else if (c3[i].getX()<0-c3[i].getWidth()) {
					c3[i].setX(c3[i].getX()+600+c3[i].getWidth());	
				}
			}
			for(int i=0;i<c4.length;i++) {
				c4[i].move(false,4);
				if(c4[i].getX()>600) {
					c4[i].setX(c4[i].getX()-600-c4[i].getWidth());			
				}
				else if (c4[i].getX()<0-c4[i].getWidth()) {
					c4[i].setX(c4[i].getX()+600+c4[i].getWidth());	
				}
			}
			for(int i=0;i<c5.length;i++) {
				c5[i].move(false,3);
				if(c5[i].getX()>600) {
					c5[i].setX(c5[i].getX()-600-c5[i].getWidth());			
				}
				else if (c5[i].getX()<0-c5[i].getWidth()) {
					c5[i].setX(c5[i].getX()+600+c5[i].getWidth());	
				}
			}

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i =0; i<c1.length;i++) {
				logic.collisionWithCars(f,c1[i]);
			}
			for(int i =0; i<c2.length;i++) {
				logic.collisionWithCars(f,c2[i]);
			}
			for(int i =0; i<c3.length;i++) {
				logic.collisionWithCars(f,c3[i]);
			}
			for(int i =0; i<c4.length;i++) {
				logic.collisionWithCars(f,c4[i]);
			}
			for(int i =0; i<c5.length;i++) {
				logic.collisionWithCars(f,c5[i]);
			}		
		}


	}
}



