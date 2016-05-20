
package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.Admin;
import java.util.*;


public interface DAO_Admin {
    public void storeNewAdmin();
    public void deleteAdmin(long admin_id);
    public Admin getAdmin(long id);
    public List<Admin> getAdmins();
}
