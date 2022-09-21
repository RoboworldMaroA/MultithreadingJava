package questionThree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Marek Augustyn
 * TABA
 * 09/01/2022
 */
//class used to manage Customers, this class is using to testing application and includes all methods used in the task 
public class ManageCustomers {
	// static customer array to store data from the file
	static Customer[] customers = new Customer[20];// we have 20 records
	static String filepath = "japanesCustomers.txt";
	static String filepath2 = "MissingCountry.txt";
	// main class to run application 
	public static void main(String[] args) throws FileNotFoundException {

		
		System.out.println("read customers.txt file and print using BufferReader, FileReader");
		readFileCustomer();
		System.out.println("********************************************************************************************");
		
		System.out.println("Read a file customers.txt and add them to database.");
		readFileCustomersAndAddToDatabase();
		
		System.out.println("********************************************************************************************");
        System.out.println("Printing all customers from main file");
		printResutsArray(customers);
		
		
        System.out.println("********************************************************************************************* ");
		System.out.println("Add Customer from Japad to separate file and save on the disk on the name japanesCustomers.txt ");
		saveCustomersWithJapan();
		
		System.out.println("********************************************************************************************* ");
		System.out.println("Find Customers with the missing country add save then as MissingCountry.txt");
		saveCustomersWithMissingCountry();
		
				

	}// end main class

	
	
	
	// method that reads the file line by line and prints the content
	public static void readFileCustomer() {
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(
					new FileReader("C:\\Users\\Maro\\AlgoritmsAndAdvancedPrograming\\TABA/customers.txt")));
			while (s.hasNext()) {
				System.out.println(s.next());

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
    
	
	
	//method to reade the customers data fom a file and add them to the database
	public static void readFileCustomersAndAddToDatabase() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("C:\\Users\\Maro\\AlgoritmsAndAdvancedPrograming\\TABA/customers.txt"));
		sc.nextLine();
		int i = 0;
		String st = "";
		while (sc.hasNextLine()) // returns a boolean value
		{
			st = sc.nextLine();
			String[] data = st.split(",");// split values by ,
			// create film object
			// element on index 1 is a Title
			customers[i] = new Customer(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
			i++;
		}
		sc.close(); // closes the scanner
	}//end method readFile

	
	
	//method used for save customers from Japan
	public static void saveCustomersWithJapan() throws FileNotFoundException {
		
		for(int c=0;c<customers.length;c++ ) {
			if(customers[c].getCountry().equals("Japan")) {
				saveRecord(customers[c].getId(),customers[c].getFname(),customers[c].getLname(),customers[c].getCountry(),customers[c].getEmail(),filepath);
			}
		}
		
	}//end method readFileCustomersAndSaveSelected
	
	
	//method used to save record to the new file customers with missing coutry
	public static void saveCustomersWithMissingCountry() throws FileNotFoundException {
	
		for(int c=0;c<customers.length;c++ ) {
			if(customers[c].getCountry().equals("")) {
				saveRecord(customers[c].getId(),customers[c].getFname(),customers[c].getLname(),customers[c].getCountry(),customers[c].getEmail(),filepath2);
			}
		}
		
	}//end method readFileCustomersAndSaveSelected
	
	
	
	// printing method to print all elements from array Film
	private static void printResutsArray(Customer[] customers) {
		for (int i = 0; i < customers.length; i++) {

			System.out.println(customers[i].toString());
		} // end for loop
	}// end printing



	
	// method saveRecord responsible for save to external file txt
	public static void saveRecord(int id, String fname, String lname, String country, String email, String filepath) {
		try {
			FileWriter fw = new FileWriter(filepath, true);//write data from filepath
			BufferedWriter bw = new BufferedWriter(fw);// buffer them
			PrintWriter pw = new PrintWriter(bw);//write data to the file
			pw.println(id + "," + fname + "," + lname + "," + country + "," + email );
			pw.flush();//method Print Writer to clear the stream 
			pw.close();
			System.out.println("Record saved to the file located in the main folder app TABA");
		} catch (Exception E) {
			System.out.println("Record not saved");
		}
	}
	
	// method saveRecord responsible for save to external file txt
	public static void saveRecordMissingCountry(int id, String fname, String lname, String country, String email, String filepath2) {
		try {
			FileWriter fw = new FileWriter(filepath2, true);//write data from filepath
			BufferedWriter bw = new BufferedWriter(fw);// buffer them
			PrintWriter pw = new PrintWriter(bw);//write data to the file
			pw.println(id + "," + fname + "," + lname + "," + country + "," + email );
			pw.flush();//method Print Writer to clear the stream 
			pw.close();
			System.out.println("Record saved to the file called: MissingCountry.txt located in the main folder app TABA");
		} catch (Exception E) {
			System.out.println("Record not saved");
		}
	}
	
	
	}
