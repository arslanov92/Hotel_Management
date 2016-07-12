
package arslanov.hotel_management.dao_implements;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Марат
 */
@Repository
public class DAO_HystoryImpl {
    @PersistenceContext
    private EntityManager em;
    
    @Autowired    
    JpaTransactionManager txManager;
    
}
