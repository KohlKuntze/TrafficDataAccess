package model;


import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    private static final String LICENSE_PLATE_ONE = "WSK4747";

    private static final Double SPEED_PROPENSITY_ONE = 1.05;

    @Test
    public void construtorTestOne() {
        Car carOne = Car.builder()
                .licensePlate(LICENSE_PLATE_ONE)
                .speedPropensity(SPEED_PROPENSITY_ONE)
                .build();

        Assert.assertEquals(LICENSE_PLATE_ONE, carOne.getLicensePlate());
        Assert.assertEquals(SPEED_PROPENSITY_ONE, carOne.getSpeedPropensity());

    }
}
