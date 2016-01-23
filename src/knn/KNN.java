package knn;

import knn.distance.Distance;
import knn.utils.Point;
import knn.utils.Pair;

import java.util.*;

/**
 * Created by virgil on 23.01.2016.
 */
public class KNN {

    private List<Point> points;
    private int k;
    private Distance distance;

    private Map<Integer, List<Pair<Integer, Double>>> allDistances; //Point index and the list of neighbours + the distances

    public KNN(List<Point> points, int k) {
        this.points = points;
        this.k = k;

        this.allDistances = null;
    }

    public KNN() {
        this.points = new ArrayList();
        this.k = 1;

        this.allDistances = null;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Map<Integer, List<Pair<Integer, Double>>> getAllDistances() {
        return allDistances;
    }

    public void setAllDistances(Map<Integer, List<Pair<Integer, Double>>> allDistances) {
        this.allDistances = allDistances;
    }

    public void calculateAllDistances() {
        for (int firstPointIndex = 0; firstPointIndex < points.size(); ++firstPointIndex) {
            //calculateDistances(firstPointIndex);

            for (int secondPointIndex = 0; secondPointIndex < points.size(); ++secondPointIndex) {
                if (secondPointIndex != firstPointIndex) {
                    double distanceBetweenPoints = distance.calculate(
                            points.get(firstPointIndex).getCoordinates(),
                            points.get(secondPointIndex).getCoordinates());

                    Pair pointAndDistance = new Pair<Integer, Double>(secondPointIndex, distanceBetweenPoints);

                    if (allDistances.get(firstPointIndex) == null) {
                        List<Pair<Integer, Double>> neighboursAndDistances = new ArrayList();
                        allDistances.put(firstPointIndex, neighboursAndDistances);
                    }
                    allDistances.get(firstPointIndex).add(pointAndDistance);
                }
            }
        }
    }

    private void calculateDistances(int firstPointIndex) {
        for (int secondPointIndex = 0; secondPointIndex != firstPointIndex && secondPointIndex < points.size(); ++secondPointIndex) {
            double distanceBetweenPoints = distance.calculate(
                            points.get(firstPointIndex).getCoordinates(),
                            points.get(secondPointIndex).getCoordinates());

            Pair pointAndDistance = new Pair<Integer, Double>(secondPointIndex, distanceBetweenPoints);

            if (allDistances.get(firstPointIndex) == null) {
                List<Pair<Integer, Double>> neighboursAndDistances = new ArrayList();
                allDistances.put(firstPointIndex, neighboursAndDistances);
            }
            allDistances.get(firstPointIndex).add(pointAndDistance);
        }
    }

    private List<Integer> getClosestNeighbours(int pointIndex) {
        if (this.allDistances == null) {
            this.allDistances = new HashMap();
            calculateAllDistances();
        }

        List<Integer> closestNeighboursIndexes = new ArrayList();
        List<Pair<Integer, Double>> allNeighboursDistances = allDistances.get(pointIndex);

        Collections.sort(allNeighboursDistances, new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return pair1.getSecond().compareTo(pair2.getSecond());
            }
        });

        for (int i = 0; i < k; ++i) {
            closestNeighboursIndexes.add(allNeighboursDistances.get(i).getFirst());
        }

        return closestNeighboursIndexes;
    }

    public String getClassification(int pointIndex) {
        String classification = "";

        Map<String, Integer> countClasses = new HashMap();

        List<Integer> closestNeighboursIndexes = getClosestNeighbours(pointIndex);
        for (int i = 0; i < closestNeighboursIndexes.size(); ++i) {
            String label = points.get(closestNeighboursIndexes.get(i)).getLabel();
            if (countClasses.get(label) == null)
                countClasses.put(label, 0);
            countClasses.put(label, countClasses.get(label) + 1);
        }

        int max = 0;
        for (String label : countClasses.keySet()) {
            if (countClasses.get(label) > max) {
                max = countClasses.get(label);
                classification = label;
            }
        }

        return classification;
    }

}
