package com.mindhub.homebanking.Models;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toList;

@Entity
public class Client {
	//Atributos o propiedades
	@Id
	@GenericGenerator(name= "native", strategy = "native")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;

	@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	private Set<ClientLoan> clientLoans = new HashSet<>();

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Set<Account> accounts = new HashSet<>();

	@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	private Set<Card> cards = new HashSet<>();

	public void addAccount(Account account) {
		account.setClient(this);
		accounts.add(account);
	}

	public void addClient(Card card) {
		card.setClient(this);
		cards.add(card);
	}

	public void addClientLoans(ClientLoan clientLoan){
		clientLoan.setClient(this);
		clientLoans.add(clientLoan);
	}

	//Constructores
	public Client() { }

	public Client(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	//metodos
	public Set<Card> getCards() {
		return cards;
	}
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Account> getAccounts(){
		return accounts;
	}
//	public void addAccount(Account account){
//		account.setClient(this);
//		this.accounts.add(account);
//	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Client{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", accounts=" + accounts +
				", accounts=" + accounts +
				", cards=" + cards +
				'}';
	}
}