package arslanov.hotel_management.dao_implements;

import arslanov.hotel_management.dao_interface.*;
import arslanov.hotel_management.model.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("cheсkRoomDAO")
@Transactional
public class DAO_CheсkRoomImpl implements DAO_CheckRoom{
  
    @PersistenceContext
    private EntityManager em;
    
    Logger logger = LoggerFactory.getLogger(DAO_UserImpl.class);
    
//    @Autowired    
//    JpaTransactionManager txManager;
        
    @Override
    public List<Room> getCheckedRooms(Date fromTo, Date fromOut) {
        return em.createQuery("SELECT c.holderRoom from CheckRoom c WHERE (c.chekDate >= ? and c.chekDate <= ?) "
                + "OR (c.chekOutDate >= ? and c.chekOutDate <= ?) "
                + "OR (c.chekDate < ? and c.chekOutDate > ?)", Room.class)
                .setParameter(1, fromTo).setParameter(2, fromOut)
                .setParameter(3, fromTo).setParameter(4, fromOut)
                .setParameter(5, fromTo).setParameter(6, fromOut).getResultList();
    }
    
    @Override
    public List<CheckRoom> getRooms(Date fromTo, Date fromOut) {
        return em.createQuery("SELECT c from CheckRoom c WHERE (c.chekDate >= ? and c.chekDate <= ?) "
                + "OR (c.chekOutDate >= ? and c.chekOutDate <= ?) "
                + "OR (c.chekDate < ? and c.chekOutDate > ?)", CheckRoom.class)
                .setParameter(1, fromTo).setParameter(2, fromOut)
                .setParameter(3, fromTo).setParameter(4, fromOut)
                .setParameter(5, fromTo).setParameter(6, fromOut).getResultList();
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void recordNewCheсkedRoom(Room room, User user,Date chekDate, Date chekOutDate) {
      CheckRoom cR=new CheckRoom(room, user, chekDate, chekOutDate);
      em.merge(cR);
    }
    
        @Override
    public List<Date> getCheсkDate(long roomId) {              
       return em.createQuery("SELECT chekDate Date from CheckRoom WHERE CHECKROOM.holderRoom =?").setParameter(1, roomId).getResultList();
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void setCheсkDate(Date newDate, long roomId) {
        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        checkRoom.chekDate=newDate;
        em.merge(checkRoom);
    }

    @Override
    public List<Date> getCheсkOutDate(long roomId) {
//        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        return em.createQuery("SELECT chekOutDate Date from CheckRoom WHERE CHECKROOM.holderRoom =?").setParameter(1, roomId).getResultList();
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void setCheсkOutDate(Date newDate, long roomId) {
        CheckRoom checkRoom = em.find(CheckRoom.class, roomId);
        checkRoom.chekOutDate=newDate;
        em.merge(checkRoom); 
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void setNewCheсkedRoom(CheckRoom checkRoom) {
        em.merge(checkRoom);
    }
    
}
