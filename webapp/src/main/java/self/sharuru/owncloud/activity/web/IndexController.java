package self.sharuru.owncloud.activity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sharuru on 2017/2/11 0011.
 */
@Controller
@RequestMapping(path = "/")
public class IndexController {


    @RequestMapping(method = RequestMethod.GET)
    String index() {
        return "index";
    }


}
