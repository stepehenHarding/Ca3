package com.dkit.gd2.stephenharding;
import java.util.Date;

public class Booking {
    private String bookingID;
    private int bookingDate;
    private int returnDate;
    private String computerType;
    private String ComputerAssetTag;
    private String StudentID;

    public Booking(String bookingID, int bookingDate, int returnDate, String computerType, String computerAssetTag, String studentID) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.returnDate = returnDate;
        this.computerType = computerType;
        ComputerAssetTag = computerAssetTag;
        StudentID = studentID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public int getBookingDate() {
        return bookingDate;
    }

    public int getReturnDate() {
        return returnDate;
    }

    public String getComputerType() {
        return computerType;
    }

    public String getComputerAssetTag() {
        return ComputerAssetTag;
    }

    public String getStudentID() {
        return StudentID;
    }

    @Override
    public String toString() {
        return Colours.RED +
                "bookingID='"+Colours.GREEN + bookingID+
                ", bookingDate='" + bookingDate+
                ", returnDate='" + returnDate+
                ", computerType='" + computerType+
                ", ComputerAssetTag='" + ComputerAssetTag+
                ", StudentID='" + StudentID +
                '}'+Colours.RESET;
    }
}
