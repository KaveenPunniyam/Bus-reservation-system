package BUSreservationwithJdbc;

import java.sql.*;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException {
        if (date == null) {
            System.out.println("cannot check booking, date is null");
            return -1;
        }
        String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";

        Connection con = dbconnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query);
        // java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setInt(1, busNo);
        pst.setDate(2, new java.sql.Date(date.getTime()));
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(booking book) throws SQLException {
        String query = " Insert into booking values(?,?,?)";
        Connection con = dbconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        // java.sql.Date sqldate=new java.sql.Date(book.date.getTime());
        pst.setString(1, book.passangerName);
        pst.setInt(2, book.busNo);
        pst.setDate(3, new java.sql.Date(book.date.getTime()));
        pst.executeUpdate();

    }
}
