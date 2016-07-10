
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
    public List<CheckRoom> getRooms(Date fromTo, Date fromOut);
    public void recordNewCheсkedRoom(Room room, User user,Date chekDate, Date chekOutDate);
    public void setNewCheсkedRoom(CheckRoom checkRoom);
    public List<Date> getCheсkDate(long roomId);
    public void setCheсkDate(Date newDate,long roomId);
    public List<Date> getCheсkOutDate(long roomId);
    public void setCheсkOutDate(Date newDate,long roomId);
}
