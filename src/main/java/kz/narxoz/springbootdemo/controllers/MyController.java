package kz.narxoz.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required = false, defaultValue = "Name") String name,
                        @RequestParam(name = "surname", required = false, defaultValue = "Surname") String surname,
                        @RequestParam(name = "title", required = false, defaultValue = "Title") String title, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("title", title);
        return "hello";
    }
}