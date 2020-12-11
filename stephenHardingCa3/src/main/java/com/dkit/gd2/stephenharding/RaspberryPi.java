package com.dkit.gd2.stephenharding;

public class RaspberryPi extends Computer{
    private int gpioPins;
    private int sdCardSize;

    public RaspberryPi(String manufacturer, String processor, int ramSize, int diskSize, int weight, String assetTag, String purchaseDate, int gpioPins, int sdCardSize) {
        super("raspberry Pi", processor, ramSize, 0, weight, assetTag, purchaseDate);
        this.gpioPins = gpioPins;
        this.sdCardSize = sdCardSize;
    }

    public int getGpioPins() {
        return gpioPins;
    }

    public int getSdCardSize() {
        return sdCardSize;
    }
}
