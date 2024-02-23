package com.demo.aliens.validators;

import com.demo.aliens.exceptions.AlienSystemException;
import com.demo.aliens.exceptions.AlienErrMsg;
import com.demo.aliens.model.Alien;
import com.demo.aliens.model.enums.AlienType;
import com.demo.aliens.model.enums.Vehicle;
import com.demo.aliens.model.enums.Weapon;
import com.demo.aliens.repositories.AlienRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.demo.aliens.mockData.AliensDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class AliensValidatorTest {

    @Mock
    private AlienRepository alienRepository;

    @InjectMocks
    private AliensValidator aliensValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(alienRepository.findAll()).thenReturn(getAliensList());
    }

    @Test
    void validateWarrior_Valid() throws AlienSystemException {
        aliensValidator.validate(
                Alien.builder()
                        .id(100)
                        .type(AlienType.WARRIOR)
                        .name("Warrior 1")
                        .commanderId(5L)
                        .weapon(Weapon.PEPPER_SPRAY)
                        .build()
        );
    }

    @Test
    void validateWarrior_NOT_NULL_COMMANDER_ID() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.WARRIOR)
                                .name("Warrior 1")
                                .weapon(Weapon.PEPPER_SPRAY)
                                .build()),
                AlienErrMsg.NOT_NULL_COMMANDER_ID);
    }

    @Test
    void validateWarrior_COMMANDER_ID_NOT_FOUND() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.WARRIOR)
                                .name("Warrior 1")
                                .commanderId(500L)
                                .weapon(Weapon.PEPPER_SPRAY)
                                .build()),
                AlienErrMsg.COMMANDER_ID_NOT_FOUND);
    }

    @Test
    void validateWarrior_INVALID_TYPE_OF_COMMANDER_ID() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.WARRIOR)
                                .name("Warrior 1")
                                .commanderId(2L)
                                .weapon(Weapon.PEPPER_SPRAY)
                                .build()),
                AlienErrMsg.INVALID_TYPE_OF_COMMANDER_ID);
    }

    @Test
    void validateWarrior_COMMANDER_MANAGE_UP_TO_10() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.WARRIOR)
                                .name("Warrior 1")
                                .commanderId(4L)
                                .weapon(Weapon.PEPPER_SPRAY)
                                .build()),
                AlienErrMsg.COMMANDER_MANAGE_UP_TO_10);
    }

    @Test
    void validateWarrior_NOT_NULL_WEAPON() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.WARRIOR)
                                .name("Warrior 1")
                                .commanderId(5L)
                                .build()),
                AlienErrMsg.NOT_NULL_WEAPON);
    }

    @Test
    void validateWarrior_NULL_VEHICLE() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.WARRIOR)
                                .name("Warrior 1")
                                .commanderId(5L)
                                .weapon(Weapon.PEPPER_SPRAY)
                                .vehicle(Vehicle.BIRD_SCOOTER)
                                .build()),
                AlienErrMsg.NULL_VEHICLE);
    }

    @Test
    void validateCommander_Valid() throws AlienSystemException {
        aliensValidator.validate(
                Alien.builder()
                        .id(100)
                        .type(AlienType.COMMANDER)
                        .name("Warrior 1")
                        .commanderId(2L)
                        .vehicle(Vehicle.BIRD_SCOOTER)
                        .build()
        );
    }

    @Test
    void validateCommander_NOT_NULL_COMMANDER_ID() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.COMMANDER)
                                .name("Warrior 1")
                                .vehicle(Vehicle.BIRD_SCOOTER)
                                .build()),
                AlienErrMsg.NOT_NULL_COMMANDER_ID);
    }

    @Test
    void validateCommander_COMMANDER_ID_NOT_FOUND() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.COMMANDER)
                                .name("Warrior 1")
                                .commanderId(500L)
                                .vehicle(Vehicle.BIRD_SCOOTER)
                                .build()),
                AlienErrMsg.COMMANDER_ID_NOT_FOUND);
    }

    @Test
    void validateCommander_INVALID_TYPE_OF_CHIEF_COMMANDER_ID() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.COMMANDER)
                                .name("Warrior 1")
                                .commanderId(5L)
                                .vehicle(Vehicle.BIRD_SCOOTER)
                                .build()),
                AlienErrMsg.INVALID_TYPE_OF_CHIEF_COMMANDER_ID);
    }

    @Test
    void validateCommander_CHIEF_COMMANDER_MANAGE_UP_TO_3() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.COMMANDER)
                                .name("Warrior 1")
                                .commanderId(1L)
                                .vehicle(Vehicle.BIRD_SCOOTER)
                                .build()),
                AlienErrMsg.CHIEF_COMMANDER_MANAGE_UP_TO_3);
    }

    @Test
    void validateCommander_NULL_WEAPON() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.COMMANDER)
                                .name("Warrior 1")
                                .commanderId(2L)
                                .weapon(Weapon.PEPPER_SPRAY)
                                .vehicle(Vehicle.BIRD_SCOOTER)
                                .build()),
                AlienErrMsg.NULL_WEAPON);
    }

    @Test
    void validateCommander_NOT_NULL_VEHICLE() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.COMMANDER)
                                .name("Warrior 1")
                                .commanderId(2L)
                                .build()),
                AlienErrMsg.NOT_NULL_VEHICLE);
    }

    @Test
    void validateCommander_INVALID_EGGED_BUS() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.COMMANDER)
                                .name("Warrior 1")
                                .commanderId(2L)
                                .vehicle(Vehicle.EGGED_BUS)
                                .build()),
                AlienErrMsg.INVALID_EGGED_BUS);
    }

    @Test
    void validateChief_Valid() throws AlienSystemException {
        aliensValidator.validate(
                Alien.builder()
                        .id(100)
                        .type(AlienType.CHIEF_COMMANDER)
                        .name("Warrior 1")
                        .vehicle(Vehicle.BIRD_SCOOTER)
                        .build()
        );
    }

    @Test
    void validateChief_NULL_COMMANDER_ID() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.CHIEF_COMMANDER)
                                .name("Warrior 1")
                                .commanderId(2L)
                                .vehicle(Vehicle.EGGED_BUS)
                                .build()),
                AlienErrMsg.NULL_COMMANDER_ID);
    }

    @Test
    void validateChief_NULL_WEAPON() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.CHIEF_COMMANDER)
                                .name("Warrior 1")
                                .weapon(Weapon.PEPPER_SPRAY)
                                .vehicle(Vehicle.EGGED_BUS)
                                .build()),
                AlienErrMsg.NULL_WEAPON);
    }

    @Test
    void validateChief_NOT_NULL_VEHICLE() {
        assertThrowsMessage(() -> aliensValidator.validate(
                        Alien.builder()
                                .id(100)
                                .type(AlienType.CHIEF_COMMANDER)
                                .name("Warrior 1")
                                .build()),
                AlienErrMsg.NOT_NULL_VEHICLE);
    }


    private void assertThrowsMessage(Executable executable, AlienErrMsg errMsg) {
        AlienSystemException exception = assertThrows(AlienSystemException.class, executable);
        assertEquals("Test " + errMsg.name() + "\n", exception.getMessage(), errMsg.getValue());
    }

}
