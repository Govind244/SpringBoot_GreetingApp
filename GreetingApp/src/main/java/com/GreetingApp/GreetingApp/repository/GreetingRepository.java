package com.GreetingApp.GreetingApp.repository;

import com.GreetingApp.GreetingApp.model.GreetingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingMessage, Long> {
}
