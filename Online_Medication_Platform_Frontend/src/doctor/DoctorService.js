import axios from 'axios';

const DOCTOR_API_BASE_URL = "http://localhost:8085/doctor";

class DoctorService{

    getDoctors(){
        return axios.get(DOCTOR_API_BASE_URL);
    }

}

export default new DoctorService()