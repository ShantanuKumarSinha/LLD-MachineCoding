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

    @Override
    public ParkingSpot chooseSpot(VehicleType vehicleType, Gate gate) throws ParkingSpotFullException {

        parkingSpots = parkingSpotRepository.findAllParkingSpots();

//        parkingSpots.stream().forEach(parkingSpot -> {
//            System.out.println(parkingSpot.getVehicleType().equals(vehicleType));
//            System.out.println(parkingSpot.getParkingFloor().getFloorNumber().equals(gate.getParkingFloor().getFloorNumber()));
//            System.out.println(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE));
//        });

        return parkingSpots.stream().filter(parkingSpot -> parkingSpot.getVehicleType().equals(vehicleType) && parkingSpot.getParkingFloor().getFloorNumber().equals(gate.getParkingFloor().getFloorNumber()) && parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)).findFirst().orElseThrow(ParkingSpotFullException::new);
    }

}
