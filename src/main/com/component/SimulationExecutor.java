package component;

import lombok.Builder;
import lombok.NonNull;
import model.Intersection;

@Builder
public class SimulationExecutor {

    @NonNull
    private final Intersection intersection;


}
