package arslanov.hotel_management.dao_implements;

import arslanov.hotel_management.dao_interface.*;
import arslanov.hotel_management.model.*;
import java.util.*;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class DAO_ChekRoomImpl implements DAO_CheckRoom{
  
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(DAO_UserImpl.class);
    
    @Autowired    
    JpaTransactionManager txManager;
        
    @Override
    public List<Room> getCheckedRooms(Date chekDate, Date chekOutDate) {
        return em.createQuery("SELECT c from CheckRoom c WHERE not (c.chekDate > ? and c.chekOutDate > ?) "
                + "(OR c.chekDate < ? and c.chekOutDate < ? )").setParameter(1, chekDate)
                .setParameter(3, chekDate).setParameter(2, chekOutDate).setParameter(4, chekOutDate).getResultList();
    }

    @Override
    public void recordNewChekedRoom(Room room, User user,Date chekDate, Date chekOutDate) {
      CheckRoom cR=new CheckRoom(room, user, chekDate, chekOutDate);
      em.merge(cR);
      
    }
    
        @Override
    public List<Date> getChekDate(long roomId) {              
       return em.createQuery("SELECT chekDate Date from CheckRoom WHERE CHECKROOM.holderRoom =?").setParameter(1, roomId).getResultList();
    }

    @Override
    public void setChekDate(Date newDate, long roomId) {
        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        checkRoom.chekDate=newDate;
        em.merge(checkRoom);
    }

    @Override
    public List<Date> getChekOutDate(long roomId) {
//        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        return em.createQuery("SELECT chekOutDate Date from CheckRoom WHERE CHECKROOM.holderRoom =?").setParameter(1, roomId).getResultList();
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void setChekOutDate(Date newDate, long roomId) {
        CheckRoom checkRoom = em.find(CheckRoom.class, roomId);
        checkRoom.chekOutDate=newDate;
        em.merge(checkRoom); 
    }

    @Override
    public void setNewChekedRoom(CheckRoom checkRoom) {
        em.merge(checkRoom);
    }
    
}
