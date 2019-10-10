package com.sethjava.springdata.service;

import com.sethjava.springdata.model.Person;
import com.sethjava.springdata.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Transactional
    public List<Person> findByName(String name) {
        return personRepository.findByFirstName(name);
    }

    @Transactional
    public Person getById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.get();
    }

    @Transactional
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    @Transactional
    public void deletePersons() {
        personRepository.deleteAll();
    }

    @Transactional
    public boolean addPerson(Person person) {
        return personRepository.save(person) != null;
    }

    @Transactional
    public boolean addPersons(List<Person> persons) {
        return personRepository.saveAll(persons) != null;
    }

    @Transactional
    public boolean updatePerson(Person person) {
        return personRepository.save(person) != null;
    }
}
