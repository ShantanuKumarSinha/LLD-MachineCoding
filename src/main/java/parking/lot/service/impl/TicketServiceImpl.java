package parking.lot.service.impl;

import parking.lot.enums.TicketStatus;
import parking.lot.enums.VehicleType;
import parking.lot.exception.GateNotFoundException;
import parking.lot.exception.InvalidParkingLotException;
import parking.lot.exception.NotAValidSpotStrategyException;
import parking.lot.exception.ParkingSpotFullException;
import parking.lot.factory.SpotAssignmentFactory;
import parking.lot.model.Ticket;
import parking.lot.repository.GateRepository;
import parking.lot.repository.ParkingLotRepository;
import parking.lot.repository.TicketRepository;
import parking.lot.repository.VehicleRepository;
import parking.lot.service.TicketService;

import java.util.Date;

public class TicketServiceImpl implements TicketService {

    GateRepository gateRepository;
    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;
    TicketRepository ticketRepository;

    public TicketServiceImpl(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    /**
     * Issues a parking ticket for a vehicle.
     *
     * @param vehicleNumber the vehicle number
     * @param vehicleType   the type of vehicle
     * @param ownerName     the name of the vehicle owner
     * @param gateId        the ID of the gate where the vehicle enters
     * @param parkingLotId  the ID of the parking lot
     * @return the issued ticket
     * @throws GateNotFoundException          if the gate is not found
     * @throws NotAValidSpotStrategyException if the spot assignment strategy is not valid
     * @throws InvalidParkingLotException     if the parking lot is invalid
     * @throws ParkingSpotFullException       if there are no available parking spots
     */

    public Ticket issueTicket(String vehicleNumber, VehicleType vehicleType, String ownerName, int gateId, long parkingLotId) throws GateNotFoundException, NotAValidSpotStrategyException, InvalidParkingLotException, ParkingSpotFullException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date(System.currentTimeMillis()));
        var gate = gateRepository.findGateById(gateId).orElseThrow(GateNotFoundException::new);
        ticket.setGeneratedAt(gate);
        var vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber)
                .orElse(vehicleRepository.saveVehicle(vehicleNumber, vehicleType, ownerName));
        ticket.setVehicle(vehicle);
        ticket.setTicketStatus(TicketStatus.VALID);
        ticket.setGeneratedBy(gate.getOperator());
        var parkingLot = parkingLotRepository.findById(parkingLotId).orElseThrow(InvalidParkingLotException::new);
        var spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();
        var spotChoosingStrategy = SpotAssignmentFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);
        var parkingSpot = spotChoosingStrategy.chooseSpot(vehicleType, gate);
        ticket.setParkingSpot(parkingSpot);
        return ticketRepository.saveTicket(ticket);
    }
}
