package parking.lot.repository;

import parking.lot.model.Ticket;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Integer, Ticket> tickets = new HashMap<>();


    public Ticket saveTicket(Ticket ticket) {
        var ticketNumber = new SecureRandom().nextInt(Integer.MAX_VALUE);
        ticket.setTicketNumber(ticketNumber);
        tickets.put(ticketNumber, ticket);
        return tickets.get(ticketNumber);
    }

}
