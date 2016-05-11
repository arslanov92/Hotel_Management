
package arslanov.hotel_management.model;

import java.util.HashMap;
import java.util.Map;



public class VIP_User extends User{
    protected int discount;
    public Map history= new HashMap();  

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Map getHistory() {
        return history;
    }

    public void setHistory(Map history) {
        this.history = history;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
