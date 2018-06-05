package controller;

import view.IView;
import java.io.IOException;
import java.sql.SQLException;

import model.IModel;


/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Cedric Nathan Benjamin Maximilien
 * @version 1.0
 * @see IView
 * @see IOException
 * @see SQLException
 * @see IModel
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    

    
    

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.model = model;
        this.view = view;

    }

    /**
     * Map
     *
     * @throws SQLException
     *             the SQL exception
     * @return this.getModel().getExampleById(2).toString();
     *
     */
    public String map() throws SQLException {
    	
		return this.getModel().getExampleById(2).toString();
		
    	
    }
    /**
     * Start
     * 
     * @throws SQLException
     * 			The SQL exception
     * @throws IOException
     * 			The IO exception
     */
    public void start() throws SQLException, IOException {   	
    	this.getView().ViewFacade(this.getModel().getExampleById(4).toString());

    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
}
