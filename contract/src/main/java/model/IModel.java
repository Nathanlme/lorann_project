package model;

import java.sql.SQLException;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Cedric Benjamin Maximilien Nathan
 * @version 1.0
 * @see SQLException
 * @see List
 */
public interface IModel {

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    String getExampleById(int id) throws SQLException;

}
