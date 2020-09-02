package com.example.sarafan.domen;

import com.example.sarafan.fighting.Person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String name;
    private Long health;
    private Long attack;
    private Long victories;
    private Long losses;

//    public Fighter {
//        Person user = new Person();
//        setHealth(user.health);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getAttack() {
        return attack;
    }

    public void setAttack(Long attack) {
        this.attack = attack;
    }

    public Long getVictories() {
        return victories;
    }

    public void setVictories(Long victories) {
        this.victories = victories;
    }

    public Long getLosses() {
        return losses;
    }

    public void setLosses(Long losses) {
        this.losses = losses;
    }

    public String printException(Exception e) {
        return "Exception: " + e;
    }

    public String toString() {
        return "{ \"name\": " + name + ", \"health\": " + health + "\"" + ", \"attack\": " + attack + ", \"victories: " + victories + ", \"losses\": " + losses + "}";
    }
}
