package com.serbanscorteanu.pp.lab6.problemset3;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode933 {
    class RecentCounter {
        private Queue<Integer> requestQueue;
        public RecentCounter() {
            this.requestQueue = new LinkedList<>();
        }

        public int ping(int t) {
            this.requestQueue.add(t);
            while (this.requestQueue.peek() < t - 3000) {
                this.requestQueue.poll();
            }
            return requestQueue.size();
        }
    }
}
