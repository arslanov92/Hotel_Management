package arslanov.hotel_management.controller;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class MenuController {

    @RequestMapping(value = "index")
    public ModelAndView Index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "webService")
    public ModelAndView webService() {
        ModelAndView mv = new ModelAndView("webService");
        return mv;
    }
//    @RequestMapping(value="webServiceFinal")
//    public ModelAndView webServiceFinal() {
//         ModelAndView mv=new ModelAndView("webServiceFinal");
//         return mv;
//    }
}
