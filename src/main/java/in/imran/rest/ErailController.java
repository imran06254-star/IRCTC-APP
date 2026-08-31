package in.imran.rest;

import in.imran.request.Passanger;
import in.imran.response.Ticket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Random;

@RestController
public class ErailController {

    private final HashMap<Integer, Ticket> tickets = new HashMap<>();

    @PostMapping(
            value = "/ticket",
            consumes = {"application/json","application/xml"},
            produces = {"application/json","application/xml"}
    )
    public Ticket bookTicket(@RequestBody Passanger passanger) {

        Random random = new Random();
        int ticketId = random.nextInt(100000000);


        Ticket ticket = new Ticket();

        ticket.setTicketId(ticketId);
        ticket.setTicketStatus("Confirmed");
        ticket.setFrom(passanger.getFrom());
        ticket.setTo(passanger.getTo());
        ticket.setTrainNum(passanger.getTrainNum());
        ticket.setTktCost("500.00 INR");

        tickets.put(ticketId, ticket);

        return ticket;
    }

    @GetMapping(
            value = "/ticket/{ticketId}",
            produces = {"application/json","application/xml"}
    )
    public Ticket getTicket(@PathVariable Integer ticketId) {
        if(tickets.containsKey(ticketId)){

            return tickets.get(ticketId);
        }
        return null;
    }

}