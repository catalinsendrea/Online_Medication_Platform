package ro.tuc.ds2020.consumer;

import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.controllers.ActivityController;
import ro.tuc.ds2020.dtos.ActivityDTO;
import ro.tuc.ds2020.dtos.builders.ActivityBuilder;
import ro.tuc.ds2020.entities.Activity;

import java.util.Date;


@Component
public class Consumer{

    @Autowired
    ActivityController activityController;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void onMessage(String message){
        System.out.println(message);

        JSONObject jsonString = new JSONObject(message);

        Activity activity = new Activity(new Date(jsonString.getLong("start_date")), new Date(jsonString.getLong("end_date")),jsonString.getString("activity_label"), jsonString.getInt("patient_id"));
        ActivityDTO activityDTO = ActivityBuilder.toDTO(activity);

        long period_time = jsonString.getLong("end_date") - jsonString.getLong("start_date");

        if( (jsonString.getString("activity_label").contains("Sleeping") && period_time > 25200000) ||
                (jsonString.getString("activity_label").contains("Leaving") && period_time > 18000000) ||
                (jsonString.getString("activity_label").contains("Toileting") && period_time > 1800000) ||
                (jsonString.getString("activity_label").contains("Showering") && period_time > 1800000)){

            activityController.insertActivity(activityDTO);
        }

    }





}
