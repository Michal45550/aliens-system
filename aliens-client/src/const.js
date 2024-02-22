export const SERVICE_URL = 'http://localhost:8080/api/';

export const AlienTypes = {
    WARRIOR: 'Warrior',
    COMMANDER: 'Commander',
    CHIEF_COMMANDER: 'Chief commander'
};

export const Weapons = [
    {value: "WATER_GUN", label: "Water gun"},
    {value: "PEPPER_SPRAY", label: "Pepper spray"},
    {value: "CHOPSTICKS", label: "Chopsticks"}
];

export const Vehicles = [
    {value: "BIRD_SCOOTER", label: "Bird scooter", authorized: [AlienTypes.COMMANDER, AlienTypes.CHIEF_COMMANDER]},
    {value: "MERKAVA_TANK", label: "Merkava tank", authorized: [AlienTypes.COMMANDER, AlienTypes.CHIEF_COMMANDER]},
    {value: "EGGED_BUS", label: "Egged bus", authorized: [AlienTypes.CHIEF_COMMANDER]}
];

export const maxWarriorsForCommander = 3;
export const maxCommandersForChief = 2;
