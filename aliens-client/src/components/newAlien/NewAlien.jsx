import * as React from 'react';
import {useState} from 'react';
import './NewAlien.css';
import Modal from '@mui/material/Modal';
import {Box, FormControl, InputLabel, MenuItem, Select, TextField} from "@mui/material";
import {AlienTypes, Vehicles, Weapons} from "../../const.js";
import * as api from "../../api.js";

const NewAlien = ({commanders}) => {

    const ALIEN_DATA = {
        type: "",
        name: null,
        commanderId: null,
        weapon: null,
        vehicle: null
    }

    const [open, setOpen] = useState(false);
    const [alienData, setAlienData] = useState(ALIEN_DATA);

    const handleOpen = () => setOpen(true);
    const handleClose = () => {
        setOpen(false);
        setAlienData(ALIEN_DATA);
    }

    const handleInputChange = (event) => {
        const {name, value} = event.target;
        setAlienData((prevProps) => ({
            ...prevProps,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        api.addAlien({
            name: alienData.name,
            commanderId: alienData.commanderId,
            weapon: alienData.weapon,
            vehicle: alienData.vehicle,
            type: alienData.type
        }).then(data => data && (handleClose() && setAlienData(ALIEN_DATA)));
    }

    return (
        <div>
            <button className="add-button" onClick={handleOpen}>ADD ALIEN</button>
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <div className="modal">
                    <div className="modal-header">
                        New alien
                    </div>
                    <div className="modal-content">
                        <form onSubmit={handleSubmit}>
                            <Box sx={{m: 1, minWidth: 200}}>
                                <FormControl fullWidth>
                                    <TextField
                                        label="Name"
                                        name="name"
                                        variant="outlined"
                                        value={alienData.name}
                                        required
                                        onChange={handleInputChange}
                                    />
                                </FormControl>
                            </Box>
                            <Box sx={{m: 1, minWidth: 200}}>
                                <FormControl fullWidth>
                                    <InputLabel id="type">Type</InputLabel>
                                    <Select
                                        labelId="type"
                                        name="type"
                                        id="type"
                                        value={alienData.type}
                                        required
                                        label="Alien Type"
                                        onChange={handleInputChange}
                                        variant="outlined"
                                    >
                                        {Object.values(AlienTypes).map((item, index) =>
                                            <MenuItem value={item.value} key={index}>{item.label}</MenuItem>
                                        )}
                                    </Select>
                                </FormControl>
                            </Box>
                            {(alienData.type === AlienTypes.WARRIOR.value || alienData.type === AlienTypes.COMMANDER.value) &&
                                <Box sx={{m: 1, minWidth: 200}}>
                                    <FormControl fullWidth>
                                        <InputLabel id="commander">Commander</InputLabel>
                                        <Select
                                            labelId="commander"
                                            name="commanderId"
                                            id="commander"
                                            value={alienData.commanderId}
                                            required
                                            label="Commander"
                                            onChange={handleInputChange}
                                            variant="outlined"
                                        >
                                            {commanders.map((item, index) =>
                                                (((alienData.type === AlienTypes.WARRIOR.value && item.commanderId !== null) ||
                                                        (alienData.type === AlienTypes.COMMANDER.value && item.commanderId === null)) &&
                                                    <MenuItem value={item.id} key={index}>{item.name}</MenuItem>
                                                ))}
                                        </Select>
                                    </FormControl>
                                </Box>}
                            {alienData.type === AlienTypes.WARRIOR.value &&
                                <Box sx={{m: 1, minWidth: 200}}>
                                    <FormControl fullWidth>
                                        <InputLabel id="weapon">Weapon</InputLabel>
                                        <Select
                                            labelId="weapon"
                                            name="weapon"
                                            id="weapon"
                                            value={alienData.weapon}
                                            required
                                            label="Weapon"
                                            onChange={handleInputChange}
                                            variant="outlined"
                                        >
                                            {Weapons.map((item, index) =>
                                                <MenuItem value={item.value} key={index}>{item.label}</MenuItem>
                                            )}
                                        </Select>
                                    </FormControl>
                                </Box>}
                            {(alienData.type === AlienTypes.COMMANDER.value || alienData.type === AlienTypes.CHIEF_COMMANDER.value) &&
                                <Box sx={{m: 1, minWidth: 200}}>
                                    <FormControl fullWidth>
                                        <InputLabel id="vehicle">Vehicle</InputLabel>
                                        <Select
                                            labelId="vehicle"
                                            name="vehicle"
                                            id="vehicle"
                                            value={alienData.vehicle}
                                            required
                                            label="Vehicle"
                                            onChange={handleInputChange}
                                            variant="outlined"
                                        >
                                            {Vehicles.map((item, index) =>
                                                (item.authorized.includes(alienData.type) &&
                                                    <MenuItem value={item.value} key={index}>{item.label}</MenuItem>
                                                ))}
                                        </Select>
                                    </FormControl>
                                </Box>}

                            <button id="submit" type="submit">Submit</button>
                        </form>
                    </div>
                </div>
            </Modal>
        </div>
    );
};

export default NewAlien;
