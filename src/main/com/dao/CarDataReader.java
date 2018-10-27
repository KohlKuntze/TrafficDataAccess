package dao;

import model.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class CarDataReader {

    private static final String REGEX = "\t";

    public static void readCarsFromFile(String inputFilename, Consumer<Car> consumer) {
        try {
            File file = new File(inputFilename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] lineData = line.split(REGEX);

                Car currentCar = Car.builder()
                        .licensePlate(lineData[0])
                        .speedPropensity(Double.parseDouble(lineData[1]))
                        .build();

                consumer.accept(currentCar);
            }

            fileReader.close();

        } catch (IOException e) {

        }
    }

}
