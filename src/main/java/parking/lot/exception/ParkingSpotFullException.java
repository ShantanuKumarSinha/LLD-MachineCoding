package parking.lot.exception;

public class ParkingSpotFullException extends Exception {

    public ParkingSpotFullException() {
        super("Parking Spot Full");
    }
}
