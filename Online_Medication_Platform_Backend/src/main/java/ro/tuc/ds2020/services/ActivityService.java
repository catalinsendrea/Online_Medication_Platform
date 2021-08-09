package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.ActivityDTO;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.builders.ActivityBuilder;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.entities.Activity;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.repositories.ActivityRepository;


@Service
public class ActivityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityService.class);
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    public Integer insertActivity(ActivityDTO activityDTO) {
        Activity activity = ActivityBuilder.toEntity(activityDTO);
        activity = activityRepository.save(activity);
        LOGGER.debug("Activity with id {} was inserted in db", activity.getId());
        return activity.getId();
    }
}
