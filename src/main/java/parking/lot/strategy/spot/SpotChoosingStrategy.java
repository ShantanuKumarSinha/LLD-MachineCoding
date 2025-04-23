package parking.lot.strategy.spot;

import parking.lot.enums.VehicleType;
import parking.lot.exception.ParkingSpotFullException;
import parking.lot.model.Gate;
import parking.lot.model.ParkingSpot;

public interface SpotChoosingStrategy {

    public ParkingSpot chooseSpot(VehicleType vehicleType, Gate gate) throws ParkingSpotFullException;
}
