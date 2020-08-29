package com.example.sarafan.fighting;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Ring {
        final static Random random = new Random();

        public static void print(String s) {
            System.out.println(s);
        }

        public static void main(String[] args) {

            boolean first_attack;
            Person user = new Person();
            Person enemy = new Person();

            user.name = "User";
            enemy.name = "Enemy";

            user.Present();
            enemy.Present();

            Map<Integer, String> place_dict = new HashMap<Integer, String>();
            place_dict.put(0, "голова");
            place_dict.put(1, "грудь");
            place_dict.put(2, "живот");
            place_dict.put(3, "ноги");

            while (true) {
                if (user.health <= 0 || enemy.health <= 0) {
                    break;
                }

                first_attack = random.nextBoolean();

                Scanner scaner = new Scanner(System.in);

                System.out.println("Ставим блок. 0 - голова, 1 грудь, 2 - живот, 3 - ноги");
                user.block_place = scaner.nextInt();
                System.out.println("Наносим удар. 0 - голова, 1 грудь, 2 - живот, 3 - ноги");
                user.attack_place = scaner.nextInt();

                enemy.block_place = random.nextInt(3);
                enemy.attack_place = random.nextInt(3);

                if (first_attack) {
                    if (!user.Alife() || !enemy.Alife()) {
                        break;
                    } else {
                        print("Враг атакует первым");
                        if (user.block_place != enemy.attack_place) {
                            user.Wound(enemy.attack);
                            print("Ты блокировал " + place_dict.get(user.block_place) + " но враг пробил в " + place_dict.get(enemy.attack_place));
                        } else {
                            print("Враг бил в " + place_dict.get(enemy.attack_place) + " но ты блокировал удар");
                        }
                        if (enemy.block_place != user.attack_place) {
                            if (user.Alife()) {
                                enemy.Wound(user.attack);
                                print("Враг блокировал " + place_dict.get(enemy.block_place) + " но ты пробил в " + place_dict.get(user.attack_place));
                            }
                        } else {
                            print("Ты бил в " + place_dict.get(user.attack_place) + " но враг блокировал удар");
                        }
                    }
                } else {
                    if (!user.Alife() || !enemy.Alife()) {
                        break;
                    } else {
                        print("Ты атакуешь первым");
                        if (enemy.block_place != user.attack_place) {
                            enemy.Wound(user.attack);
                            print("Враг блокировал " + place_dict.get(enemy.block_place) + " но ты пробил в " + place_dict.get(user.attack_place));
                        } else {
                            print("Враг блокировал удар");
                            print("Ты бил в " + place_dict.get(user.attack_place) + " но враг блокировал удар");
                        }
                        if (user.block_place != enemy.attack_place) {
                            if (enemy.Alife()) {
                                user.Wound(enemy.attack);
                                print("Ты блокировал " + place_dict.get(user.block_place) + " но враг пробил в " + place_dict.get(enemy.attack_place));
                            } else {
                                print("Враг бил в " + place_dict.get(enemy.attack_place) + " но ты блокировал удар");
                            }
                        }
                    }
                }

                System.out.println("=============================");
            }

            if (user.Alife() && enemy.Alife()) {
                System.out.println("Ничья");
            } else if (user.Alife()) {
                System.out.println("Roсkee победил");
            } else {
                System.out.println("Kreed победил");
            }
        }

}
