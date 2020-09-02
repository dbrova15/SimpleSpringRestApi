package com.example.sarafan.fighting;

import java.util.Random;

public class Person {
    final Random random = new Random();
    int health = 100;
    int attack = 10;

    int block_place;
    int attack_place;

    int id_user;

    public String name;

    public Person() {
        RdmHealth();
        RdmAttack();
    }

    void RdmHealth() {
        int min = 80;
        int max = 120;
        int diff = max - min;
        health = random.nextInt(diff + 1) + min;
    }

    void RdmAttack() {
        int min = 8;
        int max = 15;
        int diff = max - min;
        attack = random.nextInt(diff + 1) + min;
    }

    void Wound(Integer point) {
        health -= point;
        System.out.print(name + " получил урон " + point + " единиц. ");
        System.out.println("Очков жизни осталось " + health);
    }

    void Present() {
        System.out.println("Боец " + name + " с очками здоровья " + health + " и атакой " + attack);
    }

    boolean Alife() {
        if (health > 0) {
            return true;
        } else {
            System.out.println("Боец " + name + " погиб");
            return false;
        }

    }
    public String toString() {
        return "{\"name\": " + this.name + ", \"health\": " + health + ", \"attack\": " + attack + "}";
    }
}
