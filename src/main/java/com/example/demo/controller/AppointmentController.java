package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.sql.Timestamp;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {


    @Autowired
    AppointmentRepository repo;

    @GetMapping("/appointment")
    public List<Appointment> getAllAppointments()
    {

        List<Appointment> nou = repo.findAll();
        for (Appointment e:nou) {
            System.out.println(e.getDateOfAppointment());
        }
        return nou;
    }


    @GetMapping("/appointment/{id}")
    public Appointment getAppointmentByID(@PathVariable int id)
    {
        return repo.findById(id).get();
    }


    @GetMapping("/appointment/date/{year}/{month}/{day}/{hour}/{minute}")
    public List<Appointment> getAppointmentsByDate(@PathVariable int year,@PathVariable int month,@PathVariable int day,@PathVariable int hour,@PathVariable int minute){
        Timestamp nou2= new Timestamp(year-1900,month-1,day,hour,minute,0,0);
        System.out.println(nou2);
        return repo.getAppointmentsByDateOfAppointment(nou2);}

    @PostMapping("/appointment/add")
    public void createPerson( @RequestBody Appointment Appointment)
    {
        repo.save(Appointment);
    }

//    @PutMapping("/person/update/{id}")
//    public Person updatePerson(@PathVariable int id, @RequestBody Person person)
//    {
//        Person old = repo.findById(id).get();
//
//
//
//    }

    @DeleteMapping("/appointment/delete/{id}")
    public void deleteAppointment(@PathVariable int id){
        repo.deleteById(id);
    }
}
