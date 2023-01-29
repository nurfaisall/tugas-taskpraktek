package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Factorial extends PanacheEntityBase {
    @Id
    @Column(name = "n")
    public Integer n;

    @Column(name = "factorial")
    public Integer factorial;
}
