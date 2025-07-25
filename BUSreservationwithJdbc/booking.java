package BUSreservationwithJdbc;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class booking {
    String passangerName;
    int busNo;
    Date date;

    booking() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of passanger: ");
        passangerName = sc.next();
        System.out.println("Enter bus no: ");
        busNo = sc.nextInt();
        System.out.println("Enter date dd-MM-yyyy");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            date = null;
        }
    }

    public boolean isValid() {
        return date != null;
    }

    public boolean isAvailable() throws SQLException {
        if (date == null)
            return false;
        BusDAO busdao = new BusDAO();
        BookingDAO bookingdao = new BookingDAO();

        int capacity = busdao.getCapacity(busNo);
        int booked = bookingdao.getBookedCount(busNo, date);

        return booked < capacity;
    }
}
