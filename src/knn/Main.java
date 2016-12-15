package knn;

import knn.distance.EuclideanDistance;
import knn.utils.DataLoader;
import knn.utils.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by virgil on 23.01.2016.
 */
public class Main {

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();

        KNN knn = new KNN();
        knn.setDistance(new EuclideanDistance());
        knn.setPoints(dataLoader.loadDatasetFromCsv("knn_test_data.csv", ","));
        knn.setK(5);

        List<Double> coordinates = new ArrayList();
        coordinates.add(1d); coordinates.add(1d);
        Point newPoint = new Point();
        newPoint.setCoordinates(coordinates);
        System.out.println(knn.getClassification(newPoint));
    }

}
