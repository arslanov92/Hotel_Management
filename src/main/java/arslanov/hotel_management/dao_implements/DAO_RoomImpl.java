
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
import javax.persistence.NoResultException;
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
//    
//    @Autowired    
//    JpaTransactionManager txManager;
        
    @Override
    public List getRooms() {
        return em.createQuery("SELECT r from Room r").getResultList();
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void storeNewRoom(Room room) {
        em.merge(room);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void deleteRoom(long roomId) {
//        Room r=em.find(Room.class, roomId);
        Room r =em.createQuery("select R from Room R where R.roomId = ?",Room.class)
                    .setParameter(1, roomId).getSingleResult();
        em.remove(r);   
    }

    @Override
    public Room getRoom(long roomId) {
        return em.find(Room.class,roomId);
    }
    
    @Override
    public Room lookUpRoom(int inputRoomNumber) {
        try {            
            Room r =em.createQuery("select R from Room R where R.roomNumber=? ",Room.class)
                    .setParameter(1, inputRoomNumber)
                .getSingleResult();    
            return r;            
        } catch (NoResultException e) {
            return null;
        } 
    }

}
