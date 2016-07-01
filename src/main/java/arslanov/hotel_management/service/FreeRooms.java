
package arslanov.hotel_management.service;

import arslanov.hotel_management.dao_implements.DAO_ChekRoomImpl;
import arslanov.hotel_management.dao_implements.DAO_RoomImpl;
import arslanov.hotel_management.model.Room;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class FreeRooms {
    
    @Autowired
    public DAO_ChekRoomImpl checkRoomDAO;
    @Autowired
    public DAO_RoomImpl roomImplDAO;
    
    public List<Room> getFreeRooms(Date chekDate, Date chekOutDate)
    {
        List<Room> chekedRooms = new ArrayList<Room>();        
        chekedRooms = checkRoomDAO.getCheckedRooms(chekDate, chekOutDate);
        
        List<Room> rooms = new ArrayList<Room>();
        rooms=roomImplDAO.getRooms();
                
        rooms.removeAll(chekedRooms);
        return rooms;
    }
}
