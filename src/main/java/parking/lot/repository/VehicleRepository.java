package parking.lot.repository;

import parking.lot.enums.VehicleType;
import parking.lot.model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public VehicleRepository() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("24-BH-2435");
        vehicle.setVehicleType(VehicleType.SUV);
        vehicle.setOwner("Shantanu Kumar");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleNumber("23-BH-2323");
        vehicle1.setVehicleType(VehicleType.TWO_WHEELER);
        vehicle1.setOwner("Shantanu Kumar");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleNumber("BR-30 8832");
        vehicle2.setVehicleType(VehicleType.HATCHBACK);
        vehicle2.setOwner("Ajay Das");

        vehicles.put(vehicle.getVehicleNumber(), vehicle);
        vehicles.put(vehicle1.getVehicleNumber(), vehicle1);
        vehicles.put(vehicle2.getVehicleNumber(), vehicle2);
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        return Optional.ofNullable(vehicles.get(vehicleNumber));
    }

    public Vehicle saveVehicle(String vehicleNumber, VehicleType vehicleType, String owner) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setVehicleType(vehicleType);
        vehicle.setOwner(owner);
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }
}
