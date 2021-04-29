package com.mycompany.mavenproject4;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Stock {

    private int id;

    private Set<Product> products=new HashSet<>();

    private  String Name;

    public void setName(String name) {
        Name = name;
    }

    @Basic
    public String getName() {
        return Name;
    }

    public Stock(String name) {
        Name = name;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @OneToMany
    @JoinColumn(name = "Raktár_id")
    public  Set<Product> getProducts(){
        return products;
    }


    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
