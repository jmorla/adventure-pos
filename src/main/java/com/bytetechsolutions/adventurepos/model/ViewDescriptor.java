package com.bytetechsolutions.adventurepos.model;


public class ViewDescriptor {

    private String title;

    private String[] stylesheets;

    private String[] scripts;

    private String entrypoint;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStylesheets(String[] stylesheets) {
        this.stylesheets = stylesheets;
    }

    public void setScripts(String[] scripts) {
        this.scripts = scripts;
    }

    public void setEntrypoint(String entrypoint) {
        this.entrypoint = entrypoint;
    }

    public String getTitle() {
        return title;
    }

    public String[] getStylesheets() {
        return stylesheets;
    }

    public String[] getScripts() {
        return scripts;
    }

    public String getEntrypoint() {
        return entrypoint;
    }

}
