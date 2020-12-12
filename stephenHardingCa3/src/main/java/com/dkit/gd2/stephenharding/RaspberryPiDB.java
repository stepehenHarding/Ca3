package com.dkit.gd2.stephenharding;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RaspberryPiDB
{
    private ArrayList<RaspberryPi> raspberryArray;
    private static Scanner keyboard = new Scanner(System.in);
    public RaspberryPiDB(){this.raspberryArray = new ArrayList<>();}

    protected void loadRaspberryPiFromFile()
    {
        try(Scanner raspberryFile = new Scanner (new BufferedReader(new FileReader("raspberry.txt"))))
        {
            String input;
            while(raspberryFile.hasNextLine())
            {
                input = raspberryFile.nextLine();
                String[] data = input.split(",");
                String manufacturer = data[0];
                String processor = data[1];
                int ramSize = Integer.parseInt(data[2]);
                int diskSize = Integer.parseInt(data[3]);
                int weight = Integer.parseInt(data[4]);
                String assetTag = data[5];
                String purchaseDate = data[6];
                int gpioPins = Integer.parseInt(data[7]);
                int sdCardSize= Integer.parseInt(data[8]);



                RaspberryPi readInRaspberry = new RaspberryPi(manufacturer,processor,ramSize,diskSize,weight ,assetTag,purchaseDate,gpioPins,sdCardSize);
                this.raspberryArray.add(readInRaspberry);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not find raspberry.txt file");
        }
    }

    public void saveRaspberryToFile(){
        try(BufferedWriter raspberryPiFile = new BufferedWriter(new FileWriter("raspberry.txt")))
        {
            for (RaspberryPi raspberryPi: raspberryArray)
            {
                raspberryPiFile.write(raspberryPi.getManufacturer()+","+raspberryPi.getProcessor()+","+raspberryPi.getRamSize()+","+raspberryPi.getDiskSize()+","+raspberryPi.getWeight()+","+raspberryPi.getAssetTag()+","+raspberryPi.getPurchaseDate()+","+raspberryPi.getGpioPins()+","+raspberryPi.getSdCardSize());
                raspberryPiFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Could not save RaspberryPi to file");
        }
    }

    public void addRaspberryPi()
    {
        String manufacturer = enterField("manufacturer");
        String processor = enterField("processor");
        int ramSize = loopUntilValidInt("ramSize");
        int diskSize = loopUntilValidInt("diskSize");
        int weight = loopUntilValidInt("weight");
        String assetTag = enterField("assetTag");
        String purchaseDate = enterField("purchaseDate");
        int GpioPins = loopUntilValidInt("Gpio");
        int sdCardSize = loopUntilValidInt("sdCard");

        RaspberryPi r = new RaspberryPi(manufacturer,processor,ramSize,
                diskSize,weight, assetTag,purchaseDate,GpioPins,sdCardSize);

        if(this.raspberryArray !=null)
        {
            if(r != null)
            {
                raspberryArray.add(r);
            }
            else
            {
                System.out.println("raspberryPi could not be found");
            }
        }
    }

    private String enterField(String field)
    {
        String input;
        System.out.println("Please enter RasperryPi "+field+":");
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
                if(intField.equals("Gpio"))
                {
                    int GpioPins = Integer.parseInt(enterField(intField));
                    return GpioPins;
                }
                if(intField.equals("sdCard"))
                {
                    int sdCardSize = Integer.parseInt(enterField(intField));
                    return sdCardSize;
                }
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Please enter a valid integer");
            }
        }
        return -1;
    }

    public void deleteRaspberryPi()
    {
        if(this.raspberryArray !=null)
        {
            String raspberryToDelete= enterField("raspberryToDelete");
            RaspberryPi raspberryToRemove= findRaspberryPi(raspberryToDelete);
            if(raspberryToRemove != null)
            {
                raspberryArray.remove(raspberryToRemove);
            }
            else
            {
                System.out.println("RaspberryPi could not be found");
            }
        }
        saveRaspberryToFile();
    }

    private RaspberryPi findRaspberryPi(String raspberryPiToDelete)
    {
        for(RaspberryPi raspberryPi: raspberryArray)
        {
            if(raspberryPi.getAssetTag().equals(raspberryPiToDelete))
            {
                return raspberryPi;
            }
        }
        return null;
    }

    public void printRaspberryPi()
    {
        String raspberryIDToPrint = enterField("assert tag to print");
        RaspberryPi raspberryToPrint = findRaspberryPi(raspberryIDToPrint);
        if(raspberryToPrint != null)
        {
            System.out.println(raspberryToPrint);
        }
        else
        {
            System.out.println("that raspberryPi does not exist");
        }
    }
}
