package org.launchcode.controllers;

/**
 * Created by Laura on 4/3/2017.
 */
public enum CheeseType {
    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    public String getName() {
        return name;
    }

    private final String name;
        CheeseType(String name){
            this.name = name;
        }
}
