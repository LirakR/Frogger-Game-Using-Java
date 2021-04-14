//import java.awt.Color;
//import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Frog extends JLabel{


	private int x,y;
	private ImageIcon img;
	private int jumpSize=48;
	private int moveSize=48;
	int life=3;
	
	JLabel lifes = new JLabel();
	JLabel gif = new JLabel();
	ImageIcon gifL = new ImageIcon("images\\frog\\froggif2L.gif");
	ImageIcon gifR = new ImageIcon("images\\frog\\froggif2R.gif");
	ImageIcon gifD = new ImageIcon("images\\frog\\froggif2D.gif");
	ImageIcon gifU = new ImageIcon("images\\frog\\froggif2U.gif");
	Timer t;
	
	public Frog(int xpos,int ypos, int h,ImageIcon image,Timer ti) {
		t=ti;
		this.img =image;
		this.x=xpos;
		this.y=ypos;
		int imageWidth=resizeImg(img,h).getIconWidth();
		int imageHeight=resizeImg(img,h).getIconHeight();

		setIcon(resizeImg(img,h));
		setVisible(true);
		setBounds(xpos, ypos, imageWidth, imageHeight);

		lifes.setIcon(resizeImg(new ImageIcon("images\\frog\\froglifes.png"),17));
		lifes.setBounds(570, 670, 150, 20);
		gif.setIcon(gifU);
		gif.setBounds(xpos, ypos, 96, 96);
		//gif.setBorder(BorderFactory.createLineBorder(Color.black)); // Uncomment to see the border
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int xpos) {
		this.x =xpos;
	}

	public void setY(int ypos) {
		this.y =ypos;
	}
	public void setImage(ImageIcon image) {
		setIcon(resizeImg(image, 48));
	}
	public void moveLeft(){	 

		if(getX()>0) {
			this.setX(this.getX()-moveSize);
			setIcon(new ImageIcon("images\\frog\\frog1L.png"));
			gifL.getImage().flush();
			gif.setIcon(gifL);
			gif.setBounds(getX(),getY(),96,48);
	
		}
	}

	public void moveRight(){
		
		if(getX()<628) {
			this.setX(this.getX()+moveSize);
			setIcon(new ImageIcon("images\\frog\\frog1R.png"));
			gifR.getImage().flush();
			gif.setIcon(gifR);
			gif.setBounds(getX()-48,getY(),96,48);
		}
	}

	public void jump(){
			
			this.setY(this.getY()-jumpSize);
			setIcon(new ImageIcon("images\\frog\\frog1U.png"));
			gifU.getImage().flush();
			gif.setIcon(gifU);
			gif.setBounds(getX(),getY(),48,96);
	}

	public void back(){
		
		if(getY()<601){
			this.setY(this.getY()+jumpSize);
			setIcon(new ImageIcon("images\\frog\\frog1D.png"));
			gifD.getImage().flush();
			gif.setIcon(gifD);
			gif.setBounds(getX(),getY()-48,48,96);
		}
		
	}

	public JLabel fLifes() {

		return this.lifes;
	}
	public void reset() {
		life=3;
		lifes.setBounds(570, 670, 150, 20);
		setX(300);
		setY(601);
	}

	public void destroy() {

		this.setImage(new ImageIcon("Images\\Frog\\dead.png"));		
		lifes.setBounds((int)lifes.getLocation().getX()+32, 670, 150, 20);
		life--;
		
		gif.setVisible(false);
		this.setVisible(true);
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	
		//this.setVisible(false);
		this.setImage(new ImageIcon("Images\\Frog\\frog1U.png"));
		setY(601);
		setX(300);
		
		gif.setIcon(gifU);
		gifU.getImage().flush();
		gif.setVisible(true);
		gif.setBounds(getX(),getY(),96,96);
		t.restart();
	}

	private static ImageIcon resizeImg(ImageIcon image,int cHeight) {
		
		double k = image.getIconHeight()/cHeight;
		ImageIcon imageS = new ImageIcon(image.getImage().getScaledInstance((int)(image.getIconWidth()/k),cHeight, Image.SCALE_DEFAULT));
		return imageS;
	}
}