package com.dkit.gd2.stephenharding;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;
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
                String bookingDate= data[1];
                String returnDate=data[2];
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
        String bookingDate=enterField("bookingDate");
        String returnDate=enterField("returnDate");
        String computerType=enterField("computerType");
        String computerAssetTag=enterField("computerAssetTag");
        String studentID=enterField("studentID");

        Booking b = new Booking(bookingID,bookingDate,returnDate,computerType, computerAssetTag,studentID);

        if(this.booking !=null)
        {
            if(b != null )
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
    public void printAllBookings()
    {
        for(int i=0;i<booking.size();i++)
        {
            System.out.println(booking.get(i));
        }
    }

    public void editBooking()
    {

        if(this.booking !=null)
        {
            String bookingToDelete= enterField("BookingID To edit");
            Booking bookingToRemove= findBooking(bookingToDelete);
            if(bookingToRemove != null)
            {
                booking.remove(bookingToRemove);
                System.out.println("please enter updated desktop");
                addBookings();
            }
            else
            {
                System.out.println("desktop could not be found");
            }
        }
    }

    public void totalBookings()
    {
        int totalbookings=0;
        int totalLaptops=0;
        int totalDesktops=0;
        int totalRaspberrysPis=0;

        for(int i =0; i<=booking.size();i++){
            totalbookings=i;
//            if(booking.get(i).getComputerType().equals("Laptop"))
//            {
//                totalLaptops= totalLaptops+1;
//            }
//            else if(booking.get(i).getComputerType().equals("RaspberryPi"))
//            {
//                totalLaptops= totalRaspberrysPis+1;
//            }
//            else if(booking.get(i).getComputerType().equals("Desktop"))
//            {
//                totalLaptops= totalDesktops+1;
//            }
//
        }
            System.out.println(Colours.RED+"number of bookings= "+totalbookings+Colours.RESET);
            System.out.println(Colours.RED+"number of Laptops= "+totalLaptops+Colours.RESET);

    }




}
