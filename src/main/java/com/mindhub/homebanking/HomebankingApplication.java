package com.mindhub.homebanking;

import com.mindhub.homebanking.Models.*;
import com.mindhub.homebanking.Models.Client;
import com.mindhub.homebanking.Models.Transaction;
import com.mindhub.homebanking.Models.TransactionType;
import com.mindhub.homebanking.Repositories.*;
import com.mindhub.homebanking.Repositories.ClientRepository;
import com.mindhub.homebanking.Repositories.TransactionRepository;
import com.mindhub.homebanking.Repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	private Client client;

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(CardRepository cardRepository, ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository) {
		return (args) -> {

			Client client1 = new Client("Melba", "Morel", "melba@mindhub.com");
			Client client2 = new Client("Tony", "Stark", "stark@mindhub.com");

			clientRepository.save(client1);
			clientRepository.save(client2);

			Account account1 = new Account("VIN001", LocalDateTime.now(), 5000.00);
			Account account2 = new Account("VIN002", LocalDateTime.now().plusDays(1), 7500.00);
			Account account3 = new Account("VIN003", LocalDateTime.now().minusYears(3), 70500.00);

			client1.addAccount(account1);
			client1.addAccount(account2);
			client2.addAccount(account3);

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);

			Transaction tran1 = new Transaction(TransactionType.CREDIT, 400000.00, "Hipotecario", LocalDateTime.now());
			Transaction tran2 = new Transaction(TransactionType.CREDIT, 50000.00, "Personal", LocalDateTime.now());
			Transaction tran3 = new Transaction(TransactionType.CREDIT, 100000.00, "Personal", LocalDateTime.now().plusDays(1));
			Transaction tran4 = new Transaction(TransactionType.CREDIT, 200000.00, "Automotriz", LocalDateTime.now().plusDays(2));

			account1.addTransaction(tran1);
			account1.addTransaction(tran2);

			account2.addTransaction(tran3);
			account2.addTransaction(tran4);

			transactionRepository.save(tran1);
			transactionRepository.save(tran2);
			transactionRepository.save(tran3);
			transactionRepository.save(tran4);
			cardRepository.save(new Card(client1, "3325-6745-7876-4445", 990, LocalDate.now(), LocalDate.now().plusYears(5), CardType.DEBIT, CardColor.GOLD));
			cardRepository.save(new Card(client1, "2234-6745-5522-7888", 750, LocalDate.now(), LocalDate.now().plusYears(5), CardType.CREDIT, CardColor.SILVER));
			cardRepository.save(new Card(client2, "4546-5169-7821-5597", 154, LocalDate.now(), LocalDate.now().plusYears(5), CardType.CREDIT, CardColor.TITANIUM));

		};
	}
}