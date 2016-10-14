package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String passportNumber;
	
	private String countryOfIssue;
	
	@OneToOne(mappedBy="passport")
	private Customer customer;
	
	public Passport() {
		// TODO Auto-generated constructor stub
	}
	
	public Passport(String passportNumber, String countryofIssue){
		this.passportNumber = passportNumber;
		this.countryOfIssue = countryofIssue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getCountryOfIssue() {
		return countryOfIssue;
	}

	public void setCountryOfIssue(String countryOfIssue) {
		this.countryOfIssue = countryOfIssue;
	}
	
	
}
