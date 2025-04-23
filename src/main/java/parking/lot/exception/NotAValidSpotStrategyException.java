package parking.lot.exception;

import parking.lot.enums.SpotAssignmentStrategyType;

public class NotAValidSpotStrategyException extends Exception {
    public NotAValidSpotStrategyException(SpotAssignmentStrategyType strategy) {
        super("Not a Valid " + strategy);
    }
}
