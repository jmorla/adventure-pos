package com.bytetechsolutions.adventurepos.exception;

public class AdventureException extends RuntimeException {

    private final String summary;
    private final String details;
    
    public AdventureException() {
        summary = "Error inesperado";
        details = "Ocurrió un error inesperado. Por favor, contacte al soporte si el problema persiste.";
    }

    public AdventureException(Throwable ex) {
        super(ex);
        this.summary = ex.getMessage();
        this.details = null;
    }

    public AdventureException(String summary, String details) {
        super(details);
        this.summary = summary;
        this.details = details;
    }

    public String getSummary() {
        return summary;
    }

    public String getDetails() {
        return details;
    }
}
