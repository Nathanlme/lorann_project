package view;

/**
 * <h1>The Class Monster.</h1>
 * 
 * @author Maximilien Nathan Cedric Benjamin
 * @version 1.1
 */


public class Monster extends Sprite{

	/** The min */
    int min = 1;
    /** The max */
    int max = 12;
    /** The dx */
    int dx = 32;
    /** The dy */
    int dy = 32;
    /** The random */
    private int random;
    
    
    /**
     * Initiate Monster
     * 
     * @param x
     * 		the x
     * @param y
     * 		the y
     * @param imagename
     * 		the imagename
     */
    public Monster(int x, int y, String imagename) {
        super(x, y, imagename);



    }

    /**
     * IA Mouvement
     */
    public void Mouvement() {
        random =(int) (Math.random() * (max - min));
        if(random==0){
            x+=dx;
        }
        if(random==1) {
            x-=dx;
        }
        if(random==2) {
            y+=dy;
        }
        if(random==3) {
            y-=dy;
        }
        if(random==4) {
            y+=dy;
            x+=dx;
        }
        if(random==5) {
            y-=dy;
            x-=dx;
        }
        if(random==6) {
            y+=dy;
            x-=dx;
        }
        if(random==7) {
            y-=dy;
            x+=dx;
        }
    }
    
    /**
     * Collision monster
     */
    public void reversMouvement() {
        if(random==0){
            x-=dx;
        }
        if(random==1) {
            x+=dx;
        }
        if(random==2) {
            y-=dy;
        }
        if(random==3) {
            y+=dy;
        }
        if(random==4) {
            y-=dy;
            x-=dx;
        }
        if(random==5) {
            y+=dy;
            x+=dx;
        }
        if(random==6) {
            y-=dy;
            x+=dx;
        }
        if(random==7) {
            y+=dy;
            x-=dx;
        }
    }
}