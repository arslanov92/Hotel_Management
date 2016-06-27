
package arslanov.hotel_management.dao_interface;
/**
 *
 * @author Марат
 */
import arslanov.hotel_management.model.CheckRoom;
import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.model.User;
import java.util.*;


public interface DAO_CheckRoom {
    public List<Room> getCheckedRooms(Date check, Date check_out);
    public void recordNewChekedRoom(Room room, User user,Date chekDate, Date chekOutDate);
    public void setNewChekedRoom(CheckRoom checkRoom);
    public List<Date> getChekDate(long roomId);
    public void setChekDate(Date newDate,long roomId);
    public List<Date> getChekOutDate(long roomId);
    public void setChekOutDate(Date newDate,long roomId);
}
