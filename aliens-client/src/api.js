import defaultAxios from 'axios'
import {SERVICE_URL} from "./const.js";

export const axiosInstance = defaultAxios.create({
    baseURL: SERVICE_URL,
    headers: {'Content-Type': 'application/json'}
});

export const getAll = async () => {
    try {
        const allAliens = await axiosInstance.get('aliens');
        return allAliens.data;
    } catch (err) {
        return console.error(err);
    }
}

export const addAlien = async (alien) => {
    try {
        const newAlien = await axiosInstance.post('aliens', JSON.stringify(alien));
        return newAlien.data;
    } catch (err) {
        return console.error(err);
    }
}
