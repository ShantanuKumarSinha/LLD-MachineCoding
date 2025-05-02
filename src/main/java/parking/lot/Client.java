package parking.lot;


import parking.lot.controller.TicketController;
import parking.lot.dtos.IssueTicketRequestDTO;
import parking.lot.dtos.IssueTicketResponseDTO;
import parking.lot.dtos.ResponseStatus;
import parking.lot.enums.VehicleType;
import parking.lot.repository.GateRepository;
import parking.lot.repository.ParkingLotRepository;
import parking.lot.repository.TicketRepository;
import parking.lot.repository.VehicleRepository;
import parking.lot.service.TicketService;
import parking.lot.service.impl.TicketServiceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Client {
    /**
     * Main method to issue a parking ticket and print the ticket details.
     *
     * @param args command line arguments
     * @throws IOException if an I/O error occurs
     */

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
        if (issueTicketResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS))
            printTicket(issueTicketResponseDTO);

    }

    /**
     * Creates and returns a TicketController instance with its dependencies.
     *
     * @return a TicketController instance
     */
    private static TicketController getTicketController() {
        GateRepository gateRepository = new GateRepository();

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketRepository ticketRepository = new TicketRepository();

        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketServiceImpl(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        return new TicketController(ticketService);
    }

    /**
     * Prints the ticket details to a file.
     *
     * @param issueTicketResponseDTO the ticket response DTO
     * @throws IOException if an I/O error occurs
     */
    private static void printTicket(IssueTicketResponseDTO issueTicketResponseDTO) throws IOException {
        var fileName = "src/main/resources/Ticket_" + issueTicketResponseDTO.getTicketNumber() + "_" + issueTicketResponseDTO.getEntryTime().getTime();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(issueTicketResponseDTO));
            bufferedWriter.flush();
        }
    }
}