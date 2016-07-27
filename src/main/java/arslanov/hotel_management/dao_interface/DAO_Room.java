package arslanov.hotel_management.dao_interface;

/**
 *
 * @author Марат
 */
import arslanov.hotel_management.model.Room;
import java.util.*;
import org.springframework.stereotype.Repository;

public interface DAO_Room {

    public List<Room> getRooms();

    public void storeNewRoom(Room room);

    public void deleteRoom(long id);

    public Room getRoom(long roomId);

    public Room lookUpRoom(int inputRoomNumber);
}
