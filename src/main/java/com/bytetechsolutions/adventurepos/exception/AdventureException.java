package com.bytetechsolutions.adventurepos.exception;

public class AdventureException extends RuntimeException {
    
    public AdventureException () {}

    public AdventureException(Throwable ex) {
        super(ex);
    }

    public AdventureException(String message) {
        super(message);
    }
}
