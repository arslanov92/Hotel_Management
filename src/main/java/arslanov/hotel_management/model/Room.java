package arslanov.hotel_management.model;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="ROOMS")
public class Room {
    @Id
    @GeneratedValue        
    @Column(name="ROOM_ID")
    private long room_id;
    
       
    private final int number;
    public String type;
    public double price;   

    
    public Room(int number, String type, double price) {
        this.price=price;
        this.type=type;
        this.number = number;
    }    
    
}
