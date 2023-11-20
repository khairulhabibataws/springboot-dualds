package com.example.coolapp.service;

import com.example.coolapp.model.Person;
import com.example.coolapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public String getPersonOneName(){
        Person p = personRepository.getReplicaPerson(2L);
        return p.getName();
    }

    public String getPersonName(){
        Person p = personRepository.findById(2L).get();
        return p.getName();
    }

    public Long addPerson(String name){
        Person p = new Person();
        p.setName(name);
        p = personRepository.save(p);
        return p.getId();
    }
}
