package com.serbanscorteanu.pp.lab6.problemset3;

public class Leetcode374 {
    public int guessNumberIteratively(int n) {
        // looking at constraints
        if (n == 1) {
            return 1;
        }
        if (guess(n) == 0) {
            return n;
        }
        int first = 1;
        int last = n;
        int mid = 0;
        while(first < last) {
            mid = first + (last - first) / 2;
            int aux = guess(mid);

            if(aux == 0){
                return mid;
            } else if (aux == -1){
                last = mid;
            } else {
                first = mid;
            }
        }
        return 0;
    }

    public int guessNumberRecursively(int n) {
        int first = 1;
        int last = n;
        return recursive(first, last, n);
    }

    private int recursive(int first, int last, int n) {
        int mid = first + (last - first) / 2;
        int val = guess(mid);

        if (val == 0) {
            return mid;
        } else if (val < 0) {
            return recursive(first, mid - 1, n);
        } else {
            return recursive(mid + 1, last, n);
        }
    }

    private int guess(int n){
        return 0;
    }

}
