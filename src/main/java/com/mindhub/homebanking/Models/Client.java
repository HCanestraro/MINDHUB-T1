package com.mindhub.homebanking.Models;
import javax.persistence.*;
//import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity

public class Client {


//		@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
//	Set<Account> accounts = new HashSet<>();
		//properties
		@Id
//		@GeneratedValue(strategy = GenerationType.AUTO) // Uses an automatic ID generation strategy
		@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
		@GenericGenerator(name = "native", strategy = "native")


		private Long id;
		private String firstName;
		private String lastName;
		private String email;

		//class constructors

		// Parameterless constructor
		public Client() {
			// Default values or common initial values
			this.firstName = "";
			this.lastName = "";
			this.email = "";
		}

		// Constructor with parameters to initialize all attributes
		public Client(String firstName, String lastName, String email) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}
		// Getters and setters for attributes - accessor methods
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

/*	public Set<Account> getAccounts() {
		return accounts;
	}
*/

/*	public void addAccounts(Account account) {
		account.setClient(this);
		accounts.add(account);
	}
*/


}
