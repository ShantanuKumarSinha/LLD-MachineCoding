package parking.lot.exception;

public class GateNotFoundException extends Exception {
    public GateNotFoundException() {
        super("This is not a valid gate Id");
    }
}
