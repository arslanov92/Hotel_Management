
package arslanov.hotel_management.controller;

import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.service.FreeRooms;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class lookUpController {
    private static final Logger logger = LoggerFactory.getLogger(lookUpController.class); 
    @RequestMapping(value="lookUpRooms")
    public ModelAndView LookUp(HttpServletRequest request) {        
         ModelAndView mv=new ModelAndView("lookUpRooms");
         String strCheckDate = request.getParameter("calendar1");
         String strCheckOutDate = request.getParameter("calendar2");         
//         String day;
//         String month;
//         String year;
//         
//         strCheckDate.trim();
//         strCheckOutDate.trim();
//         
//         day=strCheckDate.substring(0, 1);
//         month=strCheckDate.substring(2,3);
//         year=strCheckDate.substring(4);         
         Date chekDate = new Date();         
         Date chekOutDate = new Date();         
         logger.info("strCheckDate:",strCheckDate);
         logger.info("strCheckOutDate:",strCheckOutDate);         
//         FreeRooms fRooms= new FreeRooms();
//         List<Room> rooms=fRooms.getFreeRooms(chekDate, chekOutDate);
         return mv;
    }
    
}
