
package arslanov.hotel_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String first_name;
    private String last_name;
    private int[] data_check = {0,0,0};
    private int [] data_check_out ={0,0,0};
    public double cost;   


    public int[] getData_check() {
        return data_check;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setData_check(int[] data_check) {
        this.data_check = data_check;
    }

    public int[] getData_check_out() {
        return data_check_out;
    }

    public void setData_check_out(int[] data_check_out) {
        this.data_check_out = data_check_out;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
}
