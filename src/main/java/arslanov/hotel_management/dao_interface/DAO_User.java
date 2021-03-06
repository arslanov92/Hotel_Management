package arslanov.hotel_management.dao_interface;

/**
 *
 * @author Марат
 */
import arslanov.hotel_management.model.User;
import java.util.List;

public interface DAO_User {

    public List<User> getUsers();

    public void createNewUser(User user);

    public User getUser(long userId);

    public User findUser(String first_name, String last_name);

    public void deleteUser(long id);

    public User checkUserLogin(String login);

    public User checkUserPassword(String pwd);

    public User checkUserLoginAndPwd(String login, String pwd);

}
