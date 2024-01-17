package com.serbanscorteanu.ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCountWorker implements Runnable {
    private final WordCountMapper mapper;
    private final File[] files;
    private Map<String, Integer> partialResult;

    public WordCountWorker(WordCountMapper mapper, File[] files) {
        this.mapper = mapper;
        this.files = files;
        this.partialResult = new HashMap<>();
    }

    public Map<String, Integer> getPartialResult() {
        return partialResult;
    }

    @Override
    public void run() {
        for (File file : files) {
            try {
                Map<String, Integer> fileWordCount = mapper.mapFile(file);
                mergePartialResult(fileWordCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void mergePartialResult(Map<String, Integer> fileWordCount) {
        for (Map.Entry<String, Integer> entry : fileWordCount.entrySet()) {
            partialResult.put(entry.getKey(), partialResult.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }
}
