package com.sethjava.springdata.controller;

import com.sethjava.springdata.model.Person;
import com.sethjava.springdata.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public @ResponseBody Person getUser(@PathVariable Long id) {
        return personService.getById(id);
    }

    @RequestMapping(value = "/personByName/{name}", method = RequestMethod.GET)
    public List<Person> getPersonByName(@PathVariable String name) {
        return personService.findByName(name);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getAll() {
        return personService.getAllPersons();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public HttpStatus deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.DELETE)
    public HttpStatus deletePersons() {
        personService.deletePersons();
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public HttpStatus insertPerson(@RequestBody Person person) {
        return personService.addPerson(person) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public HttpStatus insertPersons(@RequestBody List<Person> persons) {
        return personService.addPersons(persons) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public HttpStatus updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }
}
