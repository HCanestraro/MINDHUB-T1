package com.mindhub.homebanking.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String number;
    private LocalDate date;
    private double balance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Owner_Id")
    private Client owner;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<Transaction> transactions = new HashSet<>();
    public Account() {
    }
    public Account(String number, LocalDate date, double balance) {
        this.number = number;
        this.date = date;
        this.balance = balance;
    }
    public Long getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Client getOwner() {
        return owner;
    }
    public void setOwner(Client owner) {
        this.owner = owner;
    }
    public Set<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
    public void addTransaction(Transaction transaction) {
        transaction.setAccount(this);
        transactions.add(transaction);
    }
}