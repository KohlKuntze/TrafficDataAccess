package dao;

import model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.stream.Stream;

public class CarDataWriter {

    private static final String REGEX = "\t";
    private static final String NEXT_LINE = "\n";


    public static void writeCarsToFile(String outputFilename, Stream<Car> carStream) {
        try {
            Writer fileWriter = new FileWriter(outputFilename);

            carStream.forEach(car -> {
                String currentLine = String.join(REGEX,
                        car.getLicensePlate(),
                        car.getSpeedPropensity().toString(),
                        NEXT_LINE);
                try {
                    fileWriter.write(currentLine);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
