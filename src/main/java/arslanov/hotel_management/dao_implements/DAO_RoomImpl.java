
package arslanov.hotel_management.dao_implements;
/**
 *
 * @author Марат
 */
import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.model.User;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DAO_RoomImpl implements DAO_Room{
    @PersistenceContext
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(DAO_UserImpl.class);
    
    @Autowired    
    JpaTransactionManager txManager;
        
    @Override
    public List getRooms() {
        return em.createQuery("SELECT r from Room r").getResultList();
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void storeNewRoom(Room room) {
        em.merge(room);
    }

    @Override
    public void deleteRoom(long id) {
        Room r=em.find(Room.class, id);
        em.remove(r);   
    }

    @Override
    public Room getRoom(long roomId) {
        return em.find(Room.class,roomId);
    }

}
