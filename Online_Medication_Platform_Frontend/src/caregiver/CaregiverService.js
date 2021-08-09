import axios from 'axios';

const CAREGIVER_API_BASE_URL = "http://localhost:8085/caregiver";

class CaregiverService{

    getCaregivers(){
        return axios.get(CAREGIVER_API_BASE_URL);
    }

    getCaregiverById(caregiverId){
        return axios.get(CAREGIVER_API_BASE_URL + '/' + caregiverId);
    }

    deleteCaregiver(caregiverId){
        return axios.delete(CAREGIVER_API_BASE_URL + '/' + caregiverId);
    }

    createCaregiver(caregiver){
        return axios.post(CAREGIVER_API_BASE_URL, caregiver);
    }

    updateCaregiver(caregiver, caregiverId) {
        return axios.put(CAREGIVER_API_BASE_URL + '/' + caregiverId, caregiver);
    }
}


export default new CaregiverService()