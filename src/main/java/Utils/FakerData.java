package Utils;

import com.github.javafaker.Faker;

public class FakerData {

	Faker faker = new Faker();

	public String Address() {
		return faker.address().fullAddress();
	}

	public String streetAddress() {
		return faker.address().streetAddress();
	}

	public String city() {
		return faker.address().city();
	}

	public String state() {
		return faker.address().state();
	}

	public String country() {
		return faker.address().country();
	}

	public String zipCode() {
	
		return String.valueOf(faker.number().numberBetween(111111, 999999)); 
	}

	public String countryCode() {
		return faker.address().countryCode();
	}

	public String email() {

		return faker.internet().emailAddress();
	}

	public String safeEmailId() {

		return faker.internet().safeEmailAddress();
	}

	public String phoneNumber() {

		return faker.phoneNumber().phoneNumber().replaceAll("[^a-zA-Z0-9]", "");
	}

	public String cellNumber() {

		return faker.phoneNumber().cellPhone().replaceAll("[^a-zA-Z0-9]", "");
	}

	public String username() {

		return faker.name().username();
	}

	public String password() {

		return faker.internet().password(6, 8);
	}
	
	public String name() {

		return faker.name().firstName();
	}

}
