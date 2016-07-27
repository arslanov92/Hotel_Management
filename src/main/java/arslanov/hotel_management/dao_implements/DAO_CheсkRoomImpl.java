package arslanov.hotel_management.dao_implements;

import arslanov.hotel_management.dao_interface.*;
import arslanov.hotel_management.model.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("cheсkRoomDAO")
@Transactional
public class DAO_CheсkRoomImpl implements DAO_CheckRoom {

    @PersistenceContext
    private EntityManager em;

    Logger logger = LoggerFactory.getLogger(DAO_UserImpl.class);

//    @Autowired    
//    JpaTransactionManager txManager;
    @Override
    public List<Room> getCheckedRooms(Date fromTo, Date fromOut) {
        /*return em.createQuery("SELECT c.holderRoom from CheckRoom c WHERE (c.chekDate >= ? and c.chekDate <= ?) "
                + "OR (c.chekOutDate >= ? and c.chekOutDate <= ?) "
                + "OR (c.chekDate < ? and c.chekOutDate > ?)", Room.class)
                .setParameter(1, fromTo).setParameter(2, fromOut)
                .setParameter(3, fromTo).setParameter(4, fromOut)
                .setParameter(5, fromTo).setParameter(6, fromOut).getResultList();*/
        return getRooms(fromTo, fromOut).stream().map((CheckRoom r) -> r.getHolderRoom()).collect(Collectors.toList());
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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void recordNewCheсkedRoom(Room room, User user, Date chekDate, Date chekOutDate) {
        CheckRoom cR = new CheckRoom(room, user, chekDate, chekOutDate);
        logger.info("ROOM  !!!!!!!!!!!: {}", room.toString());
        logger.info("USER  !!!!!!!!!!!: {}", user.toString());
        em.merge(cR);
    }

    @Override
    public List<Date> getCheсkDate(long roomId) {
        return em.createQuery("SELECT chekDate Date from CheckRoom WHERE CHECKROOM.holderRoom.roomId =?")
                .setParameter(1, roomId).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void setCheсkDate(Date newDate, long roomId) {
        CheckRoom checkRoom = em.find(CheckRoom.class, roomId);
        checkRoom.setChekDate(newDate);
        em.merge(checkRoom);
    }

    @Override
    public List<Date> getCheсkOutDate(long roomId) {
//        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        return em.createQuery("SELECT chekOutDate Date from CheckRoom WHERE CHECKROOM.holderRoom.roomId =?")
                .setParameter(1, roomId).getResultList();
    }

    @Override
    public List<CheckRoom> getCheсkRoomWithRoomId(long roomId) {
//        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        return em.createQuery("SELECT c from CheckRoom c WHERE c.holderRoom.roomId =?", CheckRoom.class)
                .setParameter(1, roomId).getResultList();
    }

    @Override
    public List<CheckRoom> getCheсkRoomWithCheckedRoomId(long checkRoomId) {
//        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        return em.createQuery("SELECT c from CheckRoom c WHERE c.checkedId =?", CheckRoom.class)
                .setParameter(1, checkRoomId).getResultList();
    }

    @Override
    public List<CheckRoom> getCheсkRoomWithUserId(long userId) {
//        CheckRoom checkRoom= em.find(CheckRoom.class, roomId);
        return em.createQuery("SELECT C from CheckRoom C WHERE C.holderUser.userId = ?", CheckRoom.class)
                .setParameter(1, userId).getResultList();
    }

    @Override
    public CheckRoom getCheckRoomForCancelRev(Date fromTo, Date fromOut, long userId, long roomId) {
        return em.createQuery("SELECT C from CheckRoom C WHERE (C.holderUser.userId = ? "
                + "AND C.holderRoom.roomId=? AND C.chekDate=? and C.chekOutDate=?)"
                + "", CheckRoom.class).setParameter(1, userId).setParameter(2, roomId).setParameter(3, fromTo)
                .setParameter(4, fromOut).getSingleResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void setCheсkOutDate(Date newDate, long roomId) {
        CheckRoom checkRoom = em.find(CheckRoom.class, roomId);
        checkRoom.setChekOutDate(newDate);
        em.merge(checkRoom);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void setNewCheсkedRoom(CheckRoom checkRoom) {
        em.merge(checkRoom);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delCheсkedRoomWithRoom(CheckRoom cR) {
        em.remove(cR);
    }

}
