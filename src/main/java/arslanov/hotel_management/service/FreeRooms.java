package arslanov.hotel_management.service;

import arslanov.hotel_management.dao_interface.DAO_CheckRoom;
import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.model.Room;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FreeRooms {

    @Autowired
    public DAO_CheckRoom checkRoomDAO;

    @Autowired
    public DAO_Room roomImplDAO;

    Logger logger = LoggerFactory.getLogger(FreeRooms.class);

    @Transactional
    public List<Room> getFreeRooms(Date chekDate, Date chekOutDate) {
        List<Room> chekedRooms = checkRoomDAO.getCheckedRooms(chekDate, chekOutDate);

        List<Room> rooms = roomImplDAO.getRooms();

        logger.info("all rooms:{}", rooms.toString());
        rooms.removeAll(chekedRooms);
        logger.info("chechked rooms:{}", chekedRooms.toString());
        logger.info("rooms:{}", rooms.toString());

        return rooms;

    }
}
