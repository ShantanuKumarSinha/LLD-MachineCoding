package parking.lot;


import parking.lot.controller.TicketController;
import parking.lot.dtos.IssueTicketRequestDTO;
import parking.lot.dtos.IssueTicketResponseDTO;
import parking.lot.enums.VehicleType;
import parking.lot.model.Ticket;
import parking.lot.repository.GateRepository;
import parking.lot.repository.ParkingLotRepository;
import parking.lot.repository.TicketRepository;
import parking.lot.repository.VehicleRepository;
import parking.lot.service.TicketService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        TicketController ticketController = getTicketController();

        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setOwnerName("Shantanu");
        issueTicketRequestDTO.setVehicleNumber("24BH8352F");
        issueTicketRequestDTO.setVehicleType(VehicleType.SUV);
        issueTicketRequestDTO.setParkingLotId(1L);
        issueTicketRequestDTO.setGateId(1);


        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);

        System.out.println(issueTicketResponseDTO.getResponseStatus());

        printTicket(issueTicketResponseDTO.getTicket());

    }

    private static TicketController getTicketController() {
        GateRepository gateRepository = new GateRepository();

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketRepository ticketRepository = new TicketRepository();

        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        return new TicketController(ticketService);
    }

    private static void printTicket(Ticket ticket) throws IOException {
        var fileName = "src/main/resources/Ticket_" + ticket.getTicketNumber() + "_" + ticket.getEntryTime().getTime();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(ticket));
            bufferedWriter.flush();
        }
    }
}