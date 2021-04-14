import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Obstacle extends JLabel implements obstacleInterface {
	private int x,y,h;
	private ImageIcon img;
	private String p;
	private int s;
	public Obstacle(int xPos,int yPos, int height,String path) {
		
		this.x=xPos;
		this.y=yPos;
		this.h=height;
		this.p=path;
	    this.img=new ImageIcon(p);
	
	    img = this.resizeImage(img, height);
		
		int w = img.getIconWidth();
		int h = img.getIconHeight();
		setIcon(img);
		setBounds(x, y, w, h);
	}
	
	@Override
	public void setX(int xPos) {
		// TODO Auto-generated method stub
		this.x=xPos;		
	}

	@Override
	public void setY(int yPos) {
		// TODO Auto-generated method stub
		this.y=yPos;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}
	
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}
	
	@Override
	public void setImage(ImageIcon image) {
		// TODO Auto-generated method stub
		this.img=this.resizeImage(image, h);		
	}
	
//	public void flipImage() {
//		if(this.p.substring(p.length()-1)=="0") {
//			
//			this.setImage(new ImageIcon(p.replace("0","")));
//		
//		}else {
//		
//			this.setImage(new ImageIcon(p+0));
//		}
//	}
	
	public ImageIcon resizeImage(ImageIcon image, int cHeight) {
		double k = image.getIconHeight()/cHeight;

		ImageIcon imageS = new ImageIcon(image.getImage().getScaledInstance((int)(image.getIconWidth()/k),cHeight, Image.SCALE_DEFAULT));

		return imageS;
	}

	@Override
	public void move(boolean Direction, int speed) {
		// TODO Auto-generated method stub
		//this.s=speed;
		if(Direction) {
			this.s=speed;
			this.setX(this.getX()+speed);
		}else {
			this.s=-speed;
			this.setX(this.getX()-speed);
		}
	}
	public int speed() {
		return s;
	}
}
