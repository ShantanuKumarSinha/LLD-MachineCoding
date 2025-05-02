package parking.lot.service;

import parking.lot.enums.VehicleType;
import parking.lot.exception.GateNotFoundException;
import parking.lot.exception.InvalidParkingLotException;
import parking.lot.exception.NotAValidSpotStrategyException;
import parking.lot.exception.ParkingSpotFullException;
import parking.lot.model.Ticket;

public interface TicketService {

    public Ticket issueTicket(String vehicleNumber, VehicleType vehicleType, String ownerName, int gateId, long parkingLotId) throws GateNotFoundException, NotAValidSpotStrategyException, InvalidParkingLotException, ParkingSpotFullException;
}
