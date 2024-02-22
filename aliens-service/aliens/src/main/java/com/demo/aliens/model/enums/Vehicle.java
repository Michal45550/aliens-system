package com.demo.aliens.model.enums;

public enum Vehicle {

    BIRD_SCOOTER("Bird scooter"),
    MERKAVA_TANK("Merkava tank"),
    EGGED_BUS("Egged bus");

    private final String vehicle;

    Vehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getValue() {
        return vehicle;
    }
}
