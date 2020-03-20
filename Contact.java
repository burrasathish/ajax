package com.mycompany.app;

import javax.persistence.*;

@Entity
@Table(name = "contact")

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private int phone;
    @Column(name = "mail")
    private String mail;
    @Column(name = "message")
    private String message;

    public int getId() {
        return id;
    }

    public String getName() {
        return firstname;
    }

    public void setName(String firstname) {

        this.firstname = firstname;
    }

    public String getlastName() {
        return lastname;
    }

    public void setlastName(String lastname) {
        this.lastname = lastname;

    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
