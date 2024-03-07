package empPkg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class Address {
	// Attributes
	@Column(name = "street_name")
	private String street;
	@Column(name = "city_name")
	private String city;
	@Column(name = "state_name")
	private String state;
	@Column(name = "zip_code")
	private String zip;
	
	// Constructor
	public Address() {
	}
	
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	// Getters and setters
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
}
