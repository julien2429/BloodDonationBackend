package com.example.demo.repository;

import com.example.demo.controller.PersonController;
import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByIdUser(int idUser);
    Person findByUserNameAndPassword(String userName, String password);
}
