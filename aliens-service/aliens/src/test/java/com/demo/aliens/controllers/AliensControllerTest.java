package com.demo.aliens.controllers;

import com.demo.aliens.beans.AlienBean;
import com.demo.aliens.exceptions.AlienSystemException;
import com.demo.aliens.model.Alien;
import com.demo.aliens.model.enums.AlienType;
import com.demo.aliens.model.enums.Weapon;
import com.demo.aliens.services.AliensService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.demo.aliens.mockData.AliensDataProvider.getAliensBeanList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AliensControllerTest {

    @Mock
    private AliensService aliensService;

    @InjectMocks
    private AliensController aliensController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        List<AlienBean> aliens = getAliensBeanList();

        when(aliensService.getAll()).thenReturn(aliens);

        ResponseEntity<List<AlienBean>> response = aliensController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aliens, response.getBody());

        verify(aliensService, times(1)).getAll();
    }

    @Test
    void testAddAlien() throws AlienSystemException {
        Alien alien = Alien.builder()
                .id(100)
                .type(AlienType.WARRIOR)
                .name("Warrior 1")
                .commanderId(5L)
                .weapon(Weapon.PEPPER_SPRAY)
                .build();

        when(aliensService.addAlien(any())).thenReturn(alien);

        ResponseEntity<Alien> response = aliensController.addAlien(alien);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(alien, response.getBody());

        verify(aliensService, times(1)).addAlien(any());
    }
}
