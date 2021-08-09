import axios from 'axios';

const INTAKE_API_BASE_URL = "http://localhost:8085/intake";

class IntakeService{

    createIntake(intake){
        return axios.post(INTAKE_API_BASE_URL, intake);
    }

    getIntakes(id){
        return axios.get(INTAKE_API_BASE_URL + '/' + id);
    }

}

export default new IntakeService()