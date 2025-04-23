package parking.lot.repository;

import parking.lot.enums.ParkingLotStatus;
import parking.lot.enums.ParkingSpotStatus;
import parking.lot.enums.SpotAssignmentStrategyType;
import parking.lot.enums.VehicleType;
import parking.lot.model.ParkingFloor;
import parking.lot.model.ParkingLot;
import parking.lot.model.ParkingLotManager;
import parking.lot.model.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    private GateRepository gateRepository;


    public ParkingLotRepository() {
        gateRepository = new GateRepository();
        // Initialzie Parking Floor
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNumber("First");
        // Intitlaize another parking floor
        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.setFloorNumber("Ground");
        // Initialize a aprking spot
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingFloor(parkingFloor);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot.setVehicleType(VehicleType.LARGE_VEHICLE);
        parkingSpot.setSpotId(1);

        ParkingSpot parkingSpot1 = new ParkingSpot();
        parkingSpot1.setParkingFloor(parkingFloor);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot1.setVehicleType(VehicleType.TWO_WHEELER);
        parkingSpot1.setSpotId(2);

        ParkingSpot parkingSpot2 = new ParkingSpot();
        parkingSpot2.setParkingFloor(parkingFloor);
        parkingSpot2.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot2.setVehicleType(VehicleType.TWO_WHEELER);
        parkingSpot2.setSpotId(3);

        ParkingSpot parkingSpot3 = new ParkingSpot();
        parkingSpot3.setParkingFloor(parkingFloor);
        parkingSpot3.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot3.setVehicleType(VehicleType.TWO_WHEELER);
        parkingSpot3.setSpotId(3);

        ParkingSpot parkingSpot4 = new ParkingSpot();
        parkingSpot4.setParkingFloor(parkingFloor);
        parkingSpot4.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot4.setVehicleType(VehicleType.SEDAN);
        parkingSpot4.setSpotId(4);

        // Setting up parking spots for parking floor
        parkingFloor.setParkingSpots(List.of(parkingSpot, parkingSpot1, parkingSpot2, parkingSpot3, parkingSpot4));

        ParkingSpot parkingSpot5 = new ParkingSpot();
        parkingSpot5.setParkingFloor(parkingFloor1);
        parkingSpot5.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot5.setVehicleType(VehicleType.SUV);
        parkingSpot5.setSpotId(1);

        ParkingSpot parkingSpot6 = new ParkingSpot();
        parkingSpot5.setParkingFloor(parkingFloor1);
        parkingSpot5.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot5.setVehicleType(VehicleType.SUV);
        parkingSpot5.setSpotId(2);

        // Setting up parking spots for floor1
        parkingFloor1.setParkingSpots(List.of(parkingSpot5, parkingSpot6));

        // Initialize Parking Lot Manager
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        parkingLotManager.setName("Manager1");
        parkingLotManager.setEmployeeId("1234");
        parkingLotManager.setAge(34);

        // Initialize the gates
        var gates = gateRepository.findAllGates().stream().toList();

        // Initialize the parking lot
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCapacity(100);
        parkingLot.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.NEAREST);
        parkingLot.setParkingFloors(List.of(parkingFloor1, parkingFloor));
        parkingLot.setParkingLotManager(parkingLotManager);
        parkingLot.setAddress("Juhu Chowpati");
        parkingLot.setGates(gates);
        parkingLot.setParkinglotstatus(ParkingLotStatus.ACTIVE);

        parkingLots.put(1L, parkingLot);

    }

    public Optional<ParkingLot> findById(long id) {
        return Optional.ofNullable(parkingLots.get(id));
    }
}
