package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PersonController {

    @Autowired
    PersonRepository repo;


    @GetMapping("/person")
    public  List<Person> getAllPersons()
    {
        return repo.findAll();
    }


    @GetMapping("/person/{id}")
    public  Person getPersonByID(@PathVariable int id)
    {
        return  repo.findById(id).get();
    }

    @GetMapping("/person/{userName}/{password}")
    public  Person getPersonByUserNameAndPassword(@PathVariable String userName,@PathVariable String password)
    {
        return repo.findByUserNameAndPassword(userName,password);
    }

    @PostMapping ("/person/add")
    public void createPerson( @RequestBody Person person)
    {
        repo.save(person);
    }

//    @PutMapping("/person/update/{id}")
//    public Person updatePerson(@PathVariable int id, @RequestBody Person person)
//    {
//        Person old = repo.findById(id).get();
//
//
//
//    }

    @DeleteMapping("/person/delete/{id}")
    public void deletePerson(@PathVariable int id){
        repo.deleteById(id);
    }
}
