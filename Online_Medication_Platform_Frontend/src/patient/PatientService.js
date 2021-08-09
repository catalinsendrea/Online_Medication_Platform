import axios from 'axios';

const PATIENT_API_BASE_URL = "http://localhost:8085/patient";

class PatientService{

    getPatients(){
        return axios.get(PATIENT_API_BASE_URL);
    }

    getPatientById(patientId){
        return axios.get(PATIENT_API_BASE_URL + '/' + patientId);
    }

    deletePatient(PatientId){
        return axios.delete(PATIENT_API_BASE_URL + '/' + PatientId);
    }

    createPatient(patient){
        return axios.post(PATIENT_API_BASE_URL, patient);
    }

    updatePatient(patient, patientId) {
        return axios.put(PATIENT_API_BASE_URL + '/' + patientId, patient);
    }
}

export default new PatientService()