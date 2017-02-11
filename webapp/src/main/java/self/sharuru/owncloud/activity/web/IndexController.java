package self.sharuru.owncloud.activity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import self.sharuru.owncloud.activity.entity.Activity;
import self.sharuru.owncloud.activity.repository.ActivityRepository;

/**
 * Created by Sharuru on 2017/2/11 0011.
 */
@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    ActivityRepository activityRepository;

    @RequestMapping()
    String index(Model model, Pageable pageable) {
        model.addAttribute("activities", activityRepository.findAllByOrderByIdDesc(pageable));
        return "index";
    }


}
