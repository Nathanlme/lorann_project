package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * <h1>The Class Board .</h1>
 *
 * @author Cedric Nathan Maximilien Benjamin
 * @version 1.0
 * 
 * @see Color
 * @see Graphics
 * @see Graphics2D
 * @see Rectangle
 * @see Toolkit
 * @see ActionEvent
 * @see ActionListener
 * @see KeyAdapter
 * @see KeyEvent
 * @see File
 * @see IOException
 * @see ArrayList
 * @see List
 * 
 * @see AudioSystem
 * @see Clip
 * @see JPanel
 * @see Timer
 */

public class Board extends JPanel implements ActionListener {

	/** Serial ID */
    private static final long serialVersionUID = -8246000947640347114L;
    /** link between this class and Lorann */
    private final int DELAY = 150;
    /** The timer */
    private Timer timer;
    /** The spaceShip (lorann) */
    private SpaceShip spaceShip;
    /** The item */
    private List<Sprite> item =new ArrayList<Sprite>();
    /** The monster */
    private List<Monster> monster= new ArrayList<Monster>();
    /** The sprite */
    private List<Sprite> sprite = new ArrayList<Sprite>();
    /** The gameover */
    private gamestate gameover;
    /** The gamewin */
    private gamestate gamewin;
    /** The isgameover */
    private Boolean isgameover=false;
    /** The iswin */
    private Boolean iswin=false;
    /** The iscrystaltake */
    private Boolean iscrystaltake=false;
    /** The x, y and Score */
    private int x=0,y=0,Score=0;
    
    /**
     * getScore
     * 
     * @return Score
     */
    
    public int getScore() {
		return Score;
	}

    
    /**
     * setScore
     * 
     * @param score
     * 		the score
     */
	public void setScore(int score) {
		Score = score;
	}
	
	/** The door_open */
	private Sprite door_open;
	/** The door_close */
    private Sprite door_close;
    /** The crystal */
    private Sprite crystal; 
    /** The url_bone */
    private String url_bone = "sprite/bone.png";
    /** The url_crystal*/
    private String url_crystal = "sprite/crystal_ball.png";
    /** The url_gate */
    private String url_gate = "sprite/gate_closed.png";
    /** The url_h_bone */
    private String url_h_bone = "sprite/horizontal_bone.png";
    /** The url_v_bone */
    private String url_v_bone = "sprite/vertical_bone.png";
    /** The url_monstre */
    private String url_monstre = "sprite/monster_1.png";
    /** The url_gold */
    private String url_gold = "sprite/purse.png";
    /** The tick */   
    private int tick=0;
    /** The url_gate_open */
    private String url_gate_open = "sprite/gate_open.png";
    
    
    /**
     * Initiate Board
     * @param codeMap
     * 			the codeMap
     * @throws IOException
     * 			the IO Exception
     */
    
	public Board(String codeMap) throws IOException {
        initBoard(codeMap);
    }

	
	/**
	 * Configure Board
	 * @param codeMap
	 * 		The codeMap
	 * @throws IOException
	 * 		The IO exception
	 */
    private void initBoard(String codeMap) throws IOException {
    	
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        File Clap = new File("sprite/Heart of Courage - Two Steps From Hell 8-Bit.wav");
        PlaySound(Clap);
        
        ajoutliste(codeMap);
        //spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);
        System.out.println(spaceShip.x);
        gameover = new gamestate(0,0,"sprite/gameover.png");
        gamewin = new gamestate(0,0,"sprite/gamewin.png");
        timer = new Timer(DELAY, this);
        timer.start();
        
    }
    
    /**
     * Play Sound
     * 
     * @param Sound
     * 		the Sound
     */
    
    private void PlaySound(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();



     } catch(Exception e) {

     }
    }
    
    /**
     * Position of asset
     */
    
    private void incrementeCoordonnee()
    {
    	if (x < 608)
    	{
    		x = x+32;
    	}
    	else if (y < 352)
    	{
    		y = y+32;
    		x = 0;
    	}
    }
    
    
    /**
     * paint component
     * @param g
     * 		the g
     * 
     * (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * configure do drawing
     * 
     * @param g
     * 		the g
     */
    
    private void doDrawing(Graphics g) {
    	
        Graphics2D g2d = (Graphics2D) g;
        if(isgameover==false) {
            g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
                    spaceShip.getY(), this);
            for(Sprite items : item) {
            	items.draw(g);
            }
            for(Sprite sprites : sprite) {
            	sprites.draw(g);
            }
            for(Monster monsters : monster) {
            	monsters.draw(g);
            }

            List<Missile> missiles = spaceShip.getMissiles();

            for (Missile missile : missiles) {

                g2d.drawImage(missile.getImage(), missile.getX(),
                        missile.getY(), this);
            }
            if(iscrystaltake==true) {
            	g2d.drawImage(door_open.getImage(), door_open.getX(),
            			door_open.getY(), this);
            }
            
            if(iscrystaltake==false) {
            	g2d.drawImage(crystal.getImage(), crystal.getX(),
            			crystal.getY(), this);
            	g2d.drawImage(door_close.getImage(), door_close.getX(),
            			door_close.getY(), this);
            }
            g2d.drawString("bla", 25, 25);
            
        }

        if(isgameover==true) {
            gameover.draw(g);
            item.clear();
        	monster.clear();
        	sprite.clear();
        	crystal.setVisible(false);
        	door_open.setVisible(false);
        	door_close.setVisible(false);
        	//isgameover=false;
        	//iswin=false;
        	//iscrystaltake=false;
        	//x=0;
        	//y=0;
        	spaceShip.setVisible(false);
        }
        
        
        if(iswin==true) {
        	gamewin.draw(g);
        	item.clear();
        	monster.clear();
        	sprite.clear();
        	crystal.setVisible(false);
        	door_open.setVisible(false);
        	door_close.setVisible(false);
        	//isgameover=false;
        	//iswin=false;
        	//iscrystaltake=false;
        	//x=0;
        	//y=0;
        	spaceShip.setVisible(false);
        }
        

    }
    
    /**
     * update missiles, Lorann, monster
     * check collosion
     * 
     * @param e
     * 		the e
     * 
     * (non-Javadoc)
     * @see java.awt.event.ActionEvent
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        updateMissiles();
        updateSpaceShip();
        updateMonster();
        checkCollisions();
      
        


        int valeur1=spaceShip.Help();
        spaceShip.loadImage(valeur1);

        repaint();
    }
    
    /**
     * Update Monster
     */
    
    private void updateMonster() {
	
	for (int i = 0; i < monster.size(); i++) {

        Monster monster2 = monster.get(i);
        
        if (monster2.isVisible()) {
     	   if(tick==2) {
     		   monster2.Mouvement();
     	   }
            
        } else {

            monster.remove(i);
        }
    }
    tick++;
    if(tick>2) {
 	   tick=0;
    }
}

    
    /**
     * Update Missiles
     */
private void updateMissiles() {

        List<Missile> missiles = spaceShip.getMissiles();

        for (int i = 0; i < missiles.size(); i++) {

            Missile missile = missiles.get(i);

            if (missile.isVisible()) {

                missile.move(spaceShip.direction());
            } else {

                missiles.remove(i);
            }
        }
    }


	/**
	 * update Lorann
	 */
    private void updateSpaceShip() {
    	
    		spaceShip.move();
    		
    }

    
    /**
     * <h1>The Class TAdapter .</h1>
     *
     * @author Cedric Nathan Maximilien Benjamin
     * @version 1.0
     */
    
    private class TAdapter extends KeyAdapter {

    	/**
    	 * @param e
    	 * 		the e
    	 * 
    	 * (non-Javadoc)
    	 * @see java.awt.event.KeyEvent
    	 */
    	
        @Override
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }
        
        /**
         * @param e
         * 		the e
         * 
         * (non-Javadoc)
         * @see java.awt.event.KeyEvent
         */

        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
 
        }
    }
    
    /**
     * Generate Collision for item, sprite, monster spaceShip
     */
    public void checkCollisions() {

        Rectangle sp = spaceShip.getBounds();
        Rectangle dopen = door_open.getBounds();
        Rectangle dclose = door_close.getBounds();
        Rectangle crystale = crystal.getBounds();
        
        for(Sprite sprites: sprite) {
        	Rectangle wall = sprites.getBounds();
        	
        	if (sp.intersects(wall)) {
             	System.out.println("Ca touche");
             		spaceShip.reversemove();
            }
        	
        	if(dclose.intersects(sp)) {
        		spaceShip.reversemove();
        		isgameover=true;
        	}
        	
        	if(crystale.intersects(sp)) {
        		iscrystaltake=true;
        		crystal.setVisible(false);
        		crystal.x=-400;
        		crystal.y=-400;
        		System.out.println("tocuhe le crys");
        	}
        	
        	if(iscrystaltake==true && dopen.intersects(sp)) {
        		iswin=true;
        	}
        	
            for(Sprite items : item) {
            	Rectangle r_item = items.getBounds();
            	if(sp.intersects(r_item)) {
            		items.x=4000;
            		items.y=4000;
            		items.setVisible(false);
            		Score+=30;
            		System.out.println(Score);
            		
            	}
            }
            for(Monster monsters: monster) {
            	Rectangle monsters1= monsters.getBounds();
            	
            	if (sp.intersects(monsters1)) {
                 	System.out.println("Ca touche le monstre");
                 	isgameover =true;
                }
            	if (wall.intersects(monsters1)||dopen.intersects(monsters1)||dclose.intersects(monsters1)) {
            		monsters.reversMouvement();
            	}

                List<Missile> ms =spaceShip.getMissiles();
                
                for(Missile missile : ms) {
                	Rectangle miss = missile.getBounds();
                	 if(wall.intersects(miss)) {
                      	missile.setVisible(false);                      
                      }
                	 if(miss.intersects(monsters1)) {
                		 monsters.x=-400;
                		 monsters.y=-400;
                		 System.out.println("touchééé");
                	 }
                }     
            }    
        }
    }


    /**
     * 
     * @param cm
     * 		the c m
     * @throws IOException
     * 		the IO exception
     */
    public final void ajoutliste(String cm) throws IOException {
	    for (int i = 0; i < cm.length(); i++)
	    {	
	    	switch (cm.charAt(i))
	    	{
	    	case 'A':
	    		item.add(new Sprite(x, y, url_gold));
		    	break;
	    	case 'L':
	    		spaceShip = new SpaceShip(x,y);
		    	break;
	    	case 'M':
		    	monster.add(new Monster(x, y, url_monstre));
		    	break;
	    	case 'G':
		    	//sprite.add(new Sprite(x, y, url_gate));
	    		door_close = new Sprite(x,y,url_gate);
	    		door_open = new Sprite(x,y,url_gate_open);
		    	break;
	    	case 'C':
	    		//sprite.add(new Sprite(x, y, url_crystal));
	    		crystal = new Sprite(x,y,url_crystal);
		    	break;
	    	case 'V':
	    		sprite.add(new Sprite(x, y, url_v_bone));
		    	break;
	    	case 'B':
	    		sprite.add(new Sprite(x, y, url_bone));
		    	break;
	    	case 'H':
	    		sprite.add(new Sprite(x, y, url_h_bone));
		    	break;
	    	default:
	    	}
	    	incrementeCoordonnee();
	    	
	    }

    }
    

}
