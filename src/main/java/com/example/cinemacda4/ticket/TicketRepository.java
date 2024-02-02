package com.example.cinemacda4.ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


    Optional<List<Ticket>> findAllByPlace(int nombrePlacesRestantes);
}
