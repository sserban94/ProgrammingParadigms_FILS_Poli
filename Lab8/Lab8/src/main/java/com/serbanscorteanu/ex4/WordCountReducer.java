package com.serbanscorteanu.ex4;

import java.util.HashMap;
import java.util.Map;

public class WordCountReducer {
    public Map<String, Integer> reduce(Map<String, Integer>[] partialResults) {
        Map<String, Integer> aggregateWordCount = new HashMap<>();
        for (Map<String, Integer> partialResult : partialResults) {
            for (Map.Entry<String, Integer> entry : partialResult.entrySet()) {
                aggregateWordCount.put(entry.getKey(), aggregateWordCount.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        return aggregateWordCount;
    }
}
