
package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.Room;
import java.util.*;


public interface DAO_Room {
    public List getRooms();
    public void storeNewRoom(Room room);
    public void deleteRoom(long id);
    public Room getRoom(long roomId);    
    public List<Date> getChekDate(long roomId);
    public void setChekDate(Date newDate,long roomId);
    public List<Date> getChekOutDate(long roomId);
    public void setChekOutDate(Date newDate,long roomId);
    
}
