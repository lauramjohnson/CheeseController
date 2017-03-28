package org.launchcode.models;

import java.util.ArrayList;

/**
 * Created by Laura on 3/27/2017.
 */
public class UserData {
    static ArrayList<User> userList = new ArrayList<>();

    public static ArrayList<User> getAll(){
        return userList;
    }

    public static void add(User newUser){
        userList.add(newUser);
    }

    public static User getById(int id){
        User theUser = null;
        for (User candidateUser : userList){
            if (candidateUser.getUserId()==id){
                theUser = candidateUser;
            }
        }
        return theUser;
    }
}
