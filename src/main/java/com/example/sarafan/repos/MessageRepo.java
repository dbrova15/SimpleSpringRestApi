package com.example.sarafan.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sarafan.domen.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
