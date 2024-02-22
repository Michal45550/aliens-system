package com.demo.aliens.services;

import com.demo.aliens.beans.AlienBean;
import com.demo.aliens.model.Alien;
import com.demo.aliens.model.enums.Weapon;
import com.demo.aliens.repositories.AlienRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AliensService {

    private final AlienRepository alienRepository;

    public List<AlienBean> getAll() {

        List<Alien> aliens = alienRepository.findAll();

        Map<Long, String> aliensNamesMap = aliens.stream().collect(Collectors.toMap(Alien::getId, Alien::getName));

        return aliens.stream().map(alien ->
                AlienBean.builder()
                        .id(alien.getId())
                        .name(alien.getName())
                        .weapon(Optional.ofNullable(alien.getWeapon()).map(Weapon::getValue).orElse(null))
                        .commanderId(alien.getCommanderId())
                        .commanderName(aliensNamesMap.get(alien.getCommanderId()))
                        .build())
                .collect(Collectors.toList());
    }

    public Alien addAlien(Alien alien) {
        return alienRepository.save(alien);
    }

}
