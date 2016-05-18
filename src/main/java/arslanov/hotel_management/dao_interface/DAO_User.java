package arslanov.hotel_management.dao_interface;

import arslanov.hotel_management.model.User;

public interface DAO_User {      
    public void create_new_User(String firstname, String lastname);
    public User get_User(String firstname, String lastname);
    public void delete_User(int id);
    }
