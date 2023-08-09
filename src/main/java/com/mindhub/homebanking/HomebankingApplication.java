package com.mindhub.homebanking;

import com.mindhub.homebanking.Models.Client;
import com.mindhub.homebanking.Models.Account;
import com.mindhub.homebanking.Repositories.ClientRepository;
import com.mindhub.homebanking.Repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(HomebankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository){
		return (args -> {
			Client client1 = new Client();
			client1.setFirstName("Javier");
			client1.setLastName("Miller");
			client1.setEmail("miller@mail.com");

			Client client2 = new Client();
			client2.setFirstName("Melba");
			client2.setLastName("Moler");
			client2.setEmail("melbar@minhub.com");

			Account account1 = new Account();
			account1.setNumber("VIN001");
			account1.setCreationDate(LocalDateTime.now());
			account1.setBalance(5000.0);
			account1.setClient(client2);

			Account account2 = new Account();
			account2.setNumber("VIN002");
			account2.setCreationDate( LocalDateTime.now().plusDays(1));
			account2.setBalance(7500.0);
			account2.setClient(client2);

			Account account3 = new Account();
			account3.setNumber("VIN003");
			account3.setCreationDate( LocalDateTime.now().plusDays(5));
			account3.setBalance(75000.0);
			account3.setClient(client1);

			clientRepository.save(client1);
			clientRepository.save(client2);

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);

		});
	}

}
