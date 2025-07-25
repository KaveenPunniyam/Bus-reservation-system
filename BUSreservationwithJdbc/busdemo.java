package BUSreservationwithJdbc;

import java.util.*;

public class busdemo {

    public static void main(String args[]) {

        BusDAO busdao = new BusDAO();
        try {
            busdao.displayBusInfo();

            int userOpt = 1;
            Scanner sc = new Scanner(System.in);

            while (userOpt == 1) {
                System.out.println("Enter 1 to Book 2 to exit");
                userOpt = sc.nextInt();
                if (userOpt == 1) {

                    booking book = new booking();
                    if (book.isValid()) {
                        if (book.isAvailable()) {
                            BookingDAO bookingdao = new BookingDAO();
                            bookingdao.addBooking(book);
                            System.out.println("Your booking is Confirmed");
                        } else {
                            System.out.println("Sorry, Bus is full. Try another bus or date, ");
                        }
                    } else {
                        System.out.println("booking failed: Invalid date format");
                    }

                }

            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
