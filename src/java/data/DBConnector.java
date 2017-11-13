package data;

import java.sql.*;

public class DBConnector {

    private Connection connection = null;

    //Constants
    private static final String IP = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE = "prices";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "nemanja123";

    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
