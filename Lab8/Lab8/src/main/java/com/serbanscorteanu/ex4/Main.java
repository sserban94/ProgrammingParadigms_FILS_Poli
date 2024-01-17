package com.serbanscorteanu.ex4;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        File[] files = new File("C:\\Programming\\FILS\\PP\\ProgrammingParadigms_FILS_Poli\\Lab8\\Lab8\\src\\main\\java\\com\\serbanscorteanu\\ex4\\textFiles").listFiles();
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        WordCountMapper mapper = new WordCountMapper();
        WordCountReducer reducer = new WordCountReducer();
        WordCountWorker[] workers = new WordCountWorker[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startIndex = 0;
            if (files != null) {
                startIndex = i * (files.length / numThreads);
                int endIndex = (i == numThreads - 1) ? files.length : (i + 1) * (files.length / numThreads);
                workers[i] = new WordCountWorker(mapper, Arrays.copyOfRange(files, startIndex, endIndex));
                executorService.submit(workers[i]);
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        Map<String, Integer>[] partialResults = new HashMap[numThreads];
        for (int i = 0; i < numThreads; i++) {
            partialResults[i] = workers[i].getPartialResult();
        }

        Map<String, Integer> aggregateWordCount = reducer.reduce(partialResults);

        // Print the result
        for (Map.Entry<String, Integer> entry : aggregateWordCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
