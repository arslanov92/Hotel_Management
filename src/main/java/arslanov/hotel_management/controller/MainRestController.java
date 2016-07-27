package arslanov.hotel_management.controller;

import arslanov.hotel_management.dao_interface.DAO_CheckRoom;
import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.service.FreeRooms;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MainRestController {

    @Autowired
    FreeRooms fRooms;
    @Autowired
    DAO_CheckRoom checkRoom;
    @Autowired
    DAO_Room dAO_Room;

    private static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

//    @RequestMapping(path = "/api/test", method = RequestMethod.GET,
//            produces = "application/json")
//    public Room test()
//            {
//                return new Room();
//            }
    @RequestMapping(path = "/api/freeRoom", method = RequestMethod.GET,
            produces = "application/json")
    public @ResponseBody
    List<Room> getRooms(@RequestParam String CheckDate, @RequestParam String CheckOutDate) {
//    public @ResponseBody List<Room> getRooms() {
        String strCheckDate = CheckDate;
        String strCheckOutDate = CheckOutDate;
        List<Room> rooms = new ArrayList<>();
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
//                mv.addObject("msg", "Ой!!");
//                mv.addObject("details", "Дата заселения указана раньше, чем дата выселения :) !");
                return null;
            }
            //FreeRooms fRooms= new FreeRooms();
            rooms = fRooms.getFreeRooms(chekDate, chekOutDate);
        }
        // rooms=dAO_Room.getRooms();
        return rooms;
    }
}
