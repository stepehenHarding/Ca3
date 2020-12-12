package com.dkit.gd2.stephenharding;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class DesktopDB
{
    private ArrayList<Desktop> desktop;
    private static Scanner keyboard = new Scanner(System.in);
    public DesktopDB(){this.desktop = new ArrayList<>();}

    protected void loadDesktopFromFile()
    {
        try(Scanner DesktopsFile = new Scanner (new BufferedReader(new FileReader("desktops.txt"))))
        {
            String input;
            while(DesktopsFile.hasNextLine())
            {
                input = DesktopsFile.nextLine();
                String[] data = input.split(",");
                String manufacturer = data[0];
                String processor = data[1];
                int ramSize = Integer.parseInt(data[2]);
                int diskSize = Integer.parseInt(data[3]);
                int weight = Integer.parseInt(data[4]);
                String assetTag = data[5];
                String purchaseDate = data[6];
                String monitorBrand = data[7];
                int monitorSize= Integer.parseInt(data[8]);


                Desktop readInDesktop = new Desktop(manufacturer,processor,ramSize,diskSize,weight ,assetTag,purchaseDate,monitorBrand,monitorSize);
                this.desktop.add(readInDesktop);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not find desktop.txt file");
        }
    }

    public void saveDesktopsToFile(){
        try(BufferedWriter desktopsFile = new BufferedWriter(new FileWriter("desktops.txt")))
        {
            for (Desktop desktop: desktop)
            {
                desktopsFile.write(desktop.getManufacturer()+","+desktop.getProcessor()+","+desktop.getRamSize()+","+desktop.getDiskSize()+","+desktop.getWeight()+","+desktop.getAssetTag()+","+desktop.getPurchaseDate()+","+desktop.getMonitorBrand()+","+desktop.getMonitorSize());
                desktopsFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Could not save Desktops to file");
        }
    }

    public void addDesktops()
    {
        String manufacturer = enterField("manufacturer");
        String processor = enterField("processor");
        int ramSize = loopUntilValidInt("ramSize");
        int diskSize = loopUntilValidInt("diskSize");
        int weight = loopUntilValidInt("weight");
        String assetTag = enterField("assetTag");
        String purchaseDate = enterField("purchaseDate");
        String monitorBrand =enterField("monitorBrand");
        int monitorSize= loopUntilValidInt("monitorSize");

        Desktop d = new Desktop(manufacturer,processor,ramSize,diskSize,weight,
                        assetTag,purchaseDate,monitorBrand,monitorSize);

        if(this.desktop !=null)
        {
            if(d != null)
            {
                desktop.add(d);
            }
            else
            {
                System.out.println("desktop could not be found");
            }
        }
        saveDesktopsToFile();
    }

    private String enterField(String field)
    {
        String input;
        System.out.println("Please enter Desktops "+field+":");
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
                if(intField.equals("ramSize"))
                {
                    int ramSize = Integer.parseInt(enterField(intField));
                    return ramSize;
                }
                else if(intField.equals("diskSize"))
                {
                    int diskSize = Integer.parseInt(enterField(intField));
                    return diskSize;
                }
                else if(intField.equals("weight"))
                {
                    int weight = Integer.parseInt(enterField(intField));
                    return weight;
                }
                if(intField.equals("monitorSize"))
                {
                    int monitorSize = Integer.parseInt(enterField(intField));
                    return monitorSize;
                }
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Please enter a valid interger");
            }
        }
        return -1;
    }

    public void deleteDesktop()
    {
        if(this.desktop !=null)
        {
            String desktopToDelete= enterField("desktopToDelete");
            Desktop desktopToRemove= findDesktop(desktopToDelete);
            if(desktopToRemove != null)
            {
                desktop.remove(desktopToRemove);
            }
            else
            {
                System.out.println("desktop could not be found");
            }
        }
    }

    private Desktop findDesktop(String desktopToDelete)
    {
        for(Desktop desktop: desktop)
        {
            if(desktop.getAssetTag().equals(desktopToDelete))
            {
                return desktop;
            }
        }
        return null;
    }

    public void printDesktop()
    {
        String desktopIDToPrint = enterField("assert tag to print");
        Desktop desktopToPrint = findDesktop(desktopIDToPrint);
        if(desktopToPrint != null)
        {
            System.out.println(desktopToPrint);
        }
        else
        {
            System.out.println("that desktop does not exist");
        }
    }

}
