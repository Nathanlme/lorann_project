package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


/**
 * 
 *<h1>The Class Sprite.</h1>
 *
 * @see Graphics
 * @see Image
 * @see Rectangle
 * 
 * @see ImageIcon
 */
public class Sprite {

	/** The x */
    protected int x;
    /** The y */
    protected int y;
    /** The width */
    protected int width;
    /** The height */
    protected int height;
    /** The visible */
    protected boolean visible; 
    /** The image */
    protected Image image;
    
    /**
     * Position of the sprite
     * @param x
     * 		the x
     * 		
     * @param y
     * 		the y
     * 
     * @param imagename
     * 		the image name
     * 		
     */

    public Sprite(int x, int y, String imagename) {
    	loadImage(imagename);
        this.x = x;
        this.y = y;
        visible = true;
    }

    
    /**
     * loadImage for sprite.
     * @param imageName
     * 		the imageName
     * 				
     */
    
    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }
    
    
    /**
     *  Draw g
     * @param g
     * 		the g
     */
    public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, 32, 32, null);
        
    }
    
    /**
     * Dimension of image
     */
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    
    /**
     * getImage
     * @return image
     */
    public Image getImage() {
        return image;
    }

    
    /**
     * getX
     * @return x
     */
    public int getX() {
        return x;
    }

    
    /**
     * getY
     * @return y
     */
    public int getY() {
        return y;
    }

    
    /**
     * Method : Visible
     * @return visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * setVisible
     * @param visible
     * 		the visible
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
    /**
     * getBounds
     * @return Rectangle
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
    /**
     * finalize (Help Method)
     */
   public void finalize() throws Throwable{
	   System.out.println("ca se détruit");
   }
}