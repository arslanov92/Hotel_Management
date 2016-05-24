
package arslanov.hotel_management.dao_implements;

import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.model.Room;
import arslanov.hotel_management.model.User;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;


public class DAO_RoomImpl implements DAO_Room{
    
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(DAO_UserImpl.class);
    
    @Autowired    
    JpaTransactionManager txManager;
        
    @Override
    public List getRooms() {
        return em.createQuery("SELECT r from Room r").getResultList();
    }

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

    @Override
    public List<Date> getChekDate(long roomId) {
       Room r = em.find(Room.class, roomId);
       return em.createQuery("SELECT chekDate from Room r").getResultList();
    }

    @Override
    public void setChekDate(Date newDate, long roomId) {
        Room r = em.find(Room.class, roomId);
        r.chekDate=newDate;
        em.merge(r);
    }

    @Override
    public List<Date> getChekOutDate(long roomId) {
        Room r = em.find(Room.class, roomId);
        return em.createQuery("SELECT chekOutDate from Room r").getResultList();
    }

    @Override
    public void setChekOutDate(Date newDate, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
