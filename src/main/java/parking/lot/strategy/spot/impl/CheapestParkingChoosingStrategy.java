package parking.lot.strategy.spot.impl;

import parking.lot.enums.VehicleType;
import parking.lot.model.Gate;
import parking.lot.model.ParkingFloor;
import parking.lot.model.ParkingSpot;
import parking.lot.strategy.spot.SpotChoosingStrategy;

public class CheapestParkingChoosingStrategy implements SpotChoosingStrategy {

    @Override
    public ParkingSpot chooseSpot(VehicleType vehicleType, Gate gate) {
        return null;
    }
}
