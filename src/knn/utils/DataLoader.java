package knn.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class models a DataLoader
 * A DataLoader is an object that is used to load data from different files (csv, xml, etc.)
 * Created by virgil on 29.10.2015.
 */
public class DataLoader {

    private String filePath;

    /**
     * The DataLoader default constructor
     */
    public DataLoader() {
        this.filePath = "";
    }

    /**
     * The DataLoader constructor
     * @param filePath the path to the file from which the dataset is loaded
     */
    public DataLoader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Get the path to the file
     * @return the path to the file
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Set the path to the file
     * @param filePath the path to the file
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Load the dataset from the file whose path is filePath
     * @param delimiter the delimiter used in the .csv file
     * @return the dataset loaded from the file
     */
    public List<Point> loadDatasetFromCsv(String delimiter) {
        List<Point> dataset = new ArrayList();

        //Read csv and create the dataset
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath));

            String[] header = null;
            String line = "";

            int linesCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (linesCount == 0) {
                    header = values;
                }
                else {
                    Point point = new Point();
                    List<Double> coordinates = new ArrayList();
                    for (int i = 0; i < header.length; ++i) {
                        if (i < header.length - 1)
                            coordinates.add(Double.parseDouble(values[i]));
                        else
                            point.setLabel(values[i]);
                    }
                    point.setCoordinates(coordinates);
                    dataset.add(point);
                }
                ++linesCount;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    /**
     * Load the dataset from the file whose path is filePath
     * @param filePath the path to the file from which the dataset is loaded
     * @param delimiter the csv file delimiter
     * @return the dataset loaded from the file
     */
    public List<Point> loadDatasetFromCsv(String filePath, String delimiter) {
        this.setFilePath(filePath);

        List<Point> points = this.loadDatasetFromCsv(delimiter);
        return points;
    }

}
