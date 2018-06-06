package view;

import view.Sprite;

/**
 * <h1>The Class Missile.</h1>
 * 
 * @author Nathan Maximilien Cedric Benjamin
 * @version 1.1
 * @see Sprite
 *
 */

public class Missile extends Sprite {


	/** The MISSILE_SPEED represents the speed of missile*/
    private final int MISSILE_SPEED = 32;
    /** The "tirer" represents a boolean system, when you click in the space bar "tirer" become true*/
    private Boolean tirer=false;
    /** The directions represent the direction of lorann*/
    private String directions;

    
    /** initiate new missile.
     * @param x
     * 		the x
     * @param y 
     * 		the y	
     * @param direction
     * 		the direction		
     */
	    public Missile(int x, int y, int direction) {
	        super(x, y,"sprite/erasor.gif");
	        initMissile();
	    }

	    
	    /**
	     * Load the sprite "erasor.gif".
	     */
	    
	    private void initMissile() {

	        loadImage("sprite/erasor.gif");
	        getImageDimensions();
	    }

	    
	    /**
	     * Choose the direction of "erasor.gif"
	     * 
	     * @param direction
	     * 			the direction
	     */
	    
	    public void move(int direction) {
	        if(tirer==true) {
	            if(directions == "droite") {
	                x += MISSILE_SPEED;
	            }
	            if(directions == "gauche") {
	                x -= MISSILE_SPEED;
	            }
	            if(directions == "bas") {
	                y += MISSILE_SPEED;
	            }
	            if(directions == "haut") {
	                y -= MISSILE_SPEED;
	            }

	        }else {
	            if(direction==1) { 
	                   tirer = true;
	                   directions="droite";
	                x += MISSILE_SPEED;
	               }
	               if(direction==2) {
	                   tirer = true;
	                   directions="gauche";
	                x-= MISSILE_SPEED;
	               }
	               if(direction==3) {
	                   tirer = true;
	                   directions="bas";
	                y+=MISSILE_SPEED;
	               }
	               if(direction==4) {
	                   tirer = true;
	                   directions="haut";
	                y-=MISSILE_SPEED;
	               }

	        }

	    }
	}
