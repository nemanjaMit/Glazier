package glazier;

import data.DataAccessObject;

public class Calculation {

    private static DataAccessObject dao;
     
    private double glassPrice;
    private double framePrice;
    private double totalPrice;

    public Calculation() throws Exception {
        dao = new DataAccessObject();
    }
    
    /**
     * The Calculation method is valid when both height and width are > 0.
     * First step is to pull out the glassPrice and framePrice from the database.
     * Then it will convert height and width from cm to M to make it easier for the calculation.
     * Finally we use the parameters and the converted
     * variables to calculate the glassPrice, framePrice and the total price for the window in DKK.
     * @param height
     * @param width
     * @param type
     * @return totalPrice
     * @throws Exception 
     */

    public double Calculation(double height, double width, int type) throws Exception {
        
        if (width > 0 && height > 0) {

            try {

                glassPrice = dao.getGlassPrice(); // Gets the glassprice from the database.
                framePrice = dao.getFramePrice(type); // Gets the frameprice from the database.

                double heightMeters = height / 100; // height converted to M
                double widthMeters = width / 100; // width converted to M

                glassPrice = heightMeters * widthMeters * glassPrice;
                framePrice = (2 * heightMeters + 2 * widthMeters) * framePrice;
                totalPrice = getGlassPrice() + getFramePrice();

            } catch (Exception e) {
                throw new Exception(e);
            }
        }

        return totalPrice;
    }
    
    /**
     * getGlassPrice method returns the glassPrice, so we can show and use the framePrice in the servlet.
     * @return glassPrice
     */
    
    public double getGlassPrice() {
        return Math.floor(glassPrice * 100) / 100;
        
    }
    
    /**
     * getFramePrice method returns the framePrice, so we can show and use the framePrice in the servlet.
     * @return framePrice
     */

    public double getFramePrice() {
        return Math.floor(framePrice * 100) / 100;
    }
    
    /**
     * getTotalPrice method returns the totalPrice so we can use it in the servlet for the final calculation.
     * @return totalPrice
     */

    public double getTotalPrice() {
        return Math.floor(totalPrice * 100) / 100;
        
    }

}
