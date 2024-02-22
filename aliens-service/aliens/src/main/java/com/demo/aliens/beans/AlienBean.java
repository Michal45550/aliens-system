package com.demo.aliens.beans;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AlienBean {

    long id;
    String name;
    String weapon;
    Long commanderId;
    String commanderName;

}
