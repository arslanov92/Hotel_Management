
package arslanov.hotel_management.dao_implements;

import arslanov.hotel_management.dao_interface.DAO_Hystory;
import arslanov.hotel_management.model.CheckRoom;
import arslanov.hotel_management.model.Hystory;
import arslanov.hotel_management.model.User;
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

/**
 *
 * @author Марат
 */
@Repository
public class DAO_HystoryImpl implements DAO_Hystory{
    
    @PersistenceContext
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(DAO_HystoryImpl.class);
    @Autowired    
    JpaTransactionManager txManager;
    @Override
    public List<Hystory> getHystory() {
        return em.createQuery("SELECT H from Hystory H").getResultList();
    }
    
    @Override
     public List<Hystory> getUserHystory(long holderUserId) {
        return em.createQuery("SELECT H from Hystory H where H.holderUser.userId = ?",Hystory.class)
                .setParameter(1, holderUserId).getResultList();
    }
     
    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void putNewHystory(Hystory hystory) {
        logger.info(this.getClass().getName());
        em.merge(hystory);
    }
    
    @Override
    public List<Hystory> getHystoryWithRoomId(long roomId) {
//        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        return em.createQuery("SELECT H from Hystory H WHERE H.holderRoom.roomId =?",Hystory.class)
                .setParameter(1, roomId).getResultList();
    }
    @Override
    public List<Hystory> getHystoryWithUserId(long userId) {
//        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        return em.createQuery("SELECT H from Hystory H WHERE H.holderUser.userId =?",Hystory.class)
                .setParameter(1, userId).getResultList();
    }
    
    @Override
    public void delHystory(Hystory hystory) {
                em.remove(hystory);
    }
//    @Transactional(propagation=Propagation.REQUIRED)
//    @Override
//    public void delHystoryWithUserId(long holderUserId) {
//        logger.info(this.getClass().getName());
//        Hystory hystory =em.createQuery("SELECT H from Hystory H where H.holderUser=?",Hystory.class)
//                .setParameter(1, holderUserId).getSingleResult();
//        em.remove(hystory);
//    }
//    
//    @Transactional(propagation=Propagation.REQUIRED)
//    @Override
//    public void delHystoryWithCheckRoomId(long checkedRoomId) {
//        logger.info(this.getClass().getName());
//        Hystory hystory =em.createQuery("SELECT H from Hystory H where H.holderCheckRoom=?",Hystory.class)
//                .setParameter(1, checkedRoomId).getSingleResult();
//        em.remove(hystory);
//    }
}
