package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by laura on 3/8/2017.
 */

@Controller
@RequestMapping("cheese")
public class CheeseController {



    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheeses");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description){
        Cheese newCheese = new Cheese(cheeseName, description);
        CheeseData.add(newCheese);
        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "delete", method=RequestMethod.GET)
    public String processDeleteCheeseForm(Model model){
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Delete my cheeses");

        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam int[] cheeseIds){

        for (int cheeseId : cheeseIds){
            CheeseData.delete(cheeseId);
        }


        // Redirect to /cheese
        return "redirect:";
    }
}
