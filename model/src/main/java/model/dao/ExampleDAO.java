package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Maximilien Nathan Benjamin Cedric
 * @version 1.0
 * 
 * @see CallableStatement
 * @see ResultSet
 * @see SQLException
 */
public abstract class ExampleDAO extends AbstractDAO {

    /** The sql example by id. */
    private static String sqlExampleById   = "{call findExampleById(?)}";

    /** The name column index. */
    private static int    nameColumnIndex  = 2;

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public static String getExampleById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleById);
        String example = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                example = result.getString(nameColumnIndex);
            }
            result.close();
        }
        System.out.println("ici" + example);
        return example;
    }

}
