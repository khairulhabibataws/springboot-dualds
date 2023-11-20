package com.example.coolapp.controller;

import com.example.coolapp.model.Person;
import com.example.coolapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String hello(){
        List<Person> persons = personService.findAll();
        return "Hello World " + persons.size();
    }

    @GetMapping("/person/replica")
    public String getPersonOne(){
        return personService.getPersonOneName();
    }

    @GetMapping("/person")
    public String getPersonName(){
        return personService.getPersonName();
    }


    @PostMapping("/add")
    public String add(@RequestBody String name){
        Long id = personService.addPerson(name);
        return String.valueOf(id);
    }
}
