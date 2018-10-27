package dao;

import model.Car;
import model.Intersection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IntersectionDataReader {

    private static final String REGEX = "\t";

    public static Intersection getIntersection(String intersectionFilename) {
        Intersection intersection = null;
        try {
            File file = new File(intersectionFilename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            boolean lanesMade = false;
            List<Queue<Car>> laneList = new ArrayList<>();
            List<Double> timeList = new ArrayList<>();
            List<List<Integer>> laneOrder = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                if(lanesMade == false) {
                    laneList = createLaneList(Integer.parseInt(line));
                    lanesMade = true;
                } else {
                    String[] lineData = line.split(REGEX);
                    List<Integer> currentInstructions = new ArrayList<>();
                    timeList.add(Double.parseDouble(lineData[0]));

                    for(int i = 1; i < lineData.length; i++) {
                        currentInstructions.add(Integer.parseInt(lineData[i]));
                    }

                    laneOrder.add(currentInstructions);
                }
            }

            intersection = Intersection.builder()
                    .lanes(laneList)
                    .times(timeList)
                    .laneOrder(laneOrder)
                    .build();

            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return intersection;
    }

    private static List<Queue<Car>> createLaneList(int numOfLanes) {
        List<Queue<Car>> laneList = new ArrayList<>();

        for(int i = 0; i < numOfLanes; i++) {
            laneList.add(new LinkedList<>());
        }

        return laneList;
    }
}
