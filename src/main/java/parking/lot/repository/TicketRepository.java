package parking.lot.repository;

import parking.lot.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<String, Ticket> tickets = new HashMap<>();


    public Ticket saveTicket(Ticket ticket) {
        return tickets.put(ticket.getTicketNumber(), ticket);
    }
}
