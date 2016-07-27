package arslanov.hotel_management.controller;

import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.service.FreeRooms;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class LookUpController {

    @Autowired
    FreeRooms fRooms;
    private static final Logger logger = LoggerFactory.getLogger(LookUpController.class);

    @RequestMapping(value = "lookUpRooms")
    public ModelAndView LookUp(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("lookUpRooms");
        String strCheckDate = request.getParameter("calendar1");
        String strCheckOutDate = request.getParameter("calendar2");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (strCheckDate != null) {
            logger.info("strCheckDate NOT NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: {}", strCheckDate);
        }
        if (strCheckOutDate != null) {
            logger.info("strCheckOUTDate NOT NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: {}", strCheckDate);
        }

        if (strCheckDate != null && strCheckOutDate != null) {
            Date chekDate = new Date();
            Date chekOutDate = new Date();
            try {
                chekDate = formatter.parse(strCheckDate);
                chekOutDate = formatter.parse(strCheckOutDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (chekDate.after(chekOutDate)) {
//                mv.setViewName("lookUpRooms");
                mv.addObject("msg", "Ой!!");
                mv.addObject("details", "Дата заселения указана раньше, чем дата выселения :) !");
                return mv;
            }
            //FreeRooms fRooms= new FreeRooms();
            List<Room> rooms = fRooms.getFreeRooms(chekDate, chekOutDate);
            logger.info("rooms: {}", rooms.toString());
            mv.addObject("rooms", rooms);
        }

        return mv;
    }

}
