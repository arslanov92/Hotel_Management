package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.Hystory;

/**
 *
 * @author Марат
 */
public interface DAO_Hystory {
    public void setNewHystory(Hystory h);
    public Hystory getHystory(int userID);
    
}
