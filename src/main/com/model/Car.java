package model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
@EqualsAndHashCode
public class Car {

    @NonNull
    private final String licensePlate;

    @NonNull
    private final Double speedPropensity;

}
