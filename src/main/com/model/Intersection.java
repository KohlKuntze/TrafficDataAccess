package model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Queue;

@Builder
@Getter
public class Intersection {

    @NonNull
    private final List<Queue<Car>> lanes;

    @NonNull
    private final List<Double> times;

    @NonNull
    private final List<List<Integer>> laneOrder;
}
