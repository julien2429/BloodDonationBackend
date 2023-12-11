package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {


    @Autowired
    AppointmentRepository repo;

    @Autowired
    PersonRepository personRepository;


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

    @GetMapping("/appointment/date/today/{year}/{month}/{day}")
    public List<Appointment> getAppointmentsByDateOfDay(@PathVariable int year,@PathVariable int month,@PathVariable int day) {
        java.sql.Date fake_date= new java.sql.Date(year-1900,month-1,day);
        List<Appointment> nou= repo.findAll();
        List<Appointment> answer = new ArrayList<>();
        for (Appointment e:nou) {
            if(e.getDateOfAppointment().toString().substring(0, 10).equals(fake_date.toString()))
            {
                answer.add(e);
            }
        }
        return answer;
    }

    @GetMapping("/appointment/notfilled")
    public List<Appointment> getAppointmentNotfilled()
    {
         List<Appointment> nou= repo.findAll();

        List<Appointment> answer = new ArrayList<>();

        for (Appointment e:nou) {
            if(e.getReport()==null)
            {
                answer.add(e);
            }
        }
        return answer;

    }





    @PostMapping("/appointment/add/{personID}")
    public void createAppointment( @RequestBody Appointment appointment,@PathVariable int personID)
    {
        PersonRepository repo_2 = personRepository;
        Appointment nou = appointment;
        nou.setPerson( repo_2.findByIdUser(personID) );
        nou.setReport(null);
        repo.save(appointment);
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
