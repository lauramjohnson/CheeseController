package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;


/**
 * Created by laura on 3/8/2017.
 */

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses);
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
        cheeses.put(cheeseName, description);

        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "delete", method=RequestMethod.GET)
    public String processDeleteCheeseForm(Model model){
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Delete my cheeses");

        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName){
        cheeses.remove(cheeseName);

        // Redirect to /cheese
        return "redirect:";
    }
}
