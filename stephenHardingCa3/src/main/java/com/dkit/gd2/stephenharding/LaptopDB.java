package com.dkit.gd2.stephenharding;


import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class LaptopDB
{
    private ArrayList<Laptop> laptop;
    private static Scanner keyboard = new Scanner(System.in);
    public LaptopDB(){this.laptop = new ArrayList<>();}

    protected void loadLaptopFromFile()
    {
        try(Scanner LaptopsFile = new Scanner (new BufferedReader(new FileReader("Laptops.txt"))))
        {
            String input;
            while(LaptopsFile.hasNextLine())
            {
                input = LaptopsFile.nextLine();
                String[] data = input.split(",");
                String manufacturer = data[0];
                String processor = data[1];
                int ramSize = Integer.parseInt(data[2]);
                int diskSize = Integer.parseInt(data[3]);
                int weight = Integer.parseInt(data[4]);
                String assetTag = data[5];
                String purchaseDate = data[6];
                int screenSize = Integer.parseInt(data[7]);
                int batteryLife= Integer.parseInt(data[8]);


                Laptop readInLaptop = new Laptop(manufacturer,processor,ramSize,diskSize,weight ,assetTag,
                        purchaseDate,screenSize,batteryLife);
                this.laptop.add(readInLaptop);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not find laptop.txt file");
        }
    }

    public void saveLaptopsToFile(){
        try(BufferedWriter laptopsFile = new BufferedWriter(new FileWriter("laptops.txt")))
        {
            for (Laptop laptop: laptop)
            {
                laptopsFile.write(laptop.getManufacturer()+","+laptop.getProcessor()+","+laptop.getRamSize()+","+laptop.getDiskSize()+","+laptop.getWeight()+","+laptop.getAssetTag()+","+laptop.getPurchaseDate()+","+laptop.getScreenSize()+","+laptop.getBatteryLife());
                laptopsFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Could not save Laptops to file");
        }

    }

    public void addLaptops()
    {
        String manufacturer = enterField("manufacturer");
        String processor = enterField("processor");
        int ramSize = loopUntilValidInt("ramSize");
        int diskSize = loopUntilValidInt("diskSize");
        int weight = loopUntilValidInt("weight");
        String assetTag = enterField("assetTag");
        String purchaseDate = enterField("purchaseDate");
        int screenSize = loopUntilValidInt("screenSize");
        int batterLife= loopUntilValidInt("batterLife");

        Laptop l = new Laptop(manufacturer,processor,ramSize,diskSize,weight,
                assetTag,purchaseDate,screenSize,batterLife);

        if(this.laptop !=null)
        {
            if(l != null)
            {
                laptop.add(l);
            }
            else
            {
                System.out.println("Laptop could not be found");
            }
        }
        saveLaptopsToFile();
    }

    private String enterField(String field)
    {
        String input;
        System.out.println("Please enter Laptops "+field+":");
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
                if(intField.equals("screenSize"))
                {
                    int screenSize = Integer.parseInt(enterField(intField));
                    return screenSize;
                }
                if(intField.equals("batterLife"))
                {
                    int batteryLife = Integer.parseInt(enterField(intField));
                    return batteryLife;
                }
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Please enter a valid interger");
            }
        }
        return -1;
    }

    public void deleteLaptop()
    {
        if(this.laptop !=null)
        {
            String laptopToDelete= enterField("laptopToDelete");
            Laptop laptopToRemove= findLaptop(laptopToDelete);
            if(laptopToRemove != null)
            {
                laptop.remove(laptopToRemove);
            }
            else
            {
                System.out.println("laptop could not be found");
            }
        }
        saveLaptopsToFile();
    }

    private Laptop findLaptop(String laptopToDelete)
    {
        for(Laptop laptop: laptop)
        {
            if(laptop.getAssetTag().equals(laptopToDelete))
            {
                return laptop;
            }
        }
        return null;
    }

    public void printLaptop()
    {
        String laptopIDToPrint = enterField("assert tag to print");
        Laptop laptopToPrint = findLaptop(laptopIDToPrint);
        if(laptopToPrint != null)
        {
            System.out.println(laptopToPrint);
        }
        else
        {
            System.out.println("that desktop does not exist");
        }
    }

}
