package arslanov.hotel_management.model;
/**
 *
 * @author Марат
 */
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="ROOMS")
public class Room {
    @Id
    @GeneratedValue        
    @Column(name="ROOM_ID")
    private long roomId;    
       
    private long roomNumber;
    public String typeRoom;
    public int bed;
    public double price;
    

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
    
    public String getTypeRoom() {
        return typeRoom;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room(int number, String type, double price) {
        this.price=price;
        this.typeRoom=type;
        this.roomNumber = number;
    }    
    
}
