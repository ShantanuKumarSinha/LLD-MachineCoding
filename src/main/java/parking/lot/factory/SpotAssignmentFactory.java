package parking.lot.factory;

import parking.lot.enums.SpotAssignmentStrategyType;
import parking.lot.exception.NotAValidSpotStrategyException;
import parking.lot.strategy.spot.SpotChoosingStrategy;
import parking.lot.strategy.spot.impl.CheapestParkingChoosingStrategy;
import parking.lot.strategy.spot.impl.NearestParkingChoosingStrategy;
import parking.lot.strategy.spot.impl.OptimalParkingChoosingStrategy;
import parking.lot.strategy.spot.impl.PopularParkingChoosingStrategy;

public class SpotAssignmentFactory {

    /**
     * Returns the appropriate SpotChoosingStrategy based on the provided SpotAssignmentStrategyType.
     *
     * @param spotStrategyType the SpotAssignmentStrategyType
     * @return the corresponding SpotChoosingStrategy
     * @throws NotAValidSpotStrategyException if the provided strategy type is not valid
     */
    public static SpotChoosingStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotStrategyType) throws NotAValidSpotStrategyException {
        switch (spotStrategyType) {
            case OPTIMAL -> {
                return new OptimalParkingChoosingStrategy();
            }
            case NEAREST -> {
                return new NearestParkingChoosingStrategy();
            }
            case CHEAPEST -> {
                return new
                        CheapestParkingChoosingStrategy();
            }
            case POPULAR -> {
                return new PopularParkingChoosingStrategy();
            }
            default -> throw new NotAValidSpotStrategyException(spotStrategyType);
        }
    }

}
