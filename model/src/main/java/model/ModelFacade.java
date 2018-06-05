package model;

import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Maximilien Nathan Benjamin Cedric
 * @version 1.0
 * @see SQLException
 * @see List
 */
public final class ModelFacade implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public String getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

}
