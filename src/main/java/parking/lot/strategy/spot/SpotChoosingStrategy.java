package parking.lot.strategy.spot;

import parking.lot.enums.VehicleType;
import parking.lot.exception.ParkingSpotFullException;
import parking.lot.model.Gate;
import parking.lot.model.ParkingSpot;

public interface SpotChoosingStrategy {

    /**
     * Chooses a parking spot based on the provided vehicle type and gate.
     *
     * @param vehicleType the type of vehicle
     * @param gate        the gate from which the vehicle is entering
     * @return the chosen parking spot
     * @throws ParkingSpotFullException if no suitable parking spot is available
     */

    public ParkingSpot chooseSpot(VehicleType vehicleType, Gate gate) throws ParkingSpotFullException;
}
