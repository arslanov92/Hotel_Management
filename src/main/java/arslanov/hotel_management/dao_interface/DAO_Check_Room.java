
package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.Room;
import java.util.*;


public interface DAO_Check_Room {
    public List<Room> getCheckedRooms(Date check, Date check_out);
    public void recordChekedRoom(long id_room);
}
