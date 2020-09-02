package com.example.sarafan.controller;

import com.example.sarafan.domen.Fighter;
import com.example.sarafan.domen.Message;
import com.example.sarafan.fighting.Person;
import com.example.sarafan.repos.FighterRepo;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fight")
public class FightingControler {
    private final FighterRepo fighterRepo;

    @Autowired
    public FightingControler(FighterRepo fighterRepo) {
        this.fighterRepo = fighterRepo;
    }

    @GetMapping
    public List<Fighter> list() {
        return  fighterRepo.findAll();
    };

    @GetMapping("{id}")
    public Fighter getOne(@PathVariable("id") Fighter fighter) {
        return fighter;
    }

    @PostMapping
    public String create(@RequestBody String jsonString) {
        /*
        Example jsonString

        {"name":"test"}
        */
        Gson g = new Gson();
        Person p = g.fromJson(jsonString, Person.class);
        Fighter f = g.fromJson(p.toString(), Fighter.class);
        try {
            fighterRepo.save(f);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return f.printException(e);
        }
        return f.toString();
    }

    @PutMapping("{id}")
    public Fighter update(@PathVariable("id") Fighter figthterFromDb,
                          @RequestBody Fighter fighter) {

        /*
        Example jsonString

        {
        "id": 16,
        "name": "test",
        "health": 128,
        "attack": 20,
        "victories": null,
        "losses": null
        }

        */
        BeanUtils.copyProperties(fighter, figthterFromDb, "id");
        return fighterRepo.save(figthterFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Fighter jsonString) {
        fighterRepo.delete(jsonString);
    }
}
