package arslanov.hotel_management.model;
/**
 *
 * @author Марат
 */
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
@Entity
@Table(name="ChekedRooms")

public class CheckRoom {
    @Id
    @GeneratedValue
    @Column(name="CHECKED_ID")
    long checkedId;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="ROOMID")
    private Room holderRoom;

    @ManyToOne(optional=false)
    @JoinColumn(name="USERID")
    private User holderUser;
    
    
    @Temporal(TemporalType.DATE)
    public Date chekDate;
    @Temporal(TemporalType.DATE)
    public Date chekOutDate;
    

    public long getCheckedId() {
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

    public CheckRoom() {
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CheckRoom other = (CheckRoom) obj;
        if (!Objects.equals(this.holderRoom, other.holderRoom)) {
            return false;
        }
        if (!Objects.equals(this.holderUser, other.holderUser)) {
            return false;
        }
        if (!Objects.equals(this.chekDate, other.chekDate)) {
            return false;
        }
        if (!Objects.equals(this.chekOutDate, other.chekOutDate)) {
            return false;
        }
        return true;
        
    }

    @Override
    public String toString() {
        return "CheckRoom{" + "checkedId=" + checkedId + ", holderRoom=" + holderRoom + ", holderUser=" + holderUser + ", chekDate=" + chekDate + ", chekOutDate=" + chekOutDate + '}';
    }
    
}
