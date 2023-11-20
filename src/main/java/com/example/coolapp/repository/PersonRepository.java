package com.example.coolapp.repository;

import com.example.coolapp.config.ReaderDS;
import com.example.coolapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person,Long> {
    @ReaderDS
    @Query("Select p from Person p where p.id = ?1")
    Person getReplicaPerson(Long id);
}
