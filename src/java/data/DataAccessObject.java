package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessObject {

    private final DBConnector connection;

    public DataAccessObject() throws Exception {
        this.connection = new DBConnector();
    }
    
    /**
     * The method gets the price of glass from the SQL database.
     * @return res.getInt("price") - The glassprice from database.
     * @throws SQLException
     * @throws Exception 
     */

    public int getGlassPrice() throws SQLException, Exception {
        Statement stmt = connection.getConnection().createStatement();
        String sql = "SELECT price FROM prices WHERE id = 0";

        try {
            ResultSet res = stmt.executeQuery(sql);
            if(res.next()) {
                return res.getInt("price");
            }
            else {
                throw new Exception("Error!");
            }
        }
        catch(SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    /**
     * The method gets the price of the chosen frametype (Wood, Vinyl or Aluminium) from the SQL database.    
     * @param frameType
     * @return res.getInt("price") - The price of the chosen frametype from database.
     * @throws SQLException
     * @throws Exception 
     */

    public int getFramePrice(int frameType) throws SQLException, Exception {
        Statement stmt = connection.getConnection().createStatement();
        String sql = "SELECT price FROM prices WHERE id = " + frameType;

        try {
            ResultSet res = stmt.executeQuery(sql);
            if(res.next()) {
                return res.getInt("price");
            }
            else {
                throw new Exception("Error");
            }
        }
        catch(SQLException ex) {
            throw new Exception(ex);
        }
    }

}
