package ru.tryhard.motivation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tryhard.motivation.DAO.MotivationDAO;

@Controller
@RequestMapping("/motivation")
public class MotivationController {

    private MotivationDAO motivationDAO;

    @Autowired
    public MotivationController(MotivationDAO motivationDAO){
        this.motivationDAO = motivationDAO;
    }


    @GetMapping("/{category}")
    public String show( @PathVariable("category") int category, Model model){
        model.addAttribute("motivation", motivationDAO.show(category));
        return "show";
    }

        @GetMapping("/categories")
    public String showCategory(Model model){
        model.addAttribute("categories", motivationDAO.showCategory());
        return "showCategory";
    }
}
