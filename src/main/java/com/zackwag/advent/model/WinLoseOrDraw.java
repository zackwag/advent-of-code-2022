package com.zackwag.advent.model;

import java.util.stream.Stream;

public enum WinLoseOrDraw {

    WIN("Z"),
    LOSE("X"),
    DRAW("Y");

    private final String playerString;

    WinLoseOrDraw(String playerString) {
        this.playerString = playerString;
    }

    public String getPlayerString() {
        return playerString;
    }

    public int calculateRound(RockPaperScissors opponentsPlay) {

        if (this == DRAW) {
            return opponentsPlay.calculateDraw();
        }

        if (this == WIN) {
            for (RockPaperScissors rockPaperScissors : RockPaperScissors.values()) {
                if (rockPaperScissors.getBeats() == opponentsPlay) {
                    return rockPaperScissors.calculateWin();
                }
            }
        }

        return opponentsPlay.getBeats().calculateLoss();
    }

    public static WinLoseOrDraw forString(String string) {

        return Stream.of(values())
                .filter(o -> o.getPlayerString().equalsIgnoreCase(string))
                .findFirst()
                .orElse(null);
    }
}
