package arslanov.hotel_management.service;

import arslanov.hotel_management.dao_interface.DAO_Room;
import arslanov.hotel_management.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LookRoomService {

    @Autowired
    public DAO_Room roomImplDAO;

    public boolean lookRoom(int inputRoomNumber) {
        Room r = roomImplDAO.lookUpRoom(inputRoomNumber);
        if (r != null) {
            return true;
        } else {
            return false;
        }
    }
}
