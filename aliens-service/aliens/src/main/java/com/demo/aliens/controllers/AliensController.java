package com.demo.aliens.controllers;

import com.demo.aliens.beans.AlienBean;
import com.demo.aliens.model.Alien;
import com.demo.aliens.services.AliensService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/aliens")
@AllArgsConstructor
public class AliensController {

    private final AliensService aliensService;

    @GetMapping
    public ResponseEntity<List<AlienBean>> getAll() {
        return ResponseEntity.ok(aliensService.getAll());
    }

    @PostMapping
    public ResponseEntity<Alien> addAlien(@RequestBody Alien alien) {
        return ResponseEntity.ok(aliensService.addAlien(alien));
    }
}
