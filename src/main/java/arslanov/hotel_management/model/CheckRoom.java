package arslanov.hotel_management.model;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name="ChekedRooms")

public class CheckRoom {
    @Id
    @GeneratedValue
    @Column(name="CHECKED_ID")
    int checkedId;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="ROOMID",unique=true)
    private Room room;

    @ManyToOne(optional=false)
    @JoinColumn(name="USERID")
    private User holderUser;
    
}
