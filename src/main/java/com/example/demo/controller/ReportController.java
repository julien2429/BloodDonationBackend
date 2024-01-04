package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Person;
import com.example.demo.entity.Report;
import com.example.demo.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ReportController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ReportRepository repo;
    @Autowired
    AppointmentController repo2;
    @Autowired
    PersonController repo3;

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


    @PostMapping("/report/add/{idAppointment}")
    public void createReport( @RequestBody Report report,@PathVariable int idAppointment)
    {
        report.setIdAppointment(idAppointment);
        Appointment app = repo2.getAppointmentByID(idAppointment);
        Person pers = app.getPerson();
        app.setReport(report);
        report.setPatient(pers);
        report.setAppointment(app);

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
