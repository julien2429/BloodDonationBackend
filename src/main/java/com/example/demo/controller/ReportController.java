package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.Report;
import com.example.demo.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ReportController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ReportRepository repo;

    @GetMapping("/report")
    public List<Report> getAllReports()
    {
        return repo.findAll();
    }


    @GetMapping("/report/{id}")
    public Report getReportByID(@PathVariable int id)
    {
        return  repo.findById(id).get();
    }


    @PostMapping("/report/add")
    public void createPerson( @RequestBody Report report)
    {
        repo.save(report);
    }

//    @PutMapping("/person/update/{id}")
//    public Person updatePerson(@PathVariable int id, @RequestBody Person person)
//    {
//        Person old = repo.findById(id).get();
//
//
//
//    }

    @DeleteMapping("/report/delete/{id}")
    public void deleteReport(@PathVariable int id){
        repo.deleteById(id);
    }
}
