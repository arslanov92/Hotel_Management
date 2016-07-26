package arslanov.hotel_management.controller;

import arslanov.hotel_management.dao_interface.DAO_CheckRoom;
import arslanov.hotel_management.dao_interface.DAO_Hystory;
import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.dao_interface.DAO_User;
import arslanov.hotel_management.model.Hystory;
import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.model.User;
import arslanov.hotel_management.service.FreeRooms;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class reservationController {

    private static final Logger logger = LoggerFactory.getLogger(lookUpController.class);
    @Autowired
    public DAO_User userDao;
    @Autowired
    public DAO_Room roomDAO;
    @Autowired
    public DAO_Hystory hystoryDAO;
    
    @Autowired
    FreeRooms fRooms;

    @RequestMapping(value = "reservation")
    public ModelAndView viewReservation(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("reservation");
        //  ModelAndView mvDO=new ModelAndView("reservationDo"); 

        String strCheckDate = request.getParameter("calendarRe");
        String strCheckOutDate = request.getParameter("calendarRe2");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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
                mv.setViewName("reservation");
                mv.addObject("msg", "Ой!!");
                mv.addObject("details", "Дата заселения указана раньше, чем дата выселения :) !");
                return mv;
            }
          //  chekDate           
            
            List<Room> rooms = fRooms.getFreeRooms(chekDate, chekOutDate);
            mv.addObject("rooms", rooms);
            mv.addObject("chekDate", request.getParameter("calendarRe"));
            mv.addObject("chekOutDate", request.getParameter("calendarRe2"));
//            mv.addObject("chekDate", chekDate);
//            mv.addObject("chekOutDate", chekOutDate);           
        }
        return mv;
    }   

    @Autowired
    DAO_CheckRoom dao_CheckRoom;

    @RequestMapping(value = "reservationFinal")
    public ModelAndView ReservationFinal(HttpSession session, HttpServletRequest request, @RequestParam("roomId") long roomId,
            @RequestParam("chekDate") String strCheckDate, @RequestParam("chekOutDate") String strCheckOutDate) {
        ModelAndView mv = new ModelAndView("reservationFinal");
        logger.info("logged in CHEEEEEEEEEEEEKDAAATE!!!! {}", strCheckDate);
        logger.info("logged in CHEEEEEEEEEEEEKOOOOUUUTTDAAATE!!!! {}", strCheckOutDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (strCheckDate != null && strCheckOutDate != null) {
            Date chekDate = new Date();
            Date chekOutDate = new Date();
            try {
                chekDate = formatter.parse(strCheckDate);
                chekOutDate = formatter.parse(strCheckOutDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<Room> rooms = fRooms.getFreeRooms(chekDate, chekOutDate);
            //  mv.addObject("rooms", rooms);           
            long userID = (long) session.getAttribute("userId");
            User user = userDao.getUser(userID);
            Room room = roomDAO.getRoom(roomId);
            if (rooms.contains(room)) {
                dao_CheckRoom.recordNewCheсkedRoom(room, user, chekDate, chekOutDate);
                Hystory hystory =new Hystory(room, user, chekDate, chekOutDate);
                hystoryDAO.putNewHystory(hystory);
                
            } else {
                mv.setViewName("error");
                mv.addObject("msg", "Ой!!");
                mv.addObject("details", "Кто-то за секунду до вас успел забронировать эту комнату,"
                        + " пожалуйста выберите другую комнату!");
            }
            long difference = chekOutDate.getTime() - chekDate.getTime();
            long days = difference/(24*60*60*1000);
            long price =room.getPrice().longValue();
            long finalPrice=days*price;
            mv.addObject("chekDate", request.getParameter("calendarRe"));
            mv.addObject("chekOutDate", request.getParameter("calendarRe2"));
//            mv.addObject("firstName",user.getFirstName());
//            mv.addObject("lastName",user.getLastName());
            mv.addObject("price", finalPrice);
            mv.addObject("user",user);
            mv.addObject("days",days);
            mv.addObject("room",room);
        }

        

        return mv;
    }

}
