package com.dkit.gd2.stephenharding;

public class Desktop extends Computer{
    private String monitorBrand;
    private int monitorSize;

    public Desktop(String manufacturer, String processor, int ramSize, int diskSize, int weight,
                   String assetTag, String purchaseDate, String monitorBrand, int monitorSize) {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.monitorBrand = monitorBrand;
        this.monitorSize = monitorSize;
    }

    public String getMonitorBrand() { return monitorBrand; }

    public int getMonitorSize() { return monitorSize; }

    @Override
    public String toString() {
        return "Desktop{"+Colours.GREEN +"Manufacturer= "+getManufacturer() +", Processor= "+getProcessor()+", RamSize= "+getRamSize()+", Disk size= "+getDiskSize()
                +", Weight"+getWeight()+", Assert Tag= "+getAssetTag()+", Purchase Date= "+getPurchaseDate()+ ", monitorBrand='" + monitorBrand + ", monitorSize=" + monitorSize + '}'+Colours.RESET+'\'';
    }
}
