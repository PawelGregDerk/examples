package com.example.jdbcDemo.repos;

import com.example.jdbcDemo.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * This interface extends the CrudRepository interface. The CrudRepository provides different sophisticated
 * functionality for the entity class that is being managed.
 * Here we use the CRUD operations for the Person entity only.
 * CRUD is an abbreviation for create, read, update and delete operations with database.
 * The @Repository annotation marks this interface as a Spring Data repository.
 * The Integer primary key is used in the method names, as it is assumed by default.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
