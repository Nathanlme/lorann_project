package model.dao;

import static org.junit.Assert.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;


import org.junit.Test;

/**
 * <h1>The Class AbstractDaoTest</h1>
 * 
 * @author Nathan Maximilien Cedric Benjamin
 *
 * @see CallableStatement
 * @see ResultSet
 * 
 * @see Test
 */
public class AbstractDAOTest {

/**
 * test Execute Query
 */
    @Test
    public void testExecuteQuery() {
        final String query = null;
        ResultSet result = AbstractDAO.executeQuery(query);
        final ResultSet expected = null;
        assertEquals(expected, result);

    }

    /**
     * test Excute Update
     */
    
    @Test
    public void testExecuteUpdate() {
        final String query = null;
        int result = AbstractDAO.executeUpdate(query);
        final int expected = 0;
        assertEquals(expected, result);

    }

    /**
     * test Prepare Call
     */
    
    @Test
    public void testPrepareCall() {
        final String query = null;
        CallableStatement result = AbstractDAO.prepareCall(query);
        final ResultSet expected = LorannBDDConnector.getInstance().executeQuery(query);
        assertEquals(expected, result);
    }

}