package com.dkit.gd2.stephenharding;

import java.util.InputMismatchException;
import java.util.Scanner;



public class App
{
    private static Scanner keyboard= new Scanner(System.in);
    public static void main(String[] args)
    {
        App computerDBApp = new App();
        computerDBApp.start();
    }

    private void start()
    {
        System.out.println("welcome to Computer database app");
        DesktopDB desktopDB = new DesktopDB();
        RaspberryPiDB raspberryDB = new RaspberryPiDB();
        LaptopDB laptopDB = new LaptopDB();
        StudentDB studentDB = new StudentDB();
        BookingDB bookingDB = new BookingDB();
        desktopDB.loadDesktopFromFile();
        raspberryDB.loadRaspberryPiFromFile();
        laptopDB.loadLaptopFromFile();
        studentDB.loadStudentFromFile();
        bookingDB.loadBookingFromFile();
        doMenuLoop(desktopDB,raspberryDB,laptopDB,studentDB,bookingDB);
        desktopDB.saveDesktopsToFile();
        raspberryDB.saveRaspberryToFile();
        laptopDB.saveLaptopsToFile();
        studentDB.saveStudentToFile();
        bookingDB.saveBookingsToFile();
    }

    private void doMenuLoop(DesktopDB desktopDB ,RaspberryPiDB raspberryDB,LaptopDB laptopDB,StudentDB studentDB,BookingDB bookingDB)
    {
        boolean loop = true;
        MainMenu menuOption;
        int option = -1;
        while(loop)
        {
            printMainMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = MainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_APPLICATION:
                        loop=false;
                        break;
                    case DISPLAY_DESKTOP_MENU:
                        doDesktopMenuLoop(desktopDB);
                        break;
                    case DISPLAY_LAPTOP_MENU:
                        doLaptopMenuLoop(laptopDB);
                        break;
                    case DISPLAY_RASPBERRYPI_MENU:
                        doRaspberryPiMenuLoop(raspberryDB);
                        break;
                    case DISPLAY_STUDENT_MENU:
                        doStudentMenuLoop(studentDB);
                        break;
                    case DISPLAY_BOOKINGS_MENU:
                        doBookingMenuLoop(bookingDB);


                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println("please enter a valid option");
            }
        }
    }

    private void printMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < MainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + MainMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Enter a number to select the option (0 to quit):>");
    }

    /////////////////////////////////DESKTOP//////////////////////////////////////////////////////////
    private void doDesktopMenuLoop(DesktopDB desktopDB)
    {
        boolean loop = true;
        DesktopMainMenu menuOption;
        int option = -1;
        while(loop)
        {
            printDesktopMainMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = DesktopMainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_DESKTOP_MENU:
                        loop=false;
                        break;
                    case ADD_DESKTOP:
                        desktopDB.addDesktops();
                        break;
                    case DELETE_DESKTOP:
                        desktopDB.deleteDesktop();
                        break;
                    case PRINT_DESKTOP:
                        desktopDB.printDesktop();
                        break;
                }

            }
            catch(InputMismatchException ime)
            {
                System.out.println("please enter a valid option");
            }
        }
    }

    private void printDesktopMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < DesktopMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + DesktopMainMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Enter a number to select the option (0 to quit):>");
    }

    ///////////////////////////RaspberryPi///////////////////////////////////////////

    private void doRaspberryPiMenuLoop(RaspberryPiDB raspberryDB)
    {
        boolean loop = true;
        RaspberryPiMainMenu menuOption;
        int option = -1;
        while(loop)
        {
            printRaspberryPiMainMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = RaspberryPiMainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_RASPBERRYPI_MENU:
                        loop=false;
                        break;
                    case ADD_RASPBERRYPI:
                        raspberryDB.addRaspberryPi();

                        break;
                    case DELETE_RASPBERRYPI:
                        raspberryDB.deleteRaspberryPi();
                        break;
                    case PRINT_RASPBERRYPI:
                        raspberryDB.printRaspberryPi();
                        break;
                }

            }
            catch(InputMismatchException ime)
            {
                System.out.println("please enter a valid option");
            }
        }
    }

    private void printRaspberryPiMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < RaspberryPiMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + RaspberryPiMainMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Enter a number to select the option (0 to quit):>");
    }

    //////////////////////////////////////////////////////////////////////////

    private void doLaptopMenuLoop(LaptopDB laptopDB)
    {
        boolean loop = true;
        LaptopMainMenu menuOption;
        int option = -1;
        while(loop)
        {
            printLaptopMainMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = LaptopMainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_LAPTOP_MENU:
                        loop=false;
                        break;
                    case ADD_LAPTOP:
                        laptopDB.addLaptops();
                        break;
                    case DELETE_LAPTOP:
                        laptopDB.deleteLaptop();
                        break;
                    case PRINT_LAPTOP:
                        laptopDB.printLaptop();
                        break;
                }

            }
            catch(InputMismatchException ime)
            {
                System.out.println("please enter a valid option");
            }
        }
    }

    private void printLaptopMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < LaptopMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + LaptopMainMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Enter a number to select the option (0 to quit):>");
    }
    ///////////////////////////////////////////////////////////////////////////////

    private void doStudentMenuLoop(StudentDB studentDB)
    {
        boolean loop = true;
        StudentMainMenu menuOption;
        int option = -1;
        while(loop)
        {
            printStudentMainMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = StudentMainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_STUDENT_MENU:
                        loop=false;
                        break;
                    case ADD_STUDENT:
                        studentDB.addStudent();
                        break;
                    case DELETE_STUDENT:
                        studentDB.deleteStudent();
                        break;
                    case PRINT_STUDENT:
                        studentDB.printStudent();
                        break;
                    case PRINT_ALL_STUDENT:
                        studentDB.printAllStudents();
                }

            }
            catch(InputMismatchException ime)
            {
                System.out.println("please enter a valid option");
            }
        }
    }

    private void printStudentMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < StudentMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + StudentMainMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Enter a number to select the option (0 to quit):>");
    }
    ///////////////////////////////////////////////////////////////////////////////////////
    private void doBookingMenuLoop(BookingDB bookingDB)
    {
        boolean loop = true;
        BookingMainMenu menuOption;
        int option = -1;
        while(loop)
        {
            printBookingMainMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = BookingMainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_BOOKINGS_MENU:
                        loop=false;
                        break;
                    case ADD_BOOKING:
                        bookingDB.addBookings();
                        break;
                    case DELETE_BOOKING:
                        bookingDB.deleteBooking();
                        break;
                    case PRINT_BOOKING:
                        bookingDB.printBooking();
                        break;
                    case PRINT_ALL_BOOKINGS:
                        bookingDB.printBooking();
                        break;
                }

            }
            catch(InputMismatchException ime)
            {
                System.out.println("please enter a valid option");
            }
        }
    }

    private void printBookingMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < BookingMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + BookingMainMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Enter a number to select the option (0 to quit):>");
    }




}
