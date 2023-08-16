package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.DTO.CardDTO;
import com.mindhub.homebanking.Models.Card;
import com.mindhub.homebanking.Models.CardColor;
import com.mindhub.homebanking.Models.CardType;
import com.mindhub.homebanking.Models.Client;
import com.mindhub.homebanking.Models.ClientLoan;

import com.mindhub.homebanking.Repositories.CardRepository;
import com.mindhub.homebanking.Repositories.ClientRepository;
import com.mindhub.homebanking.Repositories.LoanRepository;
import com.mindhub.homebanking.Repositories.ClientLoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CardRepository cardRepository;
    @PostMapping("/cards/create")
    public ResponseEntity<Object> createCard(@RequestParam CardType type, @RequestParam CardColor color) {

        //Client clientGeneral = clientRepository.findByEmail(authentication.getName());
        Client clientGeneral = clientRepository.findByEmail(clientRepository.getName());

        if (clientGeneral.getCards().stream().filter(e -> e.getType().toString().equals(type.toString())).count() > 2) {
            return new ResponseEntity<>("403 Ya tiene 3 tarjetas de ese tipo", HttpStatus.FORBIDDEN);
        }
    }


 /*       cardRepository.save(new Card(clientGeneral, Utility.getCardNumber(1000,9999), Utility.getRandomNumber(100,999), LocalDate.now(), LocalDate.now().plusYears(5), type, color));
        return new ResponseEntity<>("201 Tarjeta Creada", HttpStatus.CREATED);
    }*/

 /*   @DeleteMapping("/cards/delete/{id}")
    public ResponseEntity<?> deleteCard(Authentication authentication, @PathVariable long id){

        Client client = clientRepository.findByEmail(authentication.getName());
        if(cardRepository.findById(id) == null){
            return new ResponseEntity<>("Tarjeta inexistente", HttpStatus.FORBIDDEN);
        }

        if (!client.getCards().contains(cardRepository.findById(id))){
            return new ResponseEntity<>("Tarjeta no pertenece al cliente", HttpStatus.FORBIDDEN);
        }

        cardRepository.delete(cardRepository.findById(id));

        return new ResponseEntity<>("Tarjeta eliminada correctamente", HttpStatus.ACCEPTED);

    }*/

   public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public CardRepository getCardRepository() {
        return cardRepository;
    }

    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
}
