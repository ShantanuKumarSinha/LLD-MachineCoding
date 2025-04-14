package tic.tact.toe.factory;

import tic.tact.toe.enums.BOTDifficulty;
import tic.tact.toe.strategy.bot.BOTPlayingStrategy;
import tic.tact.toe.strategy.bot.impl.EasyBOTPlayingStrategy;
import tic.tact.toe.strategy.bot.impl.HardBOTPlayingStrategy;
import tic.tact.toe.strategy.bot.impl.MediumBOTPlayingStrategy;

public class BOTPlayingStrategyFactory {

    public static BOTPlayingStrategy getBotPlayingStrategy(BOTDifficulty botDifficulty) {
        if (botDifficulty == BOTDifficulty.EASY) {
            return new EasyBOTPlayingStrategy();
        } else if (botDifficulty == BOTDifficulty.MEDIUM) {
            return new MediumBOTPlayingStrategy();
        } else {
            return new HardBOTPlayingStrategy();
        }
    }
}
