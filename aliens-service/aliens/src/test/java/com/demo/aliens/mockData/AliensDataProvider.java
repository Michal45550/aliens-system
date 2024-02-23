package com.demo.aliens.mockData;

import com.demo.aliens.model.Alien;
import com.demo.aliens.model.enums.AlienType;
import com.demo.aliens.model.enums.Vehicle;
import com.demo.aliens.model.enums.Weapon;
import lombok.experimental.UtilityClass;

import java.util.List;

import static java.util.Arrays.asList;

@UtilityClass
public class AliensDataProvider {

    public static List<Alien> getAliensList() {
        return asList(
                Alien.builder()
                        .id(7)
                        .name("alien 1")
                        .commanderId(4L)
                        .weapon(Weapon.PEPPER_SPRAY)
                        .type(AlienType.WARRIOR)
                        .build(),
                Alien.builder()
                        .id(8)
                        .name("alien 11")
                        .commanderId(4L)
                        .weapon(Weapon.CHOPSTICKS)
                        .type(AlienType.WARRIOR)
                        .build(),
                Alien.builder()
                        .id(9)
                        .name("alien 111")
                        .commanderId(4L)
                        .weapon(Weapon.WATER_GUN)
                        .type(AlienType.WARRIOR)
                        .build(),
                Alien.builder()
                        .id(10)
                        .name("alien 1111")
                        .commanderId(5L)
                        .weapon(Weapon.WATER_GUN)
                        .type(AlienType.WARRIOR)
                        .build(),
                Alien.builder()
                        .id(4)
                        .name("alien 2")
                        .commanderId(1L)
                        .vehicle(Vehicle.BIRD_SCOOTER)
                        .type(AlienType.COMMANDER)
                        .build(),
                Alien.builder()
                        .id(5)
                        .name("alien 22")
                        .commanderId(1L)
                        .vehicle(Vehicle.MERKAVA_TANK)
                        .type(AlienType.COMMANDER)
                        .build(),
                Alien.builder()
                        .id(6)
                        .name("alien 222")
                        .commanderId(2L)
                        .vehicle(Vehicle.MERKAVA_TANK)
                        .type(AlienType.COMMANDER)
                        .build(),
                Alien.builder()
                        .id(1)
                        .name("alien 3")
                        .vehicle(Vehicle.MERKAVA_TANK)
                        .type(AlienType.CHIEF_COMMANDER)
                        .build(),
                Alien.builder()
                        .id(2)
                        .name("alien 33")
                        .vehicle(Vehicle.EGGED_BUS)
                        .type(AlienType.CHIEF_COMMANDER)
                        .build(),
                Alien.builder()
                        .id(3)
                        .name("alien 333")
                        .vehicle(Vehicle.BIRD_SCOOTER)
                        .type(AlienType.CHIEF_COMMANDER)
                        .build()
        );
    }

}
