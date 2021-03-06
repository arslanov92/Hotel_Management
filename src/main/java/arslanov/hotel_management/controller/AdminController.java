package arslanov.hotel_management.controller;

import arslanov.hotel_management.dao_interface.DAO_CheckRoom;
import arslanov.hotel_management.dao_interface.DAO_Hystory;
import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.dao_interface.DAO_User;
import arslanov.hotel_management.model.CheckRoom;
import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.model.User;
import arslanov.hotel_management.service.DeleteService;
import arslanov.hotel_management.service.FreeRooms;
import arslanov.hotel_management.service.LookRoomService;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
public class AdminController {

    @Autowired
    public DAO_User userDao;
    @Autowired
    public DAO_Room roomDAO;
    @Autowired
    DAO_CheckRoom dao_CheckRoom;
    @Autowired
    DAO_Hystory dao_hystory;

    @Autowired
    FreeRooms fRooms;
    @Autowired
    DeleteService deleteService;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "admin")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }

    @RequestMapping(value = "lookRooms")
    public ModelAndView lookRooms() {
        ModelAndView mv = new ModelAndView("lookRooms");
        List<Room> rooms = roomDAO.getRooms();
        mv.addObject("rooms", rooms);
        logger.info("rooms!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: {}", rooms.toString());
        return mv;
    }

    @RequestMapping(value = "lookCheckedRooms")
    public ModelAndView lookCheckedRooms(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("lookCheckedRooms");
        String strCheckDate = request.getParameter("calendar1");
        String strCheckOutDate = request.getParameter("calendar2");
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
//                mv.setViewName("lookUpRooms");
                mv.addObject("msg", "Ой!!");
                mv.addObject("details", "Дата заселения указана раньше, чем дата выселения :) !");
                return mv;
            }
            //FreeRooms fRooms= new FreeRooms();

            List<CheckRoom> checkRooms = dao_CheckRoom.getRooms(chekDate, chekOutDate);
            mv.addObject("checkRooms", checkRooms);
            logger.info("checkRooms!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: {}", checkRooms.toString());
        }

        return mv;

    }

    @Autowired
    public LookRoomService lrs;

    @RequestMapping(value = "addRoom")
    public ModelAndView addRoom(@RequestParam("roomNumber") int roomNumber, @RequestParam("typeRoom") String typeRoom,
            @RequestParam("bed") int bed, @RequestParam("price") BigDecimal price,
            HttpSession session) {
        ModelAndView mv = new ModelAndView("addRoomView");
//        long id = lrs.lookRoom(roomNumber);
        if (lrs.lookRoom(roomNumber)) {
            mv.setViewName("admin");
            mv.addObject("msg", "Ошибка добавления");
            mv.addObject("details", "Комната с таким номером уже существует");
            return mv;
        }
        Room r = new Room(roomNumber, typeRoom, bed, price);
        roomDAO.storeNewRoom(r);
        mv.addObject("msgSuccessful", "Комната успешно добавлена!");
        mv.setViewName("admin");
        return mv;
    }

    @RequestMapping(value = "delRoom")
    public ModelAndView delRoom(@RequestParam("roomId") long roomId) {
        ModelAndView mv = new ModelAndView("admin");
//        List<CheckRoom> checkRooms = dao_CheckRoom.getCheсkRoomWithRoomId(roomId);
//        for (CheckRoom checkRoom : checkRooms) {
//            dao_CheckRoom.delCheсkedRoomWithRoom(checkRoom);
//        }
//        List<Hystory> hystorys = dao_hystory.getHystoryWithRoomId(roomId); 
//        for (Hystory hystory : hystorys) {
//            dao_hystory.delHystory(hystory);
//        }        
//        roomDAO.deleteRoom(roomId);
        long roomNumber = roomDAO.getRoom(roomId).getRoomNumber();
        deleteService.deleteRoomService(roomId);
//        mv.setViewName("admin"); 
        mv.addObject("msgDelRoomSuc", "Комната № " + roomNumber + " c ID: " + roomId + " успешно удалена!");
        return mv;
    }

    @RequestMapping(value = "delUser")
    public ModelAndView delUser(@RequestParam("userId") long userId) {
        ModelAndView mv = new ModelAndView("admin");

//        List<CheckRoom> checkRooms = dao_CheckRoom.getCheсkRoomWithUserId(userId);
//        for (CheckRoom checkRoom : checkRooms) {
//            dao_CheckRoom.delCheсkedRoomWithRoom(checkRoom);
//        }
//        List<Hystory> hystorys = dao_hystory.getHystoryWithUserId(userId); 
//        for (Hystory hystory : hystorys) {
//            dao_hystory.delHystory(hystory);
//        }
//        userDao.deleteUser(userId);
        String firstNameUser = userDao.getUser(userId).getFirstName();
        String lastNameUser = userDao.getUser(userId).getLastName();
        deleteService.deleteUserService(userId);
//        mv.setViewName("admin"); 

        mv.addObject("msgDelUserSuc", "успешно удален!");
        mv.addObject("msgDelUserFirstName", firstNameUser);
        mv.addObject("msgDelUserLastName", lastNameUser);
        return mv;
    }

    @RequestMapping(value = "lookUsers")
    public ModelAndView lookUsers() {
        ModelAndView mv = new ModelAndView("lookUsers");
        List<User> users = userDao.getUsers();
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(value = "addRoomView")
    public ModelAndView adddRoomView() {
        ModelAndView mv = new ModelAndView("addRoomView");
        return mv;
    }
}
