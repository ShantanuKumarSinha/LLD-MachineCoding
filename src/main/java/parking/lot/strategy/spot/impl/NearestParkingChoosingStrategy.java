package parking.lot.strategy.spot.impl;

import parking.lot.enums.ParkingSpotStatus;
import parking.lot.enums.VehicleType;
import parking.lot.exception.ParkingSpotFullException;
import parking.lot.model.Gate;
import parking.lot.model.ParkingSpot;
import parking.lot.repository.ParkingSpotRepository;
import parking.lot.strategy.spot.SpotChoosingStrategy;

import java.util.List;

public class NearestParkingChoosingStrategy implements SpotChoosingStrategy {

    private ParkingSpotRepository parkingSpotRepository;
    private List<ParkingSpot> parkingSpots;

    public NearestParkingChoosingStrategy() {
        parkingSpotRepository = new ParkingSpotRepository();
    }

    /**
     * Chooses a parking spot based on the provided vehicle type and gate.
     *
     * @param vehicleType the type of vehicle
     * @param gate        the gate from which the vehicle is entering
     * @return the chosen parking spot
     * @throws ParkingSpotFullException if no suitable parking spot is available
     */
    @Override
    public ParkingSpot chooseSpot(VehicleType vehicleType, Gate gate) throws ParkingSpotFullException {

        parkingSpots = parkingSpotRepository.findAllParkingSpots();

        return parkingSpots.stream().filter(parkingSpot -> parkingSpot.getVehicleType().equals(vehicleType) && parkingSpot.getParkingFloor().getFloorNumber().equals(gate.getParkingFloor().getFloorNumber()) && parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)).findFirst().orElseThrow(ParkingSpotFullException::new);
    }

}
