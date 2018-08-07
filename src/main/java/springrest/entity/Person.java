package springrest.entity;

public class Person {

	private String firstName;
	private String lastName;
	private Adress adress;
	
	public Person() {
		
	}

	public Person(String firstName, String lastName, Adress adress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	
	
}
