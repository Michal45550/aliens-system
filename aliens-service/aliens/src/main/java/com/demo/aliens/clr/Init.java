package com.demo.aliens.clr;

import com.demo.aliens.beans.AlienBean;
import com.demo.aliens.model.Alien;
import com.demo.aliens.model.enums.Vehicle;
import com.demo.aliens.model.enums.Weapon;
import com.demo.aliens.services.AliensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    private AliensService aliensService;

    @Override
    public void run(String... args) throws Exception {


        Alien a1 = Alien.builder()
                .name("alien 1")
                .commanderId(5L)
                .weapon(Weapon.PEPPER_SPRAY)
                .build();

        Alien a11 = Alien.builder()
                .name("alien 11")
                .commanderId(5L)
                .weapon(Weapon.CHOPSTICKS)
                .build();

        Alien a111 = Alien.builder()
                .name("alien 111")
                .commanderId(5L)
                .weapon(Weapon.WATER_GUN)
                .build();

        Alien a1111 = Alien.builder()
                .name("alien 1111")
                .commanderId(6L)
                .weapon(Weapon.WATER_GUN)
                .build();

        Alien a2 = Alien.builder()
                .name("alien 2")
                .commanderId(8L)
                .vehicle(Vehicle.BIRD_SCOOTER)
                .build();

        Alien a22 = Alien.builder()
                .name("alien 22")
                .commanderId(8L)
                .vehicle(Vehicle.MERKAVA_TANK)
                .build();

        Alien a222 = Alien.builder()
                .name("alien 222")
                .commanderId(9L)
                .vehicle(Vehicle.MERKAVA_TANK)
                .build();

        Alien a3 = Alien.builder()
                .name("alien 3")
                .vehicle(Vehicle.MERKAVA_TANK)
                .build();

        Alien a33 = Alien.builder()
                .name("alien 33")
                .vehicle(Vehicle.EGGED_BUS)
                .build();

        Alien a333 = Alien.builder()
                .name("alien 333")
                .vehicle(Vehicle.BIRD_SCOOTER)
                .build();

        aliensService.addAlien(a1);
        aliensService.addAlien(a11);
        aliensService.addAlien(a111);
        aliensService.addAlien(a1111);
        aliensService.addAlien(a2);
        aliensService.addAlien(a22);
        aliensService.addAlien(a222);
        aliensService.addAlien(a3);
        aliensService.addAlien(a33);
        aliensService.addAlien(a333);

        List<AlienBean> aliens = aliensService.getAll();
        aliens.forEach(System.out::println);

    }
}
