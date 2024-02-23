package com.demo.aliens.validators;

import com.demo.aliens.exceptions.AlienSystemException;
import com.demo.aliens.exceptions.AlienErrMsg;
import com.demo.aliens.model.Alien;
import com.demo.aliens.model.enums.AlienType;
import com.demo.aliens.model.enums.Vehicle;
import com.demo.aliens.repositories.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AliensValidator {

    private static AlienRepository alienRepository;

    private static Map<Long, Long> commandsCountMap;
    private static Map<Long, AlienType> commanderTypeMap;

    @Autowired
    public AliensValidator(AlienRepository alienRepository) {
        AliensValidator.alienRepository = alienRepository;
    }

    public void validate(Alien alien) throws AlienSystemException {

        List<Alien> aliens = alienRepository.findAll();

        commandsCountMap = aliens.stream()
                .filter(a -> a.getCommanderId() != null)
                .collect(Collectors.groupingBy(Alien::getCommanderId, Collectors.counting()));

        commanderTypeMap = aliens.stream()
                .collect(Collectors.toMap(Alien::getId, Alien::getType));

        switch (alien.getType()) {
            case WARRIOR -> validateWarrior(alien);
            case COMMANDER -> validateCommander(alien);
            case CHIEF_COMMANDER -> validateChief(alien);
        }

    }

    private void validateWarrior(Alien alien) throws AlienSystemException {

        if(alien.getCommanderId() == null)
            throw new AlienSystemException(AlienErrMsg.NOT_NULL_COMMANDER_ID);

        Optional<AlienType> optionalType =  Optional.ofNullable(commanderTypeMap.get(alien.getCommanderId()));
        if(optionalType.isEmpty())
            throw new AlienSystemException(AlienErrMsg.COMMANDER_ID_NOT_FOUND);
        if(optionalType.get() != AlienType.COMMANDER)
            throw new AlienSystemException(AlienErrMsg.INVALID_TYPE_OF_COMMANDER_ID);

        Optional<Long> optionalCommandsCount =  Optional.ofNullable(commandsCountMap.get(alien.getCommanderId()));
        if(optionalCommandsCount.isPresent() && optionalCommandsCount.get() >= 3)
            throw new AlienSystemException(AlienErrMsg.COMMANDER_MANAGE_UP_TO_10);

        if(alien.getWeapon() == null)
            throw new AlienSystemException(AlienErrMsg.NOT_NULL_WEAPON);

        if(alien.getVehicle() != null)
            throw new AlienSystemException(AlienErrMsg.NULL_VEHICLE);

    }

    private void validateCommander(Alien alien) throws AlienSystemException {

        if(alien.getCommanderId() == null)
            throw new AlienSystemException(AlienErrMsg.NOT_NULL_COMMANDER_ID);

        Optional<AlienType> optionalType =  Optional.ofNullable(commanderTypeMap.get(alien.getCommanderId()));
        if(optionalType.isEmpty())
            throw new AlienSystemException(AlienErrMsg.COMMANDER_ID_NOT_FOUND);
        if(optionalType.get() != AlienType.CHIEF_COMMANDER)
            throw new AlienSystemException(AlienErrMsg.INVALID_TYPE_OF_CHIEF_COMMANDER_ID);

        Optional<Long> optionalCommandsCount =  Optional.ofNullable(commandsCountMap.get(alien.getCommanderId()));
        if(optionalCommandsCount.isPresent() && optionalCommandsCount.get() >= 2)
            throw new AlienSystemException(AlienErrMsg.CHIEF_COMMANDER_MANAGE_UP_TO_3);

        if(alien.getWeapon() != null)
            throw new AlienSystemException(AlienErrMsg.NULL_WEAPON);

        if(alien.getVehicle() == null)
            throw new AlienSystemException(AlienErrMsg.NOT_NULL_VEHICLE);

        if(alien.getVehicle() == Vehicle.EGGED_BUS)
            throw new AlienSystemException(AlienErrMsg.INVALID_EGGED_BUS);

    }

    private void validateChief(Alien alien) throws AlienSystemException {

        if(alien.getCommanderId() != null)
            throw new AlienSystemException(AlienErrMsg.NULL_COMMANDER_ID);

        if(alien.getWeapon() != null)
            throw new AlienSystemException(AlienErrMsg.NULL_WEAPON);

        if(alien.getVehicle() == null)
            throw new AlienSystemException(AlienErrMsg.NOT_NULL_VEHICLE);
    }

}
