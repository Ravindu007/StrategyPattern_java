interface propulsionStrategy{
    void drive();
}

//concrete strategy classes
class DrivingStrategy implements  propulsionStrategy{
    @Override
    public void drive() {
        System.out.println("Driving the car");
    }
}

class FlyingStrategy implements  propulsionStrategy{
    @Override
    public void drive() {
        System.out.println("Flying the plane");
    }
}

class SailingStrategy implements propulsionStrategy{
    @Override
    public void drive() {
        System.out.println("Sailing the boat");
    }
}


class Vehicle {

    //  reference to the interface
    private propulsionStrategy propulsionStrategy;

    //  constructor
    public Vehicle(propulsionStrategy propulsionStrategy){
        this.propulsionStrategy = propulsionStrategy;
    }

    //set method to dynamically set the propulsion method
    public void setPropulsionStrategy(propulsionStrategy propulsionStrategy){
        this.propulsionStrategy = propulsionStrategy;
    }

    public void drive(){
        propulsionStrategy.drive();  //driving method - according to propulsion method
    }

}


public class Main{
    public static void main(String[] args) {
        Vehicle car = new Vehicle(new DrivingStrategy());

        car.drive();   //output: Driving the car

        //setting propulsion strategy
        car.setPropulsionStrategy(new FlyingStrategy());
        car.drive();  //output: Flying the plane
    }
}
