import {useEffect, useState} from 'react';
import './App.css';
import {groupBy, mapValues} from 'lodash';
import * as api from "./api.js";
import AliensTable from "./components/aliensTable/AliensTable.jsx";
import NewAlien from "./components/newAlien/NewAlien.jsx";
import {maxCommandersForChief, maxWarriorsForCommander} from "./const.js";

function App() {

    const [aliens, setAliens] = useState([]);
    const [availableCommanders, setAvailableCommanders] = useState({});

    useEffect(() => {
        const intervalId = setInterval(() => {
            api.getAll().then(data => setAliens(data));
        }, 500);
        return () => clearInterval(intervalId);
    }, []);

    useEffect(() => {
        const groupedCommands = groupBy(aliens.filter(a => a.commanderId !== null), 'commanderId');
        const commandsMap = mapValues(groupedCommands, val => val.length);

        const filteredCommanders = aliens.filter(a => {
            const maxCommands = a.commanderId != null ? maxWarriorsForCommander : maxCommandersForChief;
            const commandsNum = commandsMap[a.id];
            return a.weapon === null && (commandsNum === undefined || commandsNum < maxCommands);
        })
        setAvailableCommanders(filteredCommanders);

    }, [aliens]);

    return (
        <>
            <NewAlien commanders={availableCommanders}/>
            {aliens.length ? <AliensTable data={aliens}/> : "-no data-"}
        </>
    )
}

export default App;

