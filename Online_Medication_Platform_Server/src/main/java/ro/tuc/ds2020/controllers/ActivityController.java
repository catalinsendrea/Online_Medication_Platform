package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.ActivityDTO;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.services.ActivityService;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/activity")

public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    @PostMapping()
    public ResponseEntity<Integer> insertActivity(@Valid @RequestBody ActivityDTO activityDTO) {
        Integer activityId = activityService.insertActivity(activityDTO);
        return new ResponseEntity<>(activityId, HttpStatus.CREATED);
    }
}
