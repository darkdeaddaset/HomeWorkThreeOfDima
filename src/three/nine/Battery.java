package three.nine;

public class Battery {
    private final double CAPACITY_MAX = 3000;
    private final double CAPACITY_MIN = 2000;
    private final double ENERGY;
    private double capacity;

    public Battery(double capacity){
        if (capacity >= CAPACITY_MIN && capacity <= CAPACITY_MAX){
            this.capacity = capacity;
        } else {
            this.capacity = CAPACITY_MAX;
        }
        ENERGY = capacity;
    }

    public void drain(double amount){
        if ((capacity - amount) < 0 || (capacity - amount) > CAPACITY_MAX){
            capacity = 0;
        }else {
            capacity -= amount;
        }
    }

    public void charge(){
        capacity = ENERGY;
    }

    public double getRemainingCapacity(){
        return capacity;
    }
}
