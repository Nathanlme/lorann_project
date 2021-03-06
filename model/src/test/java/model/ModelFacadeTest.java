package model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

/**
 * <h1> The Class ModelFacadeTest</h1>
 * @author Maximilien Cedric Benjamin Nathan
 * @see SQLException
 * @see Test
 *
 */

public class ModelFacadeTest {
	
	/**
	 * test GetById
	 * @throws SQLException
	 * 			the SQL Exception
	 */
    @Test
    public void testGetExampleById() throws SQLException {
         ModelFacade ModelFacade = new ModelFacade();
         int id = 0;

         if (id == 1) {
                 String result = ModelFacade.getExampleById(id);
                 final String expected = "BHHHBHHHGHBHHHHHHHHBV C V     V        VV   V     V   B    VV   V     B   V    VV   V         V    VV   BHBHHHHHHHB    VV    AV A M        VV     V            VV  M  B     BHHHHHHBV             M   AVBHHHHHHHHHHHHHHHHHHB";
                 assertEquals(expected, result);
             }
         if (id == 2) {
                 String result = ModelFacade.getExampleById(id);
                 final String expected = "BHHHBHHHGHBHHHHHHHHBV C V     V        VV   V     V   B    VV   V     B   V    VV   V         V    VV   BHBHHHHHHHB    VV    AV A M        VV     V            VV  M  B     BHHHHHHBV             M   AVBHHHHHHHHHHHHHHHHHHB";
                 assertEquals(expected, result);
         }
         if (id == 3) {
                 String result = ModelFacade.getExampleById(id);
                 final String expected = "BHHHHHHHHHHHHHHHHHHBV                  VV   BHHB    BHHB   VV   V AV    V CV   VV M    V  M V  V   VV   BHHB    B HB M VV   VA        AV   VV   BHHHH  HHHHB   VV   V     M    V   VV A BHHHHHGHHHHB A VBHHHB          BHHHB";
                 assertEquals(expected, result);
             }
         if (id == 4) {
                 String result = ModelFacade.getExampleById(id);
                 final String expected = "BHHHHHHHHBHHHHHHHHHBV    M   V        AVBHHHHHB  B  M  HHHHBV                M GV  BHHHBHHHBHHHHHHHBV      V C V   A   VV  M   V    M      VV      BHHHBHHHHB  VBHHHHB             VVA    M            VBHHHHHHHHHHHHHHHHHHB";
                 assertEquals(expected, result);
             }

    }

}