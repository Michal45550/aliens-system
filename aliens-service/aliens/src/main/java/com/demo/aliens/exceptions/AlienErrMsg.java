package com.demo.aliens.exceptions;

import lombok.Getter;

@Getter
public enum AlienErrMsg {

    NOT_NULL_COMMANDER_ID("Invalid commander id, must have a value for Warrior and Commander"),
    NULL_COMMANDER_ID("Invalid commander id, must not have a value for Chief commander"),
    INVALID_COMMANDER_ID("Invalid commander id, directly manage up to 10 alien-warriors"),
    COMMANDER_ID_NOT_FOUND("Commander id not found"),
    INVALID_TYPE_OF_COMMANDER_ID("Invalid type of commander id, Commander directly manages warriors only"),
    INVALID_TYPE_OF_CHIEF_COMMANDER_ID("Invalid type of commander id, Chief commander directly manages commanders only"),
    COMMANDER_MANAGE_UP_TO_10("Invalid commander id, Commander directly manages up to 3 alien-warriors"),
    CHIEF_COMMANDER_MANAGE_UP_TO_3("Invalid commander id, Chief commander directly manages up to 2 alien-commanders"),
    NOT_NULL_WEAPON("Invalid weapon, must have a value for Warrior"),
    NULL_WEAPON("Invalid weapon, must not have a value for Commander and Chief commander"),
    NOT_NULL_VEHICLE("Invalid vehicle, must have a value for Commander and Chief commander"),
    NULL_VEHICLE("Invalid vehicle, must not have a value for Warrior"),
    INVALID_EGGED_BUS("Invalid vehicle, Egged bus is not authorized for Commander");

    AlienErrMsg(String msg) {
        this.msg = msg;
    }

    private final String msg;

    public String getValue() {
        return msg;
    }

}
