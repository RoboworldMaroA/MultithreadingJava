package questionThree;
/*
 * Marek Augustyn
 * Advanced Programming - TABA
 * 09/01/2022
 */
//class used for adding new customers and read a data inside the database
public class Customer implements Comparable<Object>{
	//variable
	private int id;
	private String fname;
	private String lname;
	private String country;
	private String email;
	
	
	//constructor
	public Customer(int id, String fname, String lname, String country, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.country = country;
		this.email = email;
	}

	//setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// so the film objects can be compared when sorting/searching
	// NOTE: this will only allow comparisons based on the title of the film
		
		 @Override 
		 public int compareTo(Object obj) { 
			 Customer name = (Customer)obj;
			 return
		     fname.compareTo(name.getCountry()); 
			 }
		 
        //to string method
		@Override
		public String toString() {
			return "Customer [CustomerID=" + id + ", First Name=" + fname + ", Last Name=" + lname + ", Country="+ country + ", Email=" + email+"]";
		}

}
