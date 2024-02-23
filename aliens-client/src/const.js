export const SERVICE_URL = 'http://localhost:8080/api/';

export const AlienTypes = {
    WARRIOR: {value: "WARRIOR", label: 'Warrior'},
    COMMANDER: {value: "COMMANDER", label: 'Commander'},
    CHIEF_COMMANDER: {value: "CHIEF_COMMANDER", label: 'Chief commander'}
};

export const Weapons = [
    {value: "WATER_GUN", label: "Water gun"},
    {value: "PEPPER_SPRAY", label: "Pepper spray"},
    {value: "CHOPSTICKS", label: "Chopsticks"}
];

export const Vehicles = [
    {value: "BIRD_SCOOTER", label: "Bird scooter", authorized: [AlienTypes.COMMANDER.value, AlienTypes.CHIEF_COMMANDER.value]},
    {value: "MERKAVA_TANK", label: "Merkava tank", authorized: [AlienTypes.COMMANDER.value, AlienTypes.CHIEF_COMMANDER.value]},
    {value: "EGGED_BUS", label: "Egged bus", authorized: [AlienTypes.CHIEF_COMMANDER.value]}
];

export const maxWarriorsForCommander = 3;
export const maxCommandersForChief = 2;
