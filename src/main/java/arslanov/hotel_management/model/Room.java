package arslanov.hotel_management.model;

public class Room {
   
    private final int number;
//    private int year_c;
//    private int month_c;
//    private int day_c;
//    private int year_co;
//    private int month_co;
//    private int day_co;
    private int[] data_check = {0,0,0};
    private int [] data_check_out ={0,0,0}; 
    private double price;

    public int[] getData_check() {
        return data_check;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Room(int numb,double price) {
        this.number = numb;
        this.price = price;
    }
    
}
