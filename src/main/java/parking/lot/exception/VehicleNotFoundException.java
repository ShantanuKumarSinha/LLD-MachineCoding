package parking.lot.exception;

public class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException() {
        super("Vehicle Number Not Found");
    }
}
