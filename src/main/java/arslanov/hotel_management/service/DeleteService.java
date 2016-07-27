/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arslanov.hotel_management.service;

import arslanov.hotel_management.dao_interface.DAO_CheckRoom;
import arslanov.hotel_management.dao_interface.DAO_Hystory;
import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.dao_interface.DAO_User;
import arslanov.hotel_management.model.CheckRoom;
import arslanov.hotel_management.model.Hystory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Марат
 */
@Service
public class DeleteService {

    @Autowired
    public DAO_User userDao;
    @Autowired
    public DAO_Room roomDAO;
    @Autowired
    DAO_CheckRoom dao_CheckRoom;
    @Autowired
    DAO_Hystory dao_hystory;

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRoomService(long roomId) {
        List<CheckRoom> checkRooms = dao_CheckRoom.getCheсkRoomWithRoomId(roomId);
        for (CheckRoom checkRoom : checkRooms) {
            dao_CheckRoom.delCheсkedRoomWithRoom(checkRoom);
        }
        List<Hystory> hystorys = dao_hystory.getHystoryWithRoomId(roomId);
        for (Hystory hystory : hystorys) {
            dao_hystory.delHystory(hystory);
        }
//        if (roomDAO.) {
//            
//        }
        roomDAO.deleteRoom(roomId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCheckedRoomService(long roomId) {
        List<CheckRoom> checkRooms = dao_CheckRoom.getCheсkRoomWithCheckedRoomId(roomId);
        for (CheckRoom checkRoom : checkRooms) {
            dao_CheckRoom.delCheсkedRoomWithRoom(checkRoom);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserService(long userId) {
        List<CheckRoom> checkRooms = dao_CheckRoom.getCheсkRoomWithUserId(userId);
        for (CheckRoom checkRoom : checkRooms) {
            dao_CheckRoom.delCheсkedRoomWithRoom(checkRoom);
        }
        List<Hystory> hystorys = dao_hystory.getHystoryWithUserId(userId);
        for (Hystory hystory : hystorys) {
            dao_hystory.delHystory(hystory);
        }
        userDao.deleteUser(userId);
    }
}
