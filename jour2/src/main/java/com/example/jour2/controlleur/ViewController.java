package com.example.jour2.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    @GetMapping("/")
    public String test(Model model) {
        ArrayList<String> listObject = new ArrayList<>();
        listObject.add("Cyril");
        listObject.add("Porez");
        listObject.add("33 ans");

        model.addAttribute("listObjet",listObject);
        return "view";
    }
    @PostMapping("/")
    public String Welcome(String name, Model model) {
        String str = "Bienvenue " + name + " !";
        model.addAttribute("str", str);
        return "view";
    }
}
