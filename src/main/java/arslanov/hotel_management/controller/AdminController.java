
package arslanov.hotel_management.controller;

import arslanov.hotel_management.dao_interface.DAO_CheckRoom;
import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.dao_interface.DAO_User;
import arslanov.hotel_management.model.CheckRoom;
import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.service.FreeRooms;
import arslanov.hotel_management.service.LoginService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired    
    public DAO_User userDao;
    @Autowired
    public DAO_Room roomDAO;
    @Autowired
    DAO_CheckRoom dao_CheckRoom;
    @Autowired
    FreeRooms fRooms; 
    
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class); 
    @RequestMapping(value = "admin")
    public ModelAndView admin(){
         ModelAndView mv = new ModelAndView("admin");
         return mv;
    }
    @RequestMapping(value = "lookRooms")
    public ModelAndView lookRooms(){
         ModelAndView mv = new ModelAndView("lookRooms");
         List<Room> rooms= new ArrayList<Room>();
         rooms=roomDAO.getRooms();
         mv.addObject("rooms",rooms);
         logger.info("rooms!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: {}",rooms.toString());
         return mv;
    }
    @RequestMapping(value = "lookCheckedRooms")
    public ModelAndView lookCheckedRooms(HttpServletRequest request){
         ModelAndView mv = new ModelAndView("lookCheckedRooms");        
        String strCheckDate = request.getParameter("calendar1");
        String strCheckOutDate = request.getParameter("calendar2");  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");       
        
        if (strCheckDate!=null && strCheckOutDate!=null) {
            Date chekDate = new Date();
            Date chekOutDate = new Date();
            try {
                chekDate = formatter.parse(strCheckDate);         
                chekOutDate = formatter.parse(strCheckOutDate); 
                }catch(ParseException e)
                {  
                    e.printStackTrace();
                }
            //FreeRooms fRooms= new FreeRooms();
            
            
            List<CheckRoom> checkRooms= new ArrayList<CheckRoom>();
            checkRooms=dao_CheckRoom.getRooms(chekDate, chekOutDate);
            mv.addObject("checkRooms", checkRooms);
            logger.info("checkRooms!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: {}",checkRooms.toString());
        }         
         
        return mv;
         
    }
}
