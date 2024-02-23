package com.demo.aliens.services;

import com.demo.aliens.beans.AlienBean;
import com.demo.aliens.exceptions.AlienSystemException;
import com.demo.aliens.model.Alien;
import com.demo.aliens.model.enums.AlienType;
import com.demo.aliens.model.enums.Weapon;
import com.demo.aliens.repositories.AlienRepository;
import com.demo.aliens.validators.AliensValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.demo.aliens.mockData.AliensDataProvider.getAliensList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AliensServiceTest {

    @Mock
    private AlienRepository alienRepository;

    @Mock
    private AliensValidator aliensValidator;

    @InjectMocks
    private AliensService aliensService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {

        List<Alien> aliens = getAliensList();

        when(alienRepository.findAll()).thenReturn(aliens);

        List<AlienBean> alienBeans = aliensService.getAll();

        assertEquals(10, alienBeans.size());
        assertEquals(1L, alienBeans.get(4).getCommanderId());
        assertEquals("alien 3", alienBeans.get(4).getCommanderName());
        assertNull(alienBeans.get(8).getCommanderId());
       assertNull(alienBeans.get(8).getCommanderName());
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


        doNothing().when(aliensValidator).validate(alien);

        when(alienRepository.save(alien)).thenReturn(alien);

        Alien result = aliensService.addAlien(alien);

        assertNotNull(result);
        assertEquals(alien.getId(), result.getId());
        assertEquals(alien.getName(), result.getName());
        assertEquals(alien.getWeapon(), result.getWeapon());
        assertEquals(alien.getCommanderId(), result.getCommanderId());

        verify(aliensValidator, times(1)).validate(alien);

        verify(alienRepository, times(1)).save(alien);
    }

    @Test
    void testAddAlien_ValidationFailure() throws AlienSystemException {

        Alien alien = Alien.builder()
                .id(100)
                .type(AlienType.WARRIOR)
                .name("Warrior 1")
                .weapon(Weapon.PEPPER_SPRAY)
                .build();

        doThrow(AlienSystemException.class).when(aliensValidator).validate(alien);

        assertThrows(AlienSystemException.class, () -> aliensService.addAlien(alien));

        verify(aliensValidator, times(1)).validate(alien);

        verify(alienRepository, never()).save(alien);
    }
}
