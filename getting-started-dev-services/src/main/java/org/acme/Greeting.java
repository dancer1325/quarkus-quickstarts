package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

//  1 table (Greeting)
//  1 column (name)
@Entity
public class Greeting extends PanacheEntity {
    public String name;
}

// active record pattern
