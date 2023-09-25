package com.example.demo.controller;

import java.util.*;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interfaces.PersonRepository;
import com.example.demo.model.Person;





@Controller
public class PersonController {

  @Autowired
  PersonRepository repo;

  public void createPerson(String name, int age) {
    Person person = new Person(name, age);
    repo.save(person);
  }

  @GetMapping("/user")
  public String getUsers(Model model) {
    List<Person> persons = repo.findAll();
    if (persons.size() == 0) {
      createPerson("Cyril", 33);
      createPerson("Thibault the king", 21);
      createPerson("ibra 13", 22);     
    }
    
    model.addAttribute("persons", persons);
    return "user";
  } 

  @PostMapping("/update")
  
  public String updateUsers(@RequestParam("id") int id,
    @RequestParam("name") String name,
    @RequestParam("age") int age) {

    Person person = repo.findById(id).get();
    person.setName(name);
    // person.setAge(age);
    repo.save(person);
    
    return "redirect:/user";
  }


  @PostMapping("/delete")
  public String deleteUser(@RequestParam("id") int id) {
    repo.deleteById(id);
    return "redirect:/user";
  }
}