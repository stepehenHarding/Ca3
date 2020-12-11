package com.dkit.gd2.stephenharding;

public class Computer
{
    private String manufacturer;
    private String processor;
    private int ramSize;
    private int diskSize;
    private int weight;
    private String assetTag;
    private String purchaseDate;

    public Computer(String manufacturer, String processor, int ramSize, int diskSize, int weight,String assetTag,String purchaseDate) {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.weight = weight;
        this.assetTag = assetTag;
        this.purchaseDate = purchaseDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public int getWeight() {
        return weight;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "manufacturer='" + manufacturer + '\'' +
                ", processor='" + processor + '\'' +
                ", ramSize=" + ramSize +
                ", diskSize=" + diskSize +
                ", weight=" + weight +
                ", assetTag='" + assetTag + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }
}
