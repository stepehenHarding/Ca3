package com.dkit.gd2.stephenharding;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentDB
{
    private ArrayList<Student> student;
    private static Scanner keyboard = new Scanner(System.in);
    public StudentDB(){this.student = new ArrayList<>();}

    protected void loadStudentFromFile()
    {
        try(Scanner StudentFile = new Scanner (new BufferedReader(new FileReader("students.txt"))))
        {
            String input;
            while(StudentFile.hasNextLine())
            {
                input = StudentFile.nextLine();
                String[] data = input.split(",");
                String name = data[0];
                String ID = data[1];
                String eMail = data[2];
                int telephone = Integer.parseInt(data[3]);
                String computerOnLoan = data[4];


                Student readInStudent = new Student(name,ID,eMail,telephone,computerOnLoan);
                this.student.add(readInStudent);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not find students.txt file");
        }
    }

    public void saveStudentToFile(){
        try(BufferedWriter studentFile = new BufferedWriter(new FileWriter("students.txt")))
        {
            for (Student student: student)
            {
                studentFile.write(student.getName()+","+student.getID()+","+student.geteMail()+","+student.getTelephone()+","+student.getComputerOnLoan());
                studentFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Could not save Desktops to file");
        }
    }

    public void addStudent()
    {
        String name = enterField("name");
        String ID = enterField("ID");
        String email = enterField("eMail");
        int telephone = loopUntilValidInt("telephone");

        Student s = new Student(name,ID,email,telephone,"not renting");

        if(this.student !=null)
        {
            if(s != null)
            {
                student.add(s);
            }
            else
            {
                System.out.println("student could not be found");
            }
        }
        saveStudentToFile();
    }

    private String enterField(String field)
    {
        String input;
        System.out.println("Please enter Students "+field+":");
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
                if(intField.equals("telephone"))
                {
                    int telephone = Integer.parseInt(enterField(intField));
                    return telephone;
                }
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Please enter a valid Phone Number");
            }
        }
        return -1;
    }

    public void deleteStudent()
    {
        if(this.student !=null )
        {
            String studentToDelete= enterField("desktopToDelete");
            Student studentToRemove= findStudent(studentToDelete);
            if(studentToRemove != null)
            {
                student.remove(studentToRemove);
            }
            else
            {
                System.out.println("student could not be found");
            }
        }
    }

    private Student findStudent(String studentToDelete)
    {
        for(Student student: student)
        {
            if(student.getID().equals(studentToDelete))
            {
                return student;
            }
        }
        return null;
    }

    public void printStudent()
    {
        String studentIDToPrint = enterField("StudentID to print");
        Student studentToPrint = findStudent(studentIDToPrint);
        if(studentToPrint != null)
        {
            System.out.println(studentToPrint);
        }
        else
        {
            System.out.println("that student does not exist");
        }
    }

   public void printAllStudents()
   {
        for(int i=0;i<student.size();i++)
        {
            System.out.println(student.get(i));
        }

   }

//   public class printAlphabetically implements Comparator<Student>
//   {
//       public int Compare(Student student1,Student student2)
//       {
//           return student1.getID().compareTo(student2.getID());
//       }
//   }

}

