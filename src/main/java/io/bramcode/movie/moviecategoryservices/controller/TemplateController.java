package io.bramcode.movie.moviecategoryservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView(@RequestParam(value = "invalid-session", defaultValue = "false") boolean invalidSession,
                               final Model model){

        if(invalidSession){
             model.addAttribute("invalidSession","Session expired please re-login");
        }
        return "login"; //name must be exact the same with the one in templates folder
    }

    @GetMapping("category")
    public String getCategoryView(@RequestParam(value = "message") String messageInfo,
                                  final Model model){
        model.addAttribute("message",messageInfo);
        return "category"; //name must be exact the same with the one in templates folder
    }
}
