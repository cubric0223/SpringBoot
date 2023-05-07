package dev.cubric;

public class SmallCar extends AbstractCar implements CarInterface{
    private Driver driver;
    @Override
    public void setDriver(Driver driver) {
        if(driver.getLicence() < 1){
            throw new RuntimeException("insufficient license");
        }
        this.driver = driver;
    }

    @Override
    public void accelerate() {
        this.velocity += 10;
    }

    @Override
    public void brake() {
        this.velocity -= 10;
        super.brake();
    }
}
