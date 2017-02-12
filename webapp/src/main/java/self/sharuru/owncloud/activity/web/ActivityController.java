package self.sharuru.owncloud.activity.web;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import self.sharuru.owncloud.activity.entity.Activity;
import self.sharuru.owncloud.activity.repository.ActivityRepository;

import javax.validation.Valid;

/**
 * Created by Sharuru on 2017/2/11 0011.
 */
@RestController
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data/activities")
    public DataTablesOutput<Activity> getActivities(DataTablesInput input) {
        return activityRepository.findAll(input);
    }
}
