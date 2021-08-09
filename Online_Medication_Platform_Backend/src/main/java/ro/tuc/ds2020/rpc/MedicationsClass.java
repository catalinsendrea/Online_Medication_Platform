package ro.tuc.ds2020.rpc;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.Intake;
import ro.tuc.ds2020.repositories.IntakeRepository;


import java.util.List;
import java.util.Optional;

@Service
public class MedicationsClass implements MedicationsInterface{

    public IntakeRepository intakeRepository;

    public MedicationsClass(IntakeRepository intakeRepository){
        this.intakeRepository = intakeRepository;
    }

    @Override
    public String sendIntakes(Integer patientId) {

        List<Intake> intakeList = intakeRepository.findByPatient_Id(patientId);

        JSONArray jsonArray = new JSONArray();

        for(Intake i : intakeList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", i.getId());
            jsonObject.put("number", i.getNumber());
            jsonObject.put("start_take", i.getStart_take());
            jsonObject.put("end_take", i.getEnd_take());
            jsonObject.put("start_date", i.getStart_date());
            jsonObject.put("end_date", i.getEnd_date());
            jsonObject.put("patient_id", i.getPatient().getId());
            jsonObject.put("medications", i.getListOfMedication());
            jsonArray.put(jsonObject);
        }

        String stringJSON = jsonArray.toString();

        return stringJSON;
    }
}
