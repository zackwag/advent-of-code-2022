package com.zackwag;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.zackwag.advent.model.RockPaperScissors;
import com.zackwag.advent.model.WinLoseOrDraw;
import com.zackwag.advent.utilities.Util;

public class Day2Application {

    public static void main(String[] args) {

        String input = getInput();

        int part1Score = getPart1Score(input);

        int part2score = getPart2Score(input);

        System.out.print(String.format("Part 1 Score is %s. Part 2 score is %s", part1Score, part2score));
    }

    private static int getPart1Score(String input) {

        return getRoundsForPart1(input).stream()
                .map(round -> round.getValue().calculateRound(round.getKey()))
                .collect(Collectors.summingInt(Integer::intValue));
    }

    private static int getPart2Score(String input) {

        return getRoundsForPart2(input).stream()
                .map(round -> round.getValue().calculateRound(round.getKey()))
                .collect(Collectors.summingInt(Integer::intValue));
    }

    private static List<Entry<RockPaperScissors, WinLoseOrDraw>> getRoundsForPart2(String input) {

        return List.of(input.split(System.lineSeparator())).stream()
            .map(roundInput -> {
                String[] roundValues = roundInput.split(" ");
                return Map.entry(RockPaperScissors.forString(roundValues[0]), WinLoseOrDraw.forString(roundValues[1]));
            })
            .collect(Collectors.toList());
    }

    private static List<Entry<RockPaperScissors, RockPaperScissors>> getRoundsForPart1(String input) {

        return List.of(input.split(System.lineSeparator())).stream()
            .map(roundInput -> {
                String[] roundValues = roundInput.split(" ");
                return Map.entry(RockPaperScissors.forString(roundValues[0]), RockPaperScissors.forString(roundValues[1]));
            })
            .collect(Collectors.toList());
    }

    private static String getInput() {
        return Util.readFileToString("src/main/java/com/zackwag/advent/resources/input-day-2.txt");
    }
}
