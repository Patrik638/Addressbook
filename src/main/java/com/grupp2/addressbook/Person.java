
package com.grupp2.addressbook;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "addressbook")
public class Person implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min=1, max=30)
    @Column(name = "firstname")
    private String firstName;

    @NotNull
    @Size(min=1, max=30)
    @Column(name = "lastname")
    private String lastName;

    @NotNull
    @Size(min=5, max=20)
    @Column(name = "phonenumber")
    private String phoneNumber;
    
    @NotNull
    @Email
    @Size(min=5, max=50)
    @Column(name = "email")
    private String eMail;
    
    @Column(name = "statid")
    private int statId;
    
    public Person() {}

    public Person(long id, String firstName, String lastName,
              String phoneNumber, String eMail, int statId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.statId = statId;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getEMail() {
        return eMail;
    }
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }
    
    public int getStatId() {
        return statId;
    }
    public void setStatId(int statId) {
        this.statId = statId;
    }
    
}
