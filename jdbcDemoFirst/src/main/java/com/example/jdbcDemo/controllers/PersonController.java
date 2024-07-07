package com.example.jdbcDemo.controllers;

import com.example.jdbcDemo.entities.Person;
import com.example.jdbcDemo.repos.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/*
@Controller marks this class as a controller. Controllers in Spring Boot responsible for handling incoming HTTP requests
 and returning an appropriate response. They act as intermediaries between the client and the application’s business logic.
 */
@Controller
/*
@RequiredArgsConstructor creates here a parametrized constructor for all final fields.
 */
@RequiredArgsConstructor
public class PersonController {
    // repository is an object with has methods for CRUD operations
    private final PersonRepository repository;

    /*
    @GetMapping("/people.html") is a mapping for the HTTP GET request to "/people.html".
    When a client sends a GET request to "/people.html", the showPersons method will be called.
     */
    @GetMapping("/people.html")
    public String showPersons(Model model) {
        /*
        The findAll() method retrieves all Person entities from the database.
        It returns an Iterable object, which can be used to iterate over the Person entities.
        The "personList" attribute in the model is mapped to this Iterable,
        allowing the "people.html" template to display the list of persons.
         */
        Iterable<Person> persons = repository.findAll();
        model.addAttribute("personList", persons);
        return "people";
    }

    /*
    @GetMapping("/add.html") is a mapping for the HTTP GET request to the "/add.html" action.
    When a client sends a GET request to "/add.html", the showAddPersonForm method will be called.
    This method returns the "add.html" template, which displays a form for adding a new person.
     */
    @GetMapping("/add.html")
    public String showAddPersonForm() {
        return "add";
    }

    /*
    @PostMapping("/save.html") is a mapping for the HTTP POST request to "/save.html".
    When a client sends a POST request to "/save.html", the savePerson method will be called with the person object as a parameter.
     */
    @PostMapping("/save.html")
    public String savePerson(Person person) {
        repository.save(person);
        return "redirect:/people.html";
    }

    /*
@GetMapping("/delete.html/{id}") is a mapping for the HTTP GET request to "/delete.html/{id}".
When a client sends a GET request to "/delete.html/{id}", the deletePerson method will be called with the person's id as a parameter.
This method will delete the person from the database and redirect the client to the "/people.html" page.
@PathVariable annotation means, that the method gets id value from the request URL ({id} means as parameter name)
 */
    @GetMapping("/delete.html/{id}")
    public String deletePerson(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/people.html";
    }

    /*
    @GetMapping("/edit.html/{id}") is a mapping for the HTTP GET request to "/edit.html/{id}".
    When a client sends a GET request to "/edit.html/{id}", the showEditPersonForm method will be called with the person's id as a parameter.
    This method returns the "update.html" template, which displays a form for editing the person's details.
    @PathVariable annotation means, that the method gets id value from the request URL ({id} means as parameter name)
     */
    @GetMapping("/edit.html/{id}")
    public String showEditPersonForm(@PathVariable int id, Model model) {
        Person person = repository.findById(id).orElseThrow();
        model.addAttribute("person", person);
        return "update";
    }

    /*
    @PostMapping("/update.html/{id}") is a mapping for the HTTP POST request to "/update.html/{id}".
    When a client sends a POST request to "/update.html/{id}", the updatePerson method will be called with the person object as a parameter.
    This method will update the person's details in the database and redirect the client to the "/people.html" page.
    @PathVariable annotation means, that the method gets id value from the request URL ({id} means as parameter name*/
    @PostMapping("/update.html/{id}")
    public String updatePerson(@PathVariable int id, Person person) {
        person.setId(id);
        repository.save(person);
        return "redirect:/people.html";
    }
}
