import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class ControllKeys extends KeyAdapter {

		
	private Frog f;
	public ControllKeys(Frog f) {
		this.f=f;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
			f.moveLeft();
			
//			f.gif.seticon(dkasljd);
//			f.pressed(true)
			//ndryshim fotos,delay			
		}

		if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {
			f.moveRight();
			//ndryshim fotos,delay			
		}

		if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W) {
			f.jump();
			
			
			//ndryshim fotos,delay			
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S) {
			f.back();
			//ndryshim fotos,delay			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			f.setImage(new ImageIcon("images\\\\Frog\\\\frog1U.png"));
			//ndryshim fotos,delay			
		}		
		//Ndoshta shtojme butona te tjere per abbilities p.sh ndryshimi i drejtimit te obstacle
	}
	
	public void keyPressed(KeyEvent e) {}
}
