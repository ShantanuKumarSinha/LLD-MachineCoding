package parking.lot.controller;

import parking.lot.dtos.IssueTicketRequestDTO;
import parking.lot.dtos.IssueTicketResponseDTO;
import parking.lot.service.TicketService;

import static parking.lot.dtos.ResponseStatus.FAILURE;
import static parking.lot.dtos.ResponseStatus.SUCCESS;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO) {
        IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();
        try {
            var ticket = ticketService.issueTicket(issueTicketRequestDTO.getVehicleNumber(), issueTicketRequestDTO.getVehicleType(), issueTicketRequestDTO.getOwnerName(), issueTicketRequestDTO.getGateId(), issueTicketRequestDTO.getParkingLotId());
            issueTicketResponseDTO.setTicket(ticket);
            issueTicketResponseDTO.setResponseStatus(SUCCESS);
        } catch (Exception e) {
            issueTicketResponseDTO.setResponseStatus(FAILURE);
        }

        return issueTicketResponseDTO;
    }
}
