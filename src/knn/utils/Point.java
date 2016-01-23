package knn.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by virgil on 23.01.2016.
 */
public class Point {

    private List<Double> coordinates;
    private String label;

    public Point(List<Double> coordinates, String label) {
        this.coordinates = coordinates;
        this.label = label;
    }

    public Point() {
        this.coordinates = new ArrayList();
        this.label = "";
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
