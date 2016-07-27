package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.Hystory;
import arslanov.hotel_management.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Марат
 */
public interface DAO_Hystory {

    public List<Hystory> getHystory();

    public List<Hystory> getUserHystory(long holderUserId);

    public void putNewHystory(Hystory hystory);

    public List<Hystory> getHystoryWithRoomId(long roomId);

    public void delHystory(Hystory hystory);

    public List<Hystory> getHystoryWithUserId(long userId);
//    public void delHystoryWithUserId(long holderUserId);
//    public void delHystoryWithCheckRoomId(long checkedRoomId);
}
