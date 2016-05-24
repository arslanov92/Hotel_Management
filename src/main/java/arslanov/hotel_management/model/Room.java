package arslanov.hotel_management.model;

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
