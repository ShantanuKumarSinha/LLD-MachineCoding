package parking.lot;


import parking.lot.controller.TicketController;
import parking.lot.dtos.IssueTicketRequestDTO;
import parking.lot.dtos.IssueTicketResponseDTO;
import parking.lot.enums.VehicleType;
import parking.lot.repository.GateRepository;
import parking.lot.repository.ParkingLotRepository;
import parking.lot.repository.TicketRepository;
import parking.lot.repository.VehicleRepository;
import parking.lot.service.TicketService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketRepository ticketRepository = new TicketRepository();

        VehicleRepository vehicleRepository = new VehicleRepository();

        //ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setOwnerName("Shantanu");
        issueTicketRequestDTO.setVehicleNumber("24BH8352F");
        issueTicketRequestDTO.setVehicleType(VehicleType.SUV);
        issueTicketRequestDTO.setParkingLotId(1L);
        issueTicketRequestDTO.setGateId(1);


        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);

        System.out.println(issueTicketResponseDTO.getResponseStatus());

    }
}