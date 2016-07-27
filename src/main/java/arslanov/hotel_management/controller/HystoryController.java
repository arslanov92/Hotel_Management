package arslanov.hotel_management.controller;

import arslanov.hotel_management.dao_interface.DAO_Hystory;
import arslanov.hotel_management.dao_interface.DAO_User;
import arslanov.hotel_management.model.Hystory;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HystoryController {

    @Autowired
    public DAO_User userDao;
    @Autowired
    public DAO_Hystory hystoryDao;
    private static final Logger logger = LoggerFactory.getLogger(HystoryController.class);

    @RequestMapping(value = "lookHystory")
    public ModelAndView lookHystory(HttpSession session) {
        ModelAndView mv = new ModelAndView("lookHystory");
        long holderUserId = (long) session.getAttribute("userId");
        logger.error("ID ЮЗЕЕЕЕЕЕЕЕЕЕЕЕРААААААААААААААА АГРХ!!!! {}", holderUserId);
        List<Hystory> hystory = hystoryDao.getUserHystory(holderUserId);
        mv.addObject("hystory", hystory);
        return mv;
    }
}
