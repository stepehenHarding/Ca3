package com.dkit.gd2.stephenharding;

public class Laptop extends Computer{
    private int screenSize;
    private int batteryLife;

    public Laptop(String manufacturer, String processor, int ramSize, int diskSize, int weight, String assetTag, String purchaseDate, int screenSize, int batteryLife) {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    @Override
    public String toString() {
        return "Laptop{"+Colours.GREEN +"Manufacturer= "+getManufacturer() +", Processor= "+getProcessor()+", RamSize= "+getRamSize()+", Disk size= "+getDiskSize()
                +", Weight"+getWeight()+", Assert Tag= "+getAssetTag()+", Purchase Date= "+getPurchaseDate()+"screenSize=" + screenSize +
                ", batteryLife=" + batteryLife + '}'+Colours.RESET+'\'';
    }


}
