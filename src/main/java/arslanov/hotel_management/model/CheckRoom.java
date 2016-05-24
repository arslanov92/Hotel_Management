package arslanov.hotel_management.model;

import java.io.Serializable;
import java.util.Date;
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

    public int getCheckedId() {
        return checkedId;
    }

    public void setCheckedId(int checkedId) {
        this.checkedId = checkedId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getHolderUser() {
        return holderUser;
    }

    public void setHolderUser(User holderUser) {
        this.holderUser = holderUser;
    }

    public Date getChekDate() {
        return chekDate;
    }

    public void setChekDate(Date chekDate) {
        this.chekDate = chekDate;
    }

    public Date getChekOutDate() {
        return chekOutDate;
    }

    public CheckRoom(Room room, User holderUser, Date chekDate, Date chekOutDate) {
        this.room = room;
        this.holderUser = holderUser;
        this.chekDate = chekDate;
        this.chekOutDate = chekOutDate;
    }

    public void setChekOutDate(Date chekOutDate) {
        this.chekOutDate = chekOutDate;
    }
    
    public Date chekDate;
    public Date chekOutDate;
}
