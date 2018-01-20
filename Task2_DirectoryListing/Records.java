package menu;

public class Records {
	
	private String firstName;
	private String LastName;
	private String telNumber;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	@Override
	public String toString() {
	    String output = "FirstName = " + getFirstName() + "\tLastName = " + getLastName() +
	        "\tTelNumber = " + getTelNumber() + "\n.......................................................";
	    return output;
	}
	

}
