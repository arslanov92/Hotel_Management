package arslanov.hotel_management.model;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="ROOMS")
public class Room {
    @Id
    @GeneratedValue        
    @Column(name="ROOM_ID")
    private long roomId;    
       
    private int roomNumber;
    public String typeRoom;
    public int bed;
    public BigDecimal price;
    

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
    
    public String getTypeRoom() {
        return typeRoom;
    }

    public long getRoomId() {
        return roomId;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Room() {
    }

    public Room(int roomNumber, String typeRoom, int bed, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.typeRoom = typeRoom;
        this.bed = bed;
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Room other = (Room) obj;
        if (this.roomNumber != other.roomNumber) {
            return false;
        }
        if (this.bed != other.bed) {
            return false;
        }
        if (!Objects.equals(this.typeRoom, other.typeRoom)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }           

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", typeRoom=" + typeRoom + ", bed=" + bed + ", price=" + price + '}';
    }
    
}
