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
       
    private final long number;
    public String type;
    public double price;
    public int bed;

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
    
    public String getType() {
        return type;
    }

    public long getNumber() {
        return number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room(int number, String type, double price) {
        this.price=price;
        this.type=type;
        this.number = number;
    }    
    
}
