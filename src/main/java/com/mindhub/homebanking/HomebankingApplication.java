package com.mindhub.homebanking;

import com.mindhub.homebanking.Models.*;
import com.mindhub.homebanking.Repositories.*;
import com.mindhub.homebanking.Repositories.LoanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository, CardRepository cardRepository) {
		return (args) -> {
			Client client1 = new Client("melba@mindhub.com", "Melba", "Morel");
			clientRepository.save(client1);
			Client client2 = new Client("espinosa@hotmail.com", "Cris", "Tian");
			clientRepository.save(client2);
			Account account1 = new Account("VIN001", LocalDate.now(), 5000);
			client1.addAccount(account1);
			accountRepository.save(account1);
			Account account2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500);
			client1.addAccount(account2);
			accountRepository.save(account2);
			Account account3 = new Account("VIN003", LocalDate.now().minusDays(2), 6000);
			client2.addAccount(account3);
			accountRepository.save(account3);
			Transaction transaction1 = new Transaction(TransactionType.DEBIT, 1000, "this is only a test part1", LocalDate.now());
			account1.addTransaction(transaction1);
			transactionRepository.save(transaction1);
			Transaction transaction2 = new Transaction(TransactionType.CREDIT, 500, "this is only a test part2", LocalDate.now());
			account1.addTransaction(transaction2);
			transactionRepository.save(transaction2);
			Transaction transaction3 = new Transaction(TransactionType.DEBIT, 1000, "this is only a test part1", LocalDate.now());
			account3.addTransaction(transaction3);
			transactionRepository.save(transaction3);
			Transaction transaction4 = new Transaction(TransactionType.CREDIT, 500, "this is only a test part2", LocalDate.now());
			account3.addTransaction(transaction4);
			transactionRepository.save(transaction4);
			Loan loan1 = new Loan("Hipotecario", 500000, List.of(12, 24, 36, 48, 60));
			loanRepository.save(loan1);
			Loan loan2 = new Loan("Personal", 100000, List.of(6, 12, 24));
			loanRepository.save(loan2);
			Loan loan3 = new Loan("Automotriz", 300000, List.of(6, 12, 24, 36));
			loanRepository.save(loan3);
			ClientLoan clientLoan1 = new ClientLoan(60,400000);
			client1.addLoan(clientLoan1);
			loan1.addClient(clientLoan1);
			clientLoanRepository.save(clientLoan1);
			ClientLoan clientLoan2 = new ClientLoan(12,50000);
			client1.addLoan(clientLoan2);
			loan2.addClient(clientLoan2);
			clientLoanRepository.save(clientLoan2);
			ClientLoan clientLoan3 = new ClientLoan(24,100000);
			client2.addLoan(clientLoan3);
			loan2.addClient(clientLoan3);
			clientLoanRepository.save(clientLoan3);
			ClientLoan clientLoan4 = new ClientLoan(36,200000);
			client2.addLoan(clientLoan4);
			loan3.addClient(clientLoan4);
			clientLoanRepository.save(clientLoan4);
			Card card1 = new Card("Melba Morel", CardType.DEBIT, CardColor.GOLD, "3325-6745-7876-4445", 990, LocalDate.now(),LocalDate.now().plusYears(5));
			client1.addCard(card1);
			cardRepository.save(card1);
			Card card2 = new Card("Melba Morel",CardType.CREDIT,CardColor.TITANIUM,"2234-6745-5525-7888",750,LocalDate.now(),LocalDate.now().plusYears(5));
			client1.addCard(card2);
			cardRepository.save(card2);
		};
	}
}
