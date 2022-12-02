package com.zackwag;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.zackwag.advent.utilities.Util;

public class Day1Application {

    public static void main(String[] args) {

        String input = getInput();

        List<Integer> caloriesList = getSortedCaloriesList(input);

        int max = caloriesList.get(0);

        int top3 = max + caloriesList.get(1) + caloriesList.get(2);

        System.out.print(String.format("The largest calories are %s. The sum of the top 3 is %s.", max, top3));
    }

    private static Integer getElfCalorieSum(String elfInput) {

        return Stream.of(elfInput.split(System.lineSeparator()))
                .map(Integer::valueOf)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    private static List<Integer> getSortedCaloriesList(String input) {

        return List.of(input.split(System.lineSeparator() + System.lineSeparator()))
                .stream()
                .map(Day1Application::getElfCalorieSum)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static String getInput() {
        return Util.readFileToString("src/main/java/com/zackwag/advent/utilities/resources/input-day-1.txt");
    }
}
