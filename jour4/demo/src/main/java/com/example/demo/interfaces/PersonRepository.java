package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
  
}
