import axios from 'axios';

const httpClient = axios.create({
    withCredentials: false
});

export {httpClient}