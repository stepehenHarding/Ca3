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
        desktopDB.loadDesktopFromFile();
        doMenuLoop(desktopDB);
        desktopDB.saveDesktopsToFile();
    }

    private void doMenuLoop(DesktopDB desktopDB)
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

    private void printMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < MainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + MainMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Enter a number to select the option (0 to quit):>");
    }



}
