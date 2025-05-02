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

    /**
     * Issues a parking ticket for a vehicle.
     *
     * @param issueTicketRequestDTO the request DTO containing vehicle details and parking lot information
     * @return issueTicketResponseDTO containing ticket details and response status
     */
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO) {
        var issueTicketResponseDTO = new IssueTicketResponseDTO();
        try {
            var ticket = ticketService.issueTicket(issueTicketRequestDTO.getVehicleNumber(), issueTicketRequestDTO.getVehicleType(), issueTicketRequestDTO.getOwnerName(), issueTicketRequestDTO.getGateId(), issueTicketRequestDTO.getParkingLotId());
            issueTicketResponseDTO = IssueTicketResponseDTO.from(ticket);
            issueTicketResponseDTO.setResponseStatus(SUCCESS);
        } catch (Exception e) {
            issueTicketResponseDTO.setResponseStatus(FAILURE);
        }

        return issueTicketResponseDTO;
    }
}
