package view;

import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


/**
 * <h1>The Class SpaceShip.</h1>
 * <p> this is lorann </p>
 * @see KeyEvent
 * @see Arraylist
 * @see List
 * @see ImageIcon
 *
 */

public class SpaceShip extends Sprite {

	/** The dx */
    public int dx;
    /** The dy */
    public int dy;
    /** The missiles */
	private List<Missile> missiles;

	
	/**
	 * Initiate SpaceShip 
	 * @param x
	 * 		the x
	 * @param y
	 * 		the y
	 */
    public SpaceShip(int x, int y) {
        super(x, y,"C:\\Users\\Cedric navet pc\\Desktop\\Mes Devoirs\\Projet java\\sprite\\fireball_3.png");
        int valeur=Help();
        loadImage(valeur);
        initSpaceShip();
    }

    /**
     * Method initiate SpaceShip with missiles
     */
    
    private void initSpaceShip() {
        missiles = new ArrayList<>();

    }
    
    
    /**
     * Method : create link between the value image and the position, load Image
     * @param valeur
     * 		the valeur
     */
    
    public void loadImage(int valeur) {

        if(valeur==1) {
            ImageIcon ii = new ImageIcon("C:\\Users\\Cedric navet pc\\Desktop\\Mes Devoirs\\Projet java\\sprite\\lorann_r.png");
            image = ii.getImage();
        }
        if(valeur==2) {
            ImageIcon ii = new ImageIcon("C:\\Users\\Cedric navet pc\\Desktop\\Mes Devoirs\\Projet java\\sprite\\lorann_l.png");
            image = ii.getImage();
        }
        if(valeur==3) {
            ImageIcon ii = new ImageIcon("C:\\Users\\Cedric navet pc\\Desktop\\Mes Devoirs\\Projet java\\sprite\\lorann_u.png");
            image = ii.getImage();
        }
        if(valeur==4) {
            ImageIcon ii = new ImageIcon("C:\\Users\\Cedric navet pc\\Desktop\\Mes Devoirs\\Projet java\\sprite\\lorann_b.png");
            image = ii.getImage();
        }
        if(valeur==5) {
            ImageIcon ii = new ImageIcon("C:\\Users\\Cedric navet pc\\Desktop\\Mes Devoirs\\Projet java\\sprite\\lorann_br.png");
            image = ii.getImage();
        }
    }

    /**
     * Method to move
     */
    
    public void move() {
        x += dx;
        y += dy;
    }
    
    /**
     * Method to reverse move
     * 
     */
    
    public void reversemove() {
        x -= dx;
        y -= dy;
    }

    /**
     * get Missiles
     * @return missiles
     */
    
    public List<Missile> getMissiles() {
        return missiles;
    }

    /**
     * Create a link between Controller and View
     * 
     * @return 1
     * @return 2
     * @return 3
     * @return 4
     * @return 5
     * @return 0
     */

    public int Help() {
        if(dx == 32) {
            return 1;
        }
        if(dx == -32) {
            return 2;
        }
        if(dy == -32) {
            return 3;
        }
        if(dy == 32) {
            return 4;
        }
        if(dx == 0 && dy == 0) {
            return 5;
        }
        return 0;
 }

    /**
     * Control of lorann
     * 
     * @param e
     * 		the e
     */
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -32;

        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 32;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -32;

        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 32;
        }
}
    
    /**
     * generate a position for missiles
     */
    public void fire() {
        missiles.add(new Missile(x, y,direction()));
    }

    
    /**
     * Create link between the direction of lorann and the missile
     * 
     * @return 1
     * @return 2
     * @return 3
     * @return 4
     * @return 6
     */
    
    public int direction() {
        if(dx<0) {
            return 1;
        }
        if(dx>0) {
            return 2;
        }
        if(dy<0) {
            return 3;
        }
        if(dy>0) {
            return 4;
        }
        return 6;
    }
    
    /**
     * The auto-direction
     * 
     * @param e
     * 		the e
     */
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
}