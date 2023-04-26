package client;

import java.util.Collection;

/**
 * @author bazz
 * Apr 22 2023
 * 15:55
 */
public class CarsDto {

    private Collection<CarDto> cars;

    public CarsDto(Collection<CarDto> cars) {
        this.cars = cars;
    }

    public Collection<CarDto> getCars() {
        return cars;
    }

    public void setCars(Collection<CarDto> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Car List{" +
                "cars=" + cars +
                '}';
    }
}
