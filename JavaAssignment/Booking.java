/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaAssignment;

/**
 *
 * @author homew
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Booking {

    //Booked car function
    public static ArrayList<String> bookedcar(String startdate1, String enddate1) {
        //List out arraylist from booking start and end date arraylist.
        ArrayList<String> bookingstartdate = LoadData.bookedcarstartdate();
        ArrayList<String> bookingenddate = LoadData.bookedcarenddate();

        //Set Date Format
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy/MM/dd");

        //Set date format to string
        Date startdate = null, enddate = null;
        try {
            //Enter date input from the arraylist above.
            startdate = DateFormat.parse(startdate1);
            enddate = DateFormat.parse(enddate1);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "System Error 1");
        }

        //Create new arraylist
        ArrayList<String> index = new ArrayList<String>();

        //Insert booking index where both start and end date that overlaps with another booking's date.
        int count = 0;
        while (count < bookingstartdate.size()) {
            //Set date format to string
            Date bookedstartdate1 = null, bookedenddate1 = null;
            try {
                //Count both start and end date.
                bookedstartdate1 = DateFormat.parse(bookingstartdate.get(count));
                bookedenddate1 = DateFormat.parse(bookingenddate.get(count));
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "System Error");
            }

            //When the duration is not within both start date and end date duration.
            if (startdate.after(bookedenddate1) || enddate.before(bookedstartdate1)) {
            } else {
                index.add(String.valueOf(count));
            }
            count++;
        }

        //List all booked car into an arraylist
        ArrayList<String> car = LoadData.loadbookedcar();

        //Create an arraylist to store all the booked cars
        ArrayList<String> bookedcar = new ArrayList<String>();

        //Set default value
        int count1 = 0;
        //List out all the booked car into the arraylist.
        while (count1 < index.size()) {
            int index1 = Integer.parseInt(index.get(count1));
            bookedcar.add(car.get(index1));
            count1++;
        }
        return bookedcar;
    }

    //Load car details data into table function
    public static void Loadcardetailstable(DefaultTableModel model) {
        //Load car details data from cardetails.txt into the table.
        //Count number of line/data in cardetails.txt
        int line1 = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("cardetails.txt"))) {
            while (reader.readLine() != null) {
                line1++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "System Error");
        }

        //Every 8 data = 1 CAR detail
        int bookings = (line1 / 8);

        //Setting up the string (tempdata) to input all the data which is required for the table
        String tempdata = "";

        //Set number of table rows.
        model.setRowCount(bookings);

        //Insert data to tempdata from cardetails.txt
        File bookingfile = new File("cardetails.txt");
        try {
            Scanner myReader = new Scanner(bookingfile);
            for (int row = 0; row != bookings; row++) {
                for (int i = 0; i != 10; i++) {
                    while (myReader.hasNextLine() && i != 0) {
                        String data = myReader.nextLine();
                        tempdata = tempdata + data + "\n";
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        //Split string tempdata into an array under string eachdata
        String[] eachdata = tempdata.split("\n");

        //Load the array into table
        int i = 0;
        //10 column and row = total number of car bookings
        for (int row = 0; row != bookings; row++) {
            for (int col = 0; col != 8; col++) {
                model.setValueAt(eachdata[i], row, col);
                i++;
            }
        }
    }

    public static void customerdata(DefaultTableModel model) {
        //Load csutomer details data from customerdetails.txt into the table.
        //Count number of line/data in customerdetails.txt
        int line1 = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("customerdetails.txt"))) {
            while (reader.readLine() != null) {
                line1++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "System Error");
        }

        //Every 8 data = 1 Customer
        int bookings = (line1 / 7);

        //Setting up the string (tempdata) to input all the data which is required for the table
        String tempdata = "";

        //Set number of table rows.
        model.setRowCount(bookings);

        //Insert data to tempdata from customerdetails.txt
        File bookingfile = new File("customerdetails.txt");
        try {
            Scanner myReader = new Scanner(bookingfile);
            for (int row = 0; row != bookings; row++) {
                for (int i = 0; i != 9; i++) {
                    while (myReader.hasNextLine() && i != 0) {
                        String data = myReader.nextLine();
                        tempdata = tempdata + data + "\n";
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        //Split string tempdata into an array under string eachdata
        String[] eachdata = tempdata.split("\n");

        //Load the array into table
        int i = 0;
        //7 column and row = total number of customer
        for (int row = 0; row != bookings; row++) {
            for (int col = 0; col != 7; col++) {
                model.setValueAt(eachdata[i], row, col);
                i++;
            }
        }
    }

    public static void bookingdetails(DefaultTableModel model) {
        //Load booking details data from bookingsdetails.txt into the table.
        //Count number of line/data in bookingdetails.txt
        int line1 = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("bookingdetails.txt"))) {
            while (reader.readLine() != null) {
                line1++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "System Error");
        }

        //Every 8 data = 1 CAR booking
        int bookings = (line1 / 10);

        //Setting up the string (tempdata) to input all the data which is required for the table
        String tempdata = "";

        //Set number of table rows.
        model.setRowCount(bookings);

        //Insert data to tempdata from bookingdetails.txt
        File bookingfile = new File("bookingdetails.txt");
        try {
            Scanner myReader = new Scanner(bookingfile);
            for (int row = 0; row != bookings; row++) {
                for (int i = 0; i != 12; i++) {
                    while (myReader.hasNextLine() && i != 0) {
                        String data = myReader.nextLine();
                        tempdata = tempdata + data + "\n";
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        //Split string tempdata into an array under string eachdata
        String[] eachdata = tempdata.split("\n");

        //Load the array into table
        int i = 0;
        //10 column and row = total number of car bookings
        for (int row = 0; row != bookings; row++) {
            for (int col = 0; col != 10; col++) {
                model.setValueAt(eachdata[i], row, col);
                i++;
            }
        }
    }

    public static void customerbookingdetails(DefaultTableModel model) {
        //Load booking details data from bookingsdetails.txt into the table.
        //Count number of line/data in bookingdetails.txt
        int line1 = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("bookingdetails.txt"))) {
            while (reader.readLine() != null) {
                line1++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "System Error");
        }

        //Every 10 data = 1 CAR booking
        int bookings = (line1 / 10);

        //Setting up the string (tempdata) to input all the data which is required for the table
        String tempdata = "";

        //Set number of table rows.
        model.setRowCount(bookings);

        //Insert data to tempdata from bookingdetails.txt
        File bookingfile = new File("bookingdetails.txt");
        try {
            Scanner myReader = new Scanner(bookingfile);
            for (int row = 0; row != bookings; row++) {
                for (int i = 0; i != 12; i++) {
                    while (myReader.hasNextLine() && i != 0) {
                        String data = myReader.nextLine();
                        tempdata = tempdata + data + "\n";
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        //Split string tempdata into an array under string eachdata
        String[] eachdata = tempdata.split("\n");

        //Load the array into table
        int i = 0;
        //10 column and row = total number of car bookings
        for (int row = 0; row != bookings; row++) {
            for (int col = 0; col != 10; col++) {
                model.setValueAt(eachdata[i], row, col);
                i++;
            }
        }
    }

    //Modify car details function
    public static void modifycardetails(String carbrand, String carmodel, String cartype, String carplateno, String seats, 
                                        String carcolour, String fueltype, String priceperday) {

        //Create new string array to store data from car details textbox input
        ArrayList<String> modifydata = new ArrayList<String>();
        modifydata.add(carbrand);
        modifydata.add(carmodel);
        modifydata.add(cartype);
        modifydata.add(carplateno);
        modifydata.add(seats);
        modifydata.add(carcolour);
        modifydata.add(fueltype);
        modifydata.add(priceperday);

        //Insert all car details data into an arraylist
        ArrayList<String> cardetailsdata = LoadData.cardetailsdata();

        //Create new string
        String newdata = "";
        int count = 0;
        //Insert new data by looking through the username index 0.
        while (count < cardetailsdata.size()) {
            if (cardetailsdata.get(count).equals(modifydata.get(0))) {
                for (int i = 0; i != 8; i++) {
                    //Every data line once complete skips to next line with \n
                    newdata = newdata + modifydata.get(i) + "\n";
                    if (i < 7) {
                        count++;
                    }
                }
            } else {
                newdata = newdata + cardetailsdata.get(count) + "\n";
            }
            count++;
        }

        //Rewrite the car details data in cardetails.txt
        File bookingfile1 = new File("cardetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, false);
            bookingfile2.write(newdata);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }
    }

    //add car details function
    public static void addcardetails(String carbrand, String carmodel, String cartype, String carplateno, String seats, 
            String carcolour, String fueltype, String priceperday) {

        //Rewrite the car details data in cardetails.txt
        File bookingfile1 = new File("cardetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, true);
            bookingfile2.write("\n" + carbrand + "\n" + carmodel + "\n" + cartype + "\n" + carplateno + "\n" + seats + "\n" 
                    + carcolour + "\n" + fueltype + "\n" + priceperday);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }
    }

    //add booking details function
    public static void addbookingdetails(String bookingid, String username, String carplateno, String startdate, 
                                         String enddate, String ppd, String totalprice, String cardno, String cvv, String status) {

        //Rewrite the car booking data in bookingdetails.txt
        File bookingfile1 = new File("bookingdetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, true);
            bookingfile2.write("\n" + bookingid + "\n" + username + "\n" + carplateno + "\n" + startdate + "\n" + enddate + 
                    "\n" + ppd + "\n" + totalprice + "\n" + cardno + "\n" + cvv + "\n" + status);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }
    }

    //add customer details function
    public static void addcustomerdetails(String uname, String pass, String name, String citizenship, 
            String ic, String no, String email) {

        //Rewrite the customer data in customerdetails.txt
        File bookingfile1 = new File("customerdetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, true);
            bookingfile2.write("\n" + uname + "\n" + pass + "\n" + name + "\n" + citizenship + "\n" + ic + "\n" +
                    no + "\n" + email);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }
    }

    //Modify Customer Profile
    public static void modifyprofile(String username, String password, String name, String citizenship, String ic, String phoneno, String email) {

        //Create new string array to store data from customer details textbox input
        ArrayList<String> modifydata = new ArrayList<String>();
        modifydata.add(username);
        modifydata.add(password);
        modifydata.add(name);
        modifydata.add(citizenship);
        modifydata.add(ic);
        modifydata.add(phoneno);
        modifydata.add(email);

        //Insert all profile data into an arraylist
        ArrayList<String> profiledata = LoadData.customerdata(username);

        //Create new string
        String newdata = "";
        int count = 0;
        //Insert new data by looking through the username index 0.
        while (count < profiledata.size()) {
            if (profiledata.get(count).equals(modifydata.get(0))) {
                for (int i = 0; i != 7; i++) {
                    //Every data line once complete skips to next line with \n
                    newdata = newdata + modifydata.get(i) + "\n";
                    if (i < 6) {
                        count++;
                    }
                }
            } else {
                newdata = newdata + profiledata.get(count) + "\n";
            }
            count++;
        }

        //Rewrite the csutomer details data in customerdetails.txt
        File bookingfile1 = new File("customerdetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, false);
            bookingfile2.write(newdata);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }
    }

    public static void modifybooking(String bookingid, String username, String carplateno, String startdate, String enddate, String priceperday, String totalprice, String cardno, String cvv, String status) {

        //Create new string array to store data from booking textbox input
        ArrayList<String> modifydata = new ArrayList<String>();
        modifydata.add(bookingid);
        modifydata.add(username);
        modifydata.add(carplateno);
        modifydata.add(startdate);
        modifydata.add(enddate);
        modifydata.add(priceperday);
        modifydata.add(totalprice);
        modifydata.add(cardno);
        modifydata.add(cvv);
        modifydata.add(status);

        //Insert all booking data into an arraylist
        ArrayList<String> bookingdata = LoadData.bookingdetails();

        //Create new string
        String newdata = "";
        int count = 0;
        //Insert new data by looking through the username index 0.
        while (count < bookingdata.size()) {
            if (bookingdata.get(count).equals(modifydata.get(0))) {
                for (int i = 0; i != 10; i++) {
                    //Every data line once complete skips to next line with \n
                    newdata = newdata + modifydata.get(i) + "\n";
                    if (i < 9) {
                        count++;
                    }
                }
            } else {
                newdata = newdata + bookingdata.get(count) + "\n";
            }
            count++;
        }

        //Rewrite the booking data in bookingdetails.txt
        File bookingfile1 = new File("bookingdetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, false);
            bookingfile2.write(newdata);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }
    }

    //Delete car details function
    public static void deletecardetails(String name) {
        //Create new arraylist and insert car data into the arraylist
        ArrayList<String> cardetails = LoadData.cardetailsdata();

        //Create new string and insert all data except the deleted data by looking through the username string
        String newdata = "";
        int count = 0;
        while (count < cardetails.size()) {
            if (cardetails.get(count).equals(name)) {
                count = count + 7;
            } else {
                //Every data line once complete skips to next line with \n
                newdata = newdata + cardetails.get(count) + "\n";
            }
            count++;
        }

        //Rewrite the car data in the cardetails.txt
        File bookingfile1 = new File("cardetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, false);
            bookingfile2.write(newdata);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }
    }

    //Delete booking details function
    public static void deletebookingdetails(String name) {
        //Create new arraylist and insert car booking data into the arraylist
        ArrayList<String> bookingdetails = LoadData.bookingdetails();

        //Create new string and insert all data except the deleted data by looking through the username string
        String newdata = "";
        int count = 0;
        while (count < bookingdetails.size()) {
            if (bookingdetails.get(count).equals(name)) {
                count = count + 9;
            } else {
                //Every data line once complete skips to next line with \n
                newdata = newdata + bookingdetails.get(count) + "\n";
            }
            count++;
        }

        //Rewrite the car booking data in the bookingdetails.txt
        File bookingfile1 = new File("bookingdetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, false);
            bookingfile2.write(newdata);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }
    }

    //Delete customer details function
    public static void deletecustomerdetails(String name) {
        //Create new arraylist and insert customer data into the arraylist
        ArrayList<String> customerdetails = LoadData.customerdata();

        //Create new string and insert all data except the deleted data by looking through the username string
        String newdata = "";
        int count = 0;
        while (count < customerdetails.size()) {
            if (customerdetails.get(count).equals(name)) {
                count = count + 6;
            } else {
                //Every data line once complete skips to next line with \n
                newdata = newdata + customerdetails.get(count) + "\n";
            }
            count++;
        }

        //Rewrite the customer data in the bookingdetails.txt
        File bookingfile1 = new File("customerdetails.txt");
        try {
            FileWriter bookingfile2 = new FileWriter(bookingfile1, false);
            bookingfile2.write(newdata);
            bookingfile2.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "File System Error");
        }

    }

    //Create customer details array
    public static ArrayList<String> customerdetailsarray(String name) {
        //Create new arraylist and insert csutomer data into the arraylist
        ArrayList<String> bookingdetails = LoadData.customerdata();

        ArrayList<String> onecustomerdetail = new ArrayList<String>();

        //Create new string and insert all data except the deleted data by looking through the username string
        String newdata = "";
        int count = 0;
        while (count < bookingdetails.size()) {
            if (bookingdetails.get(count).equals(name)) {
                count = count + 6;
                onecustomerdetail.add(bookingdetails.get(count - 6));
                onecustomerdetail.add(bookingdetails.get(count - 5));

            } else {
                //Every data line once complete skips to next line with \n
                newdata = newdata + bookingdetails.get(count) + "\n";
            }
            count++;
        }

        return onecustomerdetail;

    }
}
