package com.github.pendext.image;


import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MaxColorsDeterminator {

    public MaxColorSet determine(List<String> colorsToDetermine) {

        Map<String, Integer> colorCountMap = new HashMap<>();

        for (String color : colorsToDetermine) {
            if (!colorCountMap.containsKey(color)) {
                colorCountMap.put(color, 1);
            } else {
                Integer incrementedCount = colorCountMap.get(color) + 1;
                colorCountMap.put(color, incrementedCount);
            }
        }

        List<String> topThreeColors = colorCountMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                .map(Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());

        MaxColorSet maxColorSet = new MaxColorSet(topThreeColors.get(0), topThreeColors.get(1), topThreeColors.get(2));

        return maxColorSet;
    }

}
