package knn.distance;

import java.util.List;

/**
 * Created by virgil on 23.01.2016.
 */
public class EuclideanDistance {

    public Double calculate(List<Double> firstCoordinates, List<Double> secondCoordinates) {
        double distance = 0;

        if (firstCoordinates.size() != secondCoordinates.size())
            return null;

        for (int i = 0; i < firstCoordinates.size(); ++i) {
            distance += Math.pow(firstCoordinates.get(i) - secondCoordinates.get(i), 2);
        }

        return Math.sqrt(distance);
    }
}
