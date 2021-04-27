package com.mycompany.mavenproject4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customer extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.*[^A-Za-z]){2,})^.*";
    private static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";
    private String address;
    private String name;

    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Customer(String userName, String password, String name, String address) {
        super(userName, password);
        this.name = name;
        this.address = address;

    }

    public static boolean validateEmail(String email) {
        String pattern = VALID_EMAIL_REGEX;

        if (email.matches(pattern)) {
            return true;
        } else
            return false;
    }
    public static boolean validatePassword(String password) {
        String pattern = VALID_PASSWORD_REGEX;

        if (password.matches(pattern)) {
            return true;
        } else
            return false;
    }
}

