
package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.Room;
import java.util.*;


public interface DAO_Room {
    public List getRooms();
    public void storeNewRoom(Room room);
    public void deleteRoom(long id);
    public Room getRoom(long id);   
    public Date getChekDate(long id);
    public Date setChekDate(long id);
    public Date getChekOutDate(long id);
    public Date setChekOutDate(long id);
    
}
