package mk.finki.ukim.mk.lab1.service;

import mk.finki.ukim.mk.lab1.model.TicketOrder;

public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);

}

