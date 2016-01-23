package knn.distance;

import java.util.List;

/**
 * Created by virgil on 23.01.2016.
 */
public interface Distance {

    public Double calculate(List<Double> firstCoordinates, List<Double> secondCoordinates);

}
