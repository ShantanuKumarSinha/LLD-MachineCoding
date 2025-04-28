package parking.lot.repository;

import parking.lot.enums.GateStatus;
import parking.lot.enums.GateType;
import parking.lot.model.Gate;
import parking.lot.model.Operator;
import parking.lot.model.ParkingFloor;

import java.util.*;


public class GateRepository {

    private Map<Integer, Gate> gates = new HashMap<>();

    public GateRepository() {

        // Initialize Operator
        Operator operator1 = new Operator();
        operator1.setId(1);
        operator1.setOperatorName("Operator1");
        operator1.setAge(32);
        operator1.setEmployeeId(2345);

        Operator operator2 = new Operator();
        operator2.setId(2);
        operator2.setOperatorName("Operator2");
        operator2.setAge(21);
        operator2.setEmployeeId(1234);

        Operator operator3 = new Operator();
        operator3.setId(3);
        operator3.setOperatorName("Operator3");
        operator3.setAge(29);
        operator3.setEmployeeId(8733);

        // Initialzie Parking Floor
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNumber("Ground");
        // Intitlaize another parking floor
        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.setFloorNumber("First");

        // Initialize Gate
        Gate gate = new Gate();
        gate.setId(1);
        gate.setGateNumber(1);
        gate.setParkingFloor(parkingFloor);
        gate.setGateType(GateType.ENTRY);
        gate.setGateStatus(GateStatus.OPEN);
        gate.setOperator(operator1);

        Gate gate1 = new Gate();
        gate1.setId(2);
        gate1.setGateNumber(2);
        gate1.setParkingFloor(parkingFloor);
        gate1.setGateType(GateType.EXIT);
        gate.setGateStatus(GateStatus.OPEN);
        gate1.setOperator(operator1);

        gates.put(1, gate);
        gates.put(2, gate);
    }

    public Optional<Gate> findGateById(Integer gateId) {
        return Optional.of(gates.get(gateId)).or(() -> Optional.empty());
    }

    public List<Gate> findAllGates() {
        return new ArrayList<Gate>(gates.values());
    }
}
