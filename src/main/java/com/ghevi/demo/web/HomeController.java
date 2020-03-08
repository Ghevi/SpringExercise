package com.ghevi.demo.web;

import com.ghevi.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("formData", new User());
        return "index";
    }

    //Insert data submitted in the form to the database
    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String processFormData(User user, RedirectAttributes attr){
        attr.addFlashAttribute("user", user);
        return "redirect:/display";
    }

    @RequestMapping(value="/display", method = RequestMethod.GET)
    public String displayFormData(User user){
        return "result";
    }
}
