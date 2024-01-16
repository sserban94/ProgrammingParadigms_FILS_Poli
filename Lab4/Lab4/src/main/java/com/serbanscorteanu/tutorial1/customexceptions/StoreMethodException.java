package com.serbanscorteanu.tutorial1.customexceptions;

public class StoreMethodException extends Exception {
    public StoreMethodException() {
        super();
    }

    public StoreMethodException(String message) {
        super(message);
    }
}
