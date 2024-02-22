package com.demo.aliens.model.enums;

public enum Weapon {

    WATER_GUN("Water gun"),
    PEPPER_SPRAY("Pepper spray"),
    CHOPSTICKS("Chopsticks");

    private final String weapon;

    Weapon(String weapon) {
        this.weapon = weapon;
    }

    public String getValue() {
        return weapon;
    }
}
