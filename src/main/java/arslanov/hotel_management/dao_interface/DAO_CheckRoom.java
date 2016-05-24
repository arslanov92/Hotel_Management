
package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.Room;
import java.util.*;


public interface DAO_CheckRoom {
    public List<Room> getCheckedRooms(Date check, Date check_out);
    public void recordChekedRoom(long id_room);
}
