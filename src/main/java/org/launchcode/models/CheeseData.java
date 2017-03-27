package org.launchcode.models;

import java.util.ArrayList;

/**
 * Created by laura on 3/26/2017.
 */
public class CheeseData {
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // get all
    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }

    // add
    public static void add(Cheese newCheese){
        cheeses.add(newCheese);
    }

    // delete
    public static void delete(int id){
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    // get by id
    public static Cheese getById(int id){
        Cheese theCheese = null;

        for (Cheese candidateCheese : cheeses){
            if(candidateCheese.getCheeseId() == id){
                theCheese = candidateCheese;
            }
        }
        return theCheese;
    }
}
