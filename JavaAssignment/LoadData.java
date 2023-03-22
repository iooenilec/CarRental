/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaAssignment;

/**
 *
 * @author homew
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class LoadData {
    //Load all car details data function
    public static ArrayList<String> cardetailsdata() {
        //Appending every data in cardetails.txt to an arraylist
        ArrayList<String> cardetailsdata = new ArrayList<String>();
        try {
            //Open new file for the cardetails.txt
            File bookingfile = new File("cardetails.txt");
            //Extract content from the cardetails.txt
            Scanner myReader = new Scanner(bookingfile);
            //Read every line and add into car details data arraylist
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                cardetailsdata.add(data);
            }
            myReader.close();
        //Call error if file is not found.
        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
        }
        //return cardetailsdata arraylist.
        return cardetailsdata;
    }
    

    public static ArrayList<String> customerdata(String selectedid) {
        //Appending every data in csutomerdetails.txt to an arraylist
        ArrayList<String> customerdata = new ArrayList<String>();
        try {
            //Open new file for the csutomerdetails.txt
            File bookingfile = new File("customerdetails.txt");
            //Extract content from the customerdetails.txt
            Scanner myReader = new Scanner(bookingfile);
            //Read every line and add into customer data arraylist
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                customerdata.add(data);
            }
            myReader.close();
        //Call error if file is not found.
        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
        }
        //return customerdata arraylist.
        return customerdata;
    }
    
        public static ArrayList<String> customerdata() {
        //Appending every data in customerdetails.txt to an arraylist
        ArrayList<String> customerdata = new ArrayList<String>();
        try {
            //Open new file for the customerdetails.txt
            File bookingfile = new File("customerdetails.txt");
            //Extract content from the customerdetails.txt
            Scanner myReader = new Scanner(bookingfile);
            //Read every line and add into customer data arraylist
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                customerdata.add(data);
            }
            myReader.close();
        //Call error if file is not found.
        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
        }
        //return customerdata arraylist.
        return customerdata;
    }
    
    public static ArrayList<String> bookingdetails() {
        //Appending every data in bookingdetails.txt to an arraylist
        ArrayList<String> bookingdetails = new ArrayList<String>();
        try {
            //Open new file for the bookingdetails.txt
            File bookingfile = new File("bookingdetails.txt");
            //Extract content from the bookingdetails.txt
            Scanner myReader = new Scanner(bookingfile);
            //Read every line and add into booking data arraylist
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                bookingdetails.add(data);
            }
            myReader.close();
        //Call error if file is not found.
        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
        }
        //return bookingdata arraylist.
        return bookingdetails;
    }
        
    //Load only car details function from all booking data
    public static ArrayList<String> loadbookedcar() {
        //Set new arraylist from data in bookingdetails() arraylist.
        ArrayList<String> bookedcar = bookingdetails();

        //Separate every booking car to another arraylist.
        ArrayList<String> bookedcardata = new ArrayList<String>();
        //Booking car data is contained in every index count 2.
        int index = 2;
        //Store every index count 2 data into the arraylist.
        while (index < bookedcar.size()) {
            bookedcardata.add(bookedcar.get(index));
            index = index + 10;
            if (bookedcar.size() <= index) {
            }
        }
        //return bookedcardata arraylist.
        return bookedcardata;
    }
    
    //Load only booking start date function from all booking data
    public static ArrayList<String> bookedcarstartdate() {
        //Set new arraylist from data in bookingdetails() arraylist.
        ArrayList<String> bookedcar = bookingdetails();

        //Separate every start date to another arraylist
        ArrayList<String> bookingstartdate = new ArrayList<String>();
        //Start date data is contained in every index count 3.
        int index = 3;
        //Store every index count 10 data into the arraylist.
        while (index < bookedcar.size()) {
            bookingstartdate.add(bookedcar.get(index));
            index = index + 10;
            if (bookedcar.size() <= index) {
            }
        }
        //return bookingstartdate arraylist.
        return bookingstartdate;
    }
    
    //Load only booking end date function from all booking data
    public static ArrayList<String> bookedcarenddate() {
        //Set new arraylist from data in bookingdetails() arraylist.
        ArrayList<String> bookedcar = bookingdetails();

        //Separate every end date to another arraylist
        ArrayList<String> bookingenddate = new ArrayList<String>();
        //End date data is contained in every index count 4.
        int index = 4;
        //Store every index count 10 data into the arraylist.
        while (index < bookedcar.size()) {
            bookingenddate.add(bookedcar.get(index));
            index = index + 10;
            if (bookedcar.size() <= index) {
            }
        }
        //return bookingenddate arraylist.
        return bookingenddate;
    }


}

