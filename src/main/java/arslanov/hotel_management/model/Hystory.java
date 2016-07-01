package arslanov.hotel_management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HYSTORY")

public class Hystory {
    @Id
    @GeneratedValue
    @Column(name="HYSTORY_ID")
    int hystoryID;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="CHECK_ROOM_ID",unique=true)
    private CheckRoom holderCheckRoom;

    @ManyToOne(optional=false)
    @JoinColumn(name="USERID")
    private User holderUser;

    public CheckRoom getHolderCheckRoom() {
        return holderCheckRoom;
    }

    public void setHolderCheckRoom(CheckRoom holderCheckRoom) {
        this.holderCheckRoom = holderCheckRoom;
    }

    public User getHolderUser() {
        return holderUser;
    }

    public void setHolderUser(User holderUser) {
        this.holderUser = holderUser;
    }

}
