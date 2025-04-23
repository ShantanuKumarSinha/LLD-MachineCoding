package parking.lot.model;

import parking.lot.enums.ParkingLotStatus;
import parking.lot.enums.SpotAssignmentStrategyType;
import parking.lot.strategy.spot.SpotChoosingStrategy;

import java.util.List;

public class ParkingLot  extends BaseModel{

    private List<ParkingFloor> parkingFloors;

    private ParkingLotStatus parkinglotstatus;

    private List<Gate> gates;

    private ParkingLotManager parkingLotManager;

    private SpotAssignmentStrategyType spotAssignmentStrategyType;

    private String address;

    private int capacity;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingLotManager getParkingLotManager() {
        return parkingLotManager;
    }

    public void setParkingLotManager(ParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }

    public ParkingLotStatus getParkinglotstatus() {
        return parkinglotstatus;
    }

    public void setParkinglotstatus(ParkingLotStatus parkinglotstatus) {
        this.parkinglotstatus = parkinglotstatus;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }
}
