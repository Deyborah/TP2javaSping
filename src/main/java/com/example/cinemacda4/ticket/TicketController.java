package com.example.cinemacda4.ticket;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TicketController {

    private final TicketService ticketService;

    private final ObjectMapper objectMapper;

    public TicketController(TicketService ticketService, ObjectMapper objectMapper) {
        this.ticketService = ticketService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<Ticket> findAll() {
        return ticketService.findAll().stream().map(
                sceance -> objectMapper.convertValue(sceance, Ticket.class)
        ).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket save(@RequestBody Ticket ticket) {

        return ticketService.save(ticket);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {

        ticketService.deleteById(id);
    }

    @PutMapping
    public Ticket update(@RequestBody Ticket ticket) {

        return ticketService.update(ticket);
    }

    @GetMapping("/search")
    public Ticket findAllById(@RequestParam Integer id) {

        return ticketService.findAllByPlace(id);
    }
    @GetMapping("/{id}") // /films/1
    public Ticket findById(@PathVariable Integer id) {
        Ticket ticket = ticketService.findById(id);

        ticket = new TicketService();
        ticket.setId(ticket.getId());
        ticket.setNomClient(ticket.getNomClient());
        ticket.setNombrePlacesReservés(ticket.getNombrePlacesReservés());
        ticket.setNombrePlacesRestantes(ticket.getNombrePlacesRestantes().stream().map(
                unmappedService -> objectMapper.convertValue(
                        unmappedService, ticketService.class).toList()
        ));


        return ticket;
    }


}



