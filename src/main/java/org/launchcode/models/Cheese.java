package org.launchcode.models;

import org.launchcode.controllers.CheeseType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by laura on 3/12/2017.
 */
public class Cheese {
    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "There must be a description")
    private String description;
    private CheeseType type;

    private int cheeseId;
    private static int nextId = 1;

    public int getCheeseId() {
        return cheeseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cheese(){
        cheeseId = nextId;
        nextId++;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }
}
