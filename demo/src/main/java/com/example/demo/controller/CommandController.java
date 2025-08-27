package com.example.demo.controller;

import com.example.demo.service.CommandService;
import com.example.demo.service.PersonService;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommandController {

    @Autowired
    private CommandService commandService;

    @GetMapping("/start")
    public String start() {
            commandService.startCommandLoop();
        return "Готово";
    }
}