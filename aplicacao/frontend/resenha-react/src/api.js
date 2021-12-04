import axios from 'axios';

const api = axios.create({
    baseURL: "http://48de-2804-420c-1045-c500-d53f-6ad6-c950-a3b6.ngrok.io/"
});

export default api;