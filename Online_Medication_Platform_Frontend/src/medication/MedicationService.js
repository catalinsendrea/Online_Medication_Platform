import axios from 'axios';

const MEDICATION_API_BASE_URL = "http://localhost:8085/medication";

class MedicationService{

    getMedications(){
        return axios.get(MEDICATION_API_BASE_URL);
    }

    getMedicationById(medicationId){
        return axios.get(MEDICATION_API_BASE_URL + '/' + medicationId);
    }

    deleteMedication(medicationId){
        return axios.delete(MEDICATION_API_BASE_URL + '/' + medicationId);
    }

    createMedication(medication){
        return axios.post(MEDICATION_API_BASE_URL, medication);
    }

    updateMedication(medication, medicationId) {
        return axios.put(MEDICATION_API_BASE_URL + '/' + medicationId, medication);
    }

}

export default new MedicationService()