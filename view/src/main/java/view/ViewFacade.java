package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Nathan Cedric Maximilien Benjamin
 * @version 1.0
 * 
 * @see Color
 * @see Dimension
 * @see EventQueue
 * @see IOException
 * @see Timer
 * 
 * @see JFrame
 * @see JOptionPane
 * @see JPanel
 * 
 * 
 * 
 */
public class ViewFacade extends JFrame implements IView {

		/** The Serial ID */ 
	    private static final long serialVersionUID = 1L;
	    /** The codeMap */
		private String codeMap = "";
		/** The container */
		public JPanel container = new JPanel();
	    /** The initial frame size. */
	    private static final int  defaultFrameSize_1 = 645;
	    /** The initial frame size. */
	    private static final int  defaultFrameSize = 384+32;
	    

	    
	    

	
	    /**
	     * Instantiates a new view facade, use initUI.
	     * 
	     * @param level
	     * 		the level
	     * @throws IOException
	     * 		the IO exception
	     */
    public void ViewFacade(String level) throws IOException {
    	initUI(level);
    	this.codeMap = level;
    }

    
    /**
     * InitUI
     * 
     * @param level
     * 		the level
     * @throws IOException
     * 		the IO Exception
     */
    private void initUI(String level) throws IOException {

        add(new Board(level));
        this.setTitle("Lorann's game's");
        this.setSize(defaultFrameSize_1, defaultFrameSize);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);
        this.setVisible(true);

    }
    
    



/**
 * message
 * @return null
 * 
 * (non-Javadoc)
 * @see java.lang.String
 */

	@Override
	public String message() {
		return null;
	}

/**
 * getCodeMap
 * 
 * @return codeMap
 */
	public String getCodeMap() {
		return codeMap;
	}


	/**
	 * setCodeMap
	 * 
	 * @param codeMap
	 * 		the codeMap
	 */
	public void setCodeMap(String codeMap) {
		this.codeMap = codeMap;
	}


}
	
	

