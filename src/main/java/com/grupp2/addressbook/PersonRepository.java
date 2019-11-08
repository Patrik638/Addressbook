
package com.grupp2.addressbook;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p FROM Person p LEFT JOIN Status s ON p.statId = s.id"
              + " WHERE s.actualStatus = 'active'"
              + " AND p.firstName LIKE :search OR p.lastName LIKE :search OR p.phoneNumber LIKE :search OR p.eMail LIKE :search"
              + " ORDER BY p.lastName, p.firstName")
    List<Person> findAllActivePersonsWherePersons(String search);
    
    @Query(value = "SELECT p FROM Person p LEFT JOIN Status s ON p.statId = s.id"
              + " WHERE s.actualStatus = 'active' ORDER BY p.lastName, p.firstName")
    List<Person> findAllActivePersons();
    
    @Query(value = "SELECT p FROM Person p LEFT JOIN Status s ON p.statId = s.id"
              + " WHERE s.actualStatus = 'inactive' ORDER BY p.lastName, p.firstName")
    List<Person> findAllDeletedPersons();
    
}
