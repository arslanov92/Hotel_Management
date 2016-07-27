package arslanov.hotel_management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "HYSTORY")

public class Hystory {

    @Id
    @GeneratedValue
    @Column(name = "HYSTORY_ID")
    private int hystoryID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ROOM_ID")
    private Room holderRoom;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USERID")
    private User holderUser;

    @Temporal(TemporalType.DATE)
    private Date chekDate;

    @Temporal(TemporalType.DATE)
    private Date chekOutDate;

    public Room getHolderRoom() {
        return holderRoom;
    }

    public void setHolderRoom(Room holderRoom) {
        this.holderRoom = holderRoom;
    }

    public User getHolderUser() {
        return holderUser;
    }

    public void setHolderUser(User holderUser) {
        this.holderUser = holderUser;
    }

    public int getHystoryID() {
        return hystoryID;
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

    public void setChekOutDate(Date chekOutDate) {
        this.chekOutDate = chekOutDate;
    }

    public Hystory() {
    }

    public Hystory(Room holderRoom, User holderUser, Date chekDate, Date chekOutDate) {
        this.holderRoom = holderRoom;
        this.holderUser = holderUser;
        this.chekDate = chekDate;
        this.chekOutDate = chekOutDate;
    }

    @Override
    public String toString() {
        return "Hystory{" + "hystoryID=" + hystoryID + ", holderRoom=" + holderRoom + ", holderUser=" + holderUser + ", chekDate=" + chekDate + ", chekOutDate=" + chekOutDate + '}';
    }

}
