package arslanov.hotel_management.dao_implements;
/**
 *
 * @author Марат
 */
import arslanov.hotel_management.dao_interface.DAO_User;
import arslanov.hotel_management.model.User;
import java.util.List;
import javax.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class DAO_UserImpl implements DAO_User{

    @PersistenceContext
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(DAO_UserImpl.class);
    
    //@Autowired    
   // JpaTransactionManager txManager;
    
    @Override    
    public List<User> getUsers() {
        return em.createQuery("SELECT u from User u ").getResultList();
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void createNewUser(User user) {
        logger.info(this.getClass().getName());
        em.merge(user);
    }
    

    @Override
    public User getUser(long userId) {
        return em.find(User.class,userId);
    }
    

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public void deleteUser(long id) {
        User u = em.find(User.class, id);
        em.remove(u);        
    }

    @Override
    public User findUser(String first_name, String last_name) {
        //User u = em.find(User.class, );
        User u =em.createQuery("select from User U where U.firstName and U.lastName=?",User.class)
                .setParameter(1, first_name)
                .setParameter(2, last_name)
                .getSingleResult();
        return u;
    }
    @Override
    public User checkUserPassword(String pwd) {
        try {
            User u =em.createQuery("select U from User U where U.pwd=?",User.class).setParameter(2, pwd)
                .getSingleResult();    
        return u;
        } catch (IllegalArgumentException e) {
             return null;
        }               
    }
    @Override
    public User checkUserLogin(String login) {
        try {            
            User u =em.createQuery("select U from User U where U.login=?",User.class).setParameter(1, login)
                .getSingleResult();    
            return u;            
        } catch (NoResultException e) {
            return null;
        }
 
    }
    public User checkUserLoginAndPwd(String login, String pwd) {
        try {            
            User u =em.createQuery("select U from User U where U.login=? and U.pwd=?",User.class).setParameter(1, login).setParameter(2, pwd)
                .getSingleResult();    
            return u;            
        } catch (Exception e) {
            return null;
        } 
    }
    
}

    
