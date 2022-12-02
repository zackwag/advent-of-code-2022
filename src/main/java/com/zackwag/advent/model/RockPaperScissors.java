package com.zackwag.advent.model;

import java.util.stream.Stream;

public enum RockPaperScissors {

    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    private final String opponentString;
    private final String playerString;
    private final int intValue;

    RockPaperScissors(String opponentString, String playerString, int intValue) {

        this.opponentString = opponentString;
        this.playerString = playerString;
        this.intValue = intValue;
    }

    public String getOpponentString() {
        return opponentString;
    }

    public String getPlayerString() {
        return playerString;
    }

    public int getIntValue() {
        return intValue;
    }

    public RockPaperScissors getBeats() {

        if (this == ROCK) {
            return SCISSORS;
        }

        if (this == PAPER) {
            return ROCK;
        }

        return PAPER;
    }

    public int calculateLoss() {
        return intValue;
    }

    public int calculateDraw() {
        return intValue + 3;
    }

    public int calculateWin() {
        return intValue + 6;
    }

    public int calculateRound(RockPaperScissors opponentPlay) {

        if (this == opponentPlay) {
            return calculateDraw();
        }

        if (opponentPlay == this.getBeats()) {
            return calculateWin();
        }

        return calculateLoss();
    }

    public static RockPaperScissors forString(String string) {

        RockPaperScissors opponentValue = Stream.of(values())
                .filter(o -> o.getOpponentString().equalsIgnoreCase(string))
                .findFirst()
                .orElse(null);

        if (null != opponentValue) {
            return opponentValue;
        }

        return Stream.of(values())
                .filter(o -> o.getPlayerString().equalsIgnoreCase(string))
                .findFirst()
                .orElse(null);
    }
}
