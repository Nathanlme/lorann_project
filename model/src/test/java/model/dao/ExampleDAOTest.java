package model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

/**
 * <h1>The Class ExampleDAOTest</h1>
 * @author Nathan Maximilien Cedric Benjamin
 * @see SQLException
 * @see Test
 *
 */

public class ExampleDAOTest {
	
	/**
	 * test GetById
	 * 
	 * @throws SQLException
	 * 		the SQLException
	 */
@Test
    public void testGetExampleById() throws SQLException {
        //ExampleDAO ExampleDAO = new ExampleDAO();
        int id = 0;
        if (id == 1)
        {
        String result = ExampleDAO.getExampleById(id);
        final String expected = "BHHHBHHHGHBHHHHHHHHBV C V     V        VV   V     V   B    VV   V     B   V    VV   V         V    VV   BHBHHHHHHHB    VV    AV A M        VV     V            VV  M  B     BHHHHHHBV             M   AVBHHHHHHHHHHHHHHHHHHB";
        assertEquals(expected, result);
        }
        if (id == 2) {
             String result = ExampleDAO.getExampleById(id);
             final String expected = "BHHHBHHHGHBHHHHHHHHBV C V     V        VV   V     V   B    VV   V     B   V    VV   V         V    VV   BHBHHHHHHHB    VV    AV A M        VV     V            VV  M  B     BHHHHHHBV             M   AVBHHHHHHHHHHHHHHHHHHB";
             assertEquals(expected, result);
     }
     if (id == 3) {
             String result = ExampleDAO.getExampleById(id);
             final String expected = "BHHHHHHHHHHHHHHHHHHBV                  VV   BHHB    BHHB   VV   V AV    V CV   VV M    V  M V  V   VV   BHHB    B HB M VV   VA        AV   VV   BHHHH  HHHHB   VV   V     M    V   VV A BHHHHHGHHHHB A VBHHHB          BHHHB";
             assertEquals(expected, result);
         }
     if (id == 4) {
             String result = ExampleDAO.getExampleById(id);
             final String expected = "BHHHHHHHHBHHHHHHHHHBV    M   V        AVBHHHHHB  B  M  HHHHBV                M GV  BHHHBHHHBHHHHHHHBV      V C V   A   VV  M   V    M      VV      BHHHBHHHHB  VBHHHHB             VVA    M            VBHHHHHHHHHHHHHHHHHHB";
             assertEquals(expected, result);
         }
    }

}