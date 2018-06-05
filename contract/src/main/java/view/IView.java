package view;

import java.io.IOException;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Maximilien Cedric Benjamin Nathan
 * @version 1.0
 * @see IOException
 */
public interface IView {
	
	/**
     * ViewFacade
     *
     * @param level
     *            the level
     * @throws IOException 
     * 			the IOException
     */
	void ViewFacade(String level)  throws IOException;


    
    String message();
    
    
    /**
     * Main Missile
     */
    static void mainMissile() {

		
	}
}
