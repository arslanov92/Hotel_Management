
package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.Room;
import java.util.*;


public interface DAO_Room {
    public List getRooms();
    public void storeNewRoom(Room room);
    public void deleteRoom(long id);
    public Room getRoom(long roomId);  
    
}
