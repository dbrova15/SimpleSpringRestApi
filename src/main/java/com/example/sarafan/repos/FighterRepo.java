package com.example.sarafan.repos;

import com.example.sarafan.domen.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepo extends JpaRepository<Fighter, Long> {
}
