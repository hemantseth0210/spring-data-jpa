package com.sethjava;

import com.sethjava.springdata.controller.PersonController;
import com.sethjava.springdata.model.Person;
import com.sethjava.springdata.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sethjava.springdata");
        appContext.refresh();

        PersonController personController = (PersonController) appContext.getBean("personController");

        System.out.println("----Insert one record of person----");
        Person person = new Person(1L, 32, "John", "Doe");
        personController.insertPerson(person);

        System.out.println("----Retrieve one record of person----");
        System.out.println(personController.getUser(1L));

        System.out.println("----Insert multiple records of Person----");
        personController.insertPersons(buildPersons());

        System.out.println("----Retrieve multiple records of person----");
        personController.getAll().forEach(System.out::println);

        System.out.println("Update a person record");
        Person updatePerson = new Person(1L, 32, "John", "Doe1");
        personController.updatePerson(updatePerson);
        System.out.println(personController.getUser(1L));

        System.out.println("----Retrieve one record of person by name----");
        System.out.println(personController.getPersonByName("Richard"));


        System.out.println("Delete a person record");
        personController.deletePerson(1L);
        personController.getAll().forEach(System.out::println);

        System.out.println("Delete all the record");
        personController.deletePersons();
        personController.getAll().forEach(System.out::println);


        appContext.close();
        //System.out.println( "Hello World!" );
    }

    private static List<Person> buildPersons(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(new Random().nextLong(), 21, "Sara", "Nichol"));
        personList.add(new Person(new Random().nextLong(), 28, "Matt", "Daemon"));
        personList.add(new Person(new Random().nextLong(), 45, "Richard", "Brown"));
        personList.add(new Person(new Random().nextLong(), 52, "Claire", "Kendall"));
        personList.add(new Person(new Random().nextLong(), 35, "David", "Dough"));
        return personList;
    }
}
