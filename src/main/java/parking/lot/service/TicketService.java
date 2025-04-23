package parking.lot.service;

import parking.lot.enums.TicketStatus;
import parking.lot.enums.VehicleType;
import parking.lot.exception.GateNotFoundException;
import parking.lot.exception.InvalidParkingLotExcpetion;
import parking.lot.exception.NotAValidSpotStrategyException;
import parking.lot.exception.ParkingSpotFullException;
import parking.lot.factory.SpotAssignmentFactory;
import parking.lot.model.Ticket;
import parking.lot.repository.GateRepository;
import parking.lot.repository.ParkingLotRepository;
import parking.lot.repository.TicketRepository;
import parking.lot.repository.VehicleRepository;

import java.util.Date;

public class TicketService {

    GateRepository gateRepository;
    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;
    TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String vehicleNumber, VehicleType vehicleType, String ownerName, int gateId, long parkingLotId) throws GateNotFoundException, NotAValidSpotStrategyException, InvalidParkingLotExcpetion, ParkingSpotFullException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date(System.currentTimeMillis()));
        var gate = gateRepository.findGateById(gateId).orElseThrow(GateNotFoundException::new);
        ticket.setGeneratedAt(gate);
        var vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber)
                .orElse(vehicleRepository.saveVehicle(vehicleNumber, vehicleType, ownerName));
        ticket.setVehicle(vehicle);
        ticket.setTicketStatus(TicketStatus.VALID);
        ticket.setGeneratedBy(gate.getOperator());
        var parkingLot = parkingLotRepository.findById(parkingLotId).orElseThrow(InvalidParkingLotExcpetion::new);
        var spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();
        var spotChoosingStrategy = SpotAssignmentFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);
        var parkingSpot = spotChoosingStrategy.chooseSpot(vehicleType, gate);
        ticket.setParkingSpot(parkingSpot);
        return ticketRepository.saveTicket(ticket);
    }
}
