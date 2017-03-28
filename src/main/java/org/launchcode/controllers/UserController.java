package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Laura on 3/27/2017.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping(value= "")
    public String displayUserForm(Model model) {
        model.addAttribute("title", "Users!");
        return "user/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model){
        model.addAttribute("title", "Create a user!");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(Model model, User user, String vPassword){
        if (user.getPassword().equals(vPassword)){
            return "redirect:";
        }

        // Redirect to /user/add
        model.addAttribute("title", "Create a user!");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("error", "Your passwords don't match!");
        return "/user/add";
    }
}
