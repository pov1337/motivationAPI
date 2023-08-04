package ru.tryhard.motivation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tryhard.motivation.DAO.MotivationDAO;
import ru.tryhard.motivation.models.Category;
import ru.tryhard.motivation.models.Favorite;
import ru.tryhard.motivation.models.Motivation;

@Controller
@RequestMapping("/motivation")
public class MotivationController {

    private Motivation motivation_text;

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

    @GetMapping("/favorite")
    public String favorite(Model model){
        model.addAttribute("favorites", motivationDAO.showFavorite());
        return "showFavorite";
    }

    @PostMapping("/{category}")
    public String addFavorite(@ModelAttribute("motivation") Motivation motivation){
        motivationDAO.saveFavorite(motivation);
        return "show";
    }

    @PostMapping("/favorite")
    public String deleteFavorite(@ModelAttribute("favoriteId") int favoriteId){
        motivationDAO.deleteFavorite(favoriteId);
        return "redirect:/motivation/favorite";
    }
}
