package arslanov.hotel_management.model;
/**
 *
 * @author Марат
 */
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
    private Room holderRoom;

    @ManyToOne(optional=false)
    @JoinColumn(name="USERID")
    private User holderUser;
    
    
    @Temporal(TemporalType.DATE)
    public Date chekDate;
    @Temporal(TemporalType.DATE)
    public Date chekOutDate;
    

    public int getCheckedId() {
        return checkedId;
    }

    public void setCheckedId(int checkedId) {
        this.checkedId = checkedId;
    }

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
        this.holderRoom = room;
        this.holderUser = holderUser;
        this.chekDate = chekDate;
        this.chekOutDate = chekOutDate;
    }

    public void setChekOutDate(Date chekOutDate) {
        this.chekOutDate = chekOutDate;
    }
}
