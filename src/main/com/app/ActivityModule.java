package app;

import dao.IntersectionDataReader;
import model.Intersection;

public class ActivityModule {

    static Intersection getIntersection(String intersectionFilename) {
        return IntersectionDataReader.getIntersection(intersectionFilename);
    }

}
