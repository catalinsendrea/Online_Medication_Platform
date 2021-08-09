package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.ActivityDTO;
import ro.tuc.ds2020.entities.Activity;

public class ActivityBuilder {

    public ActivityBuilder(){

    }

    public static ActivityDTO toDTO(Activity activity){
        return new ActivityDTO(activity.getStart_date(), activity.getEnd_date(), activity.getActivity_label(), activity.getPatient_id());
    }

    public static Activity toEntity(ActivityDTO activityDTO){
        return new Activity(activityDTO.getStart_date(), activityDTO.getEnd_date(), activityDTO.getActivity_label(), activityDTO.getPatient_id());
    }
}
