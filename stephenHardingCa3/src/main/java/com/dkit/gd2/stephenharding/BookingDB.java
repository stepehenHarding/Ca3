package com.dkit.gd2.stephenharding;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookingDB
{
    private ArrayList<Booking> booking;
    private static Scanner keyboard = new Scanner(System.in);
    public BookingDB(){this.booking = new ArrayList<>();}

    protected void loadBookingFromFile()
    {
        try(Scanner BookingsFile = new Scanner (new BufferedReader(new FileReader("bookings.txt"))))
        {
            String input;
            while(BookingsFile.hasNextLine())
            {
                input = BookingsFile.nextLine();
                String[] data = input.split(",");
                String bookingID = data[0];
                int bookingDate =Integer.parseInt(data[1]);
                int returnDate = Integer.parseInt(data[2]);
                String computerType= data[3];
                String computerAssetTag= data[4];
                String studentID= data[5] ;



                Booking readInBooking = new Booking(bookingID,bookingDate,returnDate,computerType,computerAssetTag,studentID);
                this.booking.add(readInBooking);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not find desktop.txt file");
        }
    }

    public void saveBookingsToFile(){
        try(BufferedWriter bookingsFile = new BufferedWriter(new FileWriter("bookings.txt")))
        {
            for (Booking booking: booking)
            {
                bookingsFile.write(booking.getBookingID()+","+booking.getReturnDate()+","+ booking.getReturnDate()+","+booking.getComputerType()+","+
                        booking.getComputerAssetTag()+","+booking.getStudentID());
                bookingsFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Could not save Bookings to file");
        }
    }

    public void addBookings()
    {
        String bookingID= enterField("bookingID");
        int bookingDate=loopUntilValidInt("bookingDate");
        int returnDate=loopUntilValidInt("returnDate");
        String computerType=enterField("computerType");
        String computerAssetTag=enterField("computerAssetTag");
        String studentID=enterField("studentID");

        Booking b = new Booking(bookingID,bookingDate,returnDate,computerType, computerAssetTag,studentID);

        if(this.booking !=null)
        {
            if(b != null)
            {
                booking.add(b);
            }
            else
            {
                System.out.println("booking could not be found");
            }
        }
        saveBookingsToFile();
    }

    private String enterField(String field)
    {
        String input;
        System.out.println("Please enter Bookings "+field+":");
        input = keyboard.nextLine();
        return input;
    }

    private int loopUntilValidInt(String intField)
    {
        boolean check = true;
        while(check)
        {
            try
            {
                if(intField.equals("bookingDate"))
                {
                    int bookingDate = Integer.parseInt(enterField(intField));
                    return bookingDate;
                }
                else if(intField.equals("returnDate"))
                {
                    int ramSize = Integer.parseInt(enterField(intField));
                    return ramSize;
                }

            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Please enter a valid interger");
            }
        }
        return -1;
    }

    public void deleteBooking()
    {
        if(this.booking !=null)
        {
            String bookingToDelete= enterField("bookingToDelete");
            Booking bookingToRemove= findBooking(bookingToDelete);
            if(bookingToRemove != null)
            {
                booking.remove(bookingToRemove);
            }
            else
            {
                System.out.println("booking could not be found");
            }
        }
    }

    private Booking findBooking(String bookingToDelete)
    {
        for(Booking booking: booking)
        {
            if(booking.getBookingID().equals(bookingToDelete))
            {
                return booking;
            }
        }
        return null;
    }

    public void printBooking()
    {
        String bookingIDToPrint = enterField("bookingID to print");
        Booking bookingToPrint = findBooking(bookingIDToPrint);
        if(bookingToPrint != null)
        {
            System.out.println(bookingToPrint);
        }
        else
        {
            System.out.println("that booking does not exist");
        }
    }
//    public void printAllBookings()
//    {
//        for(int i=0;i<booking.size();i++)
//        {
//            System.out.println(booking.get(i));
//        }
//    }

}
