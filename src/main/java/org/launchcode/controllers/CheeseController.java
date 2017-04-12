package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Cheeses");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }

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

    @RequestMapping(value="edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model,
                                  @PathVariable int cheeseId){
        Cheese editCheese = CheeseData.getById(cheeseId);
        model.addAttribute("cheese", editCheese);
        model.addAttribute("title","Edit Cheese " + editCheese.getName() + " (id=" + editCheese.getCheeseId() + ")");
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(Model model,
                                  @RequestParam int cheeseId,
                                  @RequestParam String name,
                                  @RequestParam String description,
                                  @RequestParam CheeseType type,
                                  @RequestParam int rating){
        Cheese editCheese = CheeseData.getById(cheeseId);
        editCheese.setName(name);
        editCheese.setDescription(description);
        editCheese.setType(type);
        editCheese.setRating(rating);
        return "redirect:/cheese";
    }
}
