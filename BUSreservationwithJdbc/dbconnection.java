package BUSreservationwithJdbc;

import java.sql.*;

public class dbconnection {

    private static final String url = "jdbc:mysql://localhost:3306/busresv";
    private static final String userName = "root";
    private static final String password = "15750";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
