package parking.lot.repository;

import parking.lot.enums.ParkingSpotStatus;
import parking.lot.enums.VehicleType;
import parking.lot.model.ParkingFloor;
import parking.lot.model.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpotRepository {

    private Map<Integer, ParkingSpot> parkingSpots = new HashMap<>();

    public ParkingSpotRepository() {
        // Initialize Parking Floor
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNumber("Ground");

        // Initialize ParkingSpot
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingFloor(parkingFloor);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot.setSpotId(1);
        parkingSpot.setVehicleType(VehicleType.SUV);

        ParkingSpot parkingSpot1 = new ParkingSpot();
        parkingSpot1.setParkingFloor(parkingFloor);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot1.setSpotId(2);
        parkingSpot1.setVehicleType(VehicleType.TWO_WHEELER);

        ParkingSpot parkingSpot2 = new ParkingSpot();
        parkingSpot2.setParkingFloor(parkingFloor);
        parkingSpot2.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot2.setSpotId(3);
        parkingSpot2.setVehicleType(VehicleType.TWO_WHEELER);

        ParkingSpot parkingSpot3 = new ParkingSpot();
        parkingSpot3.setParkingFloor(parkingFloor);
        parkingSpot3.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot3.setSpotId(3);
        parkingSpot3.setVehicleType(VehicleType.TRUCK);

        parkingSpots.put(parkingSpot.getSpotId(), parkingSpot);
        parkingSpots.put(parkingSpot1.getSpotId(), parkingSpot1);
        parkingSpots.put(parkingSpot2.getSpotId(), parkingSpot2);
        parkingSpots.put(parkingSpot3.getSpotId(), parkingSpot3);

    }

    public List<ParkingSpot> findAllParkingSpots() {
        return new ArrayList<>(parkingSpots.values());
    }
}
