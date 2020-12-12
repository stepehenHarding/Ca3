package com.dkit.gd2.stephenharding;

public class Student {
    private String name;
    private String ID;
    private String eMail;
    private int telephone;
    private String computerOnLoan;

    public Student(String name, String ID, String eMail, int telephone, String computerOnLoan) {
        this.name = name;
        this.ID = ID;
        this.eMail = eMail;
        this.telephone = telephone;
        this.computerOnLoan = computerOnLoan;
    }

    public String getName() { return name; }

    public String getID() { return ID; }

    public String geteMail() { return eMail; }

    public int getTelephone() { return telephone; }

    public String getComputerOnLoan() { return computerOnLoan;}

    @Override
    public String toString() {
        return Colours.RED+"Student" +Colours.GREEN+
                "{name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", eMail='" + eMail + '\'' +
                ", Telephone=" + telephone +
                ", ComputerOnLoan='" + computerOnLoan + '\'' +
                '}'+Colours.RESET;
    }
}
