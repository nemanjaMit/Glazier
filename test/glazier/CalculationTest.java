
package glazier;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculationTest {

    public CalculationTest() {
    }
    
    @Before
    public void setUp() {
        
        
    }

    @Test
    public void testGetGlassPrice() throws Exception {
        Calculation calc = new Calculation();
        double expResult = 0;
        double result = calc.getGlassPrice();
        assertEquals(expResult, result, 0.001);

    }

    @Test
    public void testGetFramePrice() throws Exception {
        Calculation calc = new Calculation();
        double expResult = 0;
        double result = calc.getFramePrice();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testGetTotalPricePositive() throws Exception {
        Calculation calc = new Calculation();
        double height = 100;
        double width = 100;
        double expResult = 700;
        double result = calc.Calculation(height, width, 1);
        assertEquals(expResult, result, 0.001);
    }
    
    @Test
    public void testGetTotalPriceNegative() throws Exception {
        Calculation calc = new Calculation();
        double height = -100;
        double width = -100;
        double expResult = 0;
        
        double result = calc.Calculation(height, width, 1);
        assertEquals(expResult, result, 0.001);
        
    }
    
}
