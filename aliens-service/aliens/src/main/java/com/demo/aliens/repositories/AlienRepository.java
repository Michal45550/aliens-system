package com.demo.aliens.repositories;

import com.demo.aliens.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepository extends JpaRepository<Alien, Integer> {
}
