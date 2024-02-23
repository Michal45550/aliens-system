package com.demo.aliens.model.enums;

public enum AlienType {
    WARRIOR("Warrior"),
    COMMANDER("Commander"),
    CHIEF_COMMANDER("Chief commander");

    private final String alienType;

    AlienType(String alienType) {
        this.alienType = alienType;
    }

    public String getValue() {
        return alienType;
    }
}
