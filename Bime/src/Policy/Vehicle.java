package Policy;

import java.io.Serializable;

public class Vehicle implements Serializable {
    int plateNB;
    int modelYear;
    String manufacture;
    int estimatedValue;
    int CarDamage;

    public Vehicle(int plateNB, int modelYear, String manufacture, int estimatedValue, int carDamage) {
        this.plateNB = plateNB;
        this.modelYear = modelYear;
        this.manufacture = manufacture;
        this.estimatedValue = estimatedValue;
        CarDamage = carDamage;
    }

    public int getPlateNB() {
        return plateNB;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getManufacture() {
        return manufacture;
    }

    public int getEstimatedValue() {
        return estimatedValue;
    }

    public int getCarDamage() {
        return CarDamage;
    }

    public void setCarDamage(int carDamage) {
        CarDamage = carDamage;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNB=" + plateNB +
                ", modelYear=" + modelYear +
                ", manufacture='" + manufacture + '\'' +
                ", estimatedValue=" + estimatedValue +
                ", CarDamage=" + CarDamage +
                '}';
    }
}
