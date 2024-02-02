package com.example.cinemacda4.ticket;

import com.example.cinemacda4.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {

        this.ticketRepository = ticketRepository;
    }

    //liste des ticker
    public List<Ticket> findAll() {

        return ticketRepository.findAll();
    }
    //sauvegarde données de sceance
    public Ticket save(Ticket ticket) throws BadRequestException {
        verifyTicket(ticket);

        return ticketRepository.save(ticket);
    }

    private void verifyTicket(Ticket ticket) {
    }

    //chercher les ticket via id
    public Ticket findById(Integer id) {
        return ticketRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ticket non trouvé"
                ));
    }

    //supprimer ticket par l'id
    public void deleteById(Integer id) {
        Ticket ticket = this.findById(id);
        ticketRepository.delete(ticket);
    }

    public Ticket update(Ticket ticket) {

        return ticketRepository.save(ticket);
    }

    public Ticket findAllByPlace(int nombrePlacesRestantes) {
        return (Ticket) ticketRepository.findAllByPlace(nombrePlacesRestantes)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "il n'y a plus de ticket disponible "
                ));
    }

}


