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
        knn.setK(1);

        System.out.println(knn.getClassification(7));
    }

    private static List<Point> initData() {
        List<Point> data = new ArrayList();

        List<Double> coordinatesA = new ArrayList();
        coordinatesA.add(-1.0); coordinatesA.add(1.0);

        List<Double> coordinatesB = new ArrayList();
        coordinatesB.add(-1.0); coordinatesB.add(2.0);

        List<Double> coordinatesC = new ArrayList();
        coordinatesC.add(0.0); coordinatesC.add(2.0);

        List<Double> coordinatesD = new ArrayList();
        coordinatesD.add(0.0); coordinatesD.add(3.0);

        List<Double> coordinatesE = new ArrayList();
        coordinatesE.add(1.0); coordinatesE.add(3.0);

        List<Double> coordinatesF = new ArrayList();
        coordinatesF.add(1.0); coordinatesF.add(-1.0);

        List<Double> coordinatesG = new ArrayList();
        coordinatesG.add(2.0); coordinatesG.add(-1.0);

        List<Double> coordinatesH = new ArrayList();
        coordinatesH.add(2.0); coordinatesH.add(0.0);

        List<Double> coordinatesI = new ArrayList();
        coordinatesI.add(3.0); coordinatesI.add(0.0);

        List<Double> coordinatesJ = new ArrayList();
        coordinatesJ.add(3.0); coordinatesJ.add(1.0);

        Point pointA = new Point();
        pointA.setCoordinates(coordinatesA); pointA.setLabel("o");

        Point pointB = new Point();
        pointB.setCoordinates(coordinatesB); pointB.setLabel("+");

        Point pointC = new Point();
        pointC.setCoordinates(coordinatesC); pointC.setLabel("o");

        Point pointD = new Point();
        pointD.setCoordinates(coordinatesD); pointD.setLabel("+");

        Point pointE = new Point();
        pointE.setCoordinates(coordinatesE); pointE.setLabel("o");

        Point pointF = new Point();
        pointF.setCoordinates(coordinatesF); pointF.setLabel("+");

        Point pointG = new Point();
        pointG.setCoordinates(coordinatesG); pointG.setLabel("o");

        Point pointH = new Point();
        pointH.setCoordinates(coordinatesH); pointH.setLabel("+");

        Point pointI = new Point();
        pointI.setCoordinates(coordinatesI); pointI.setLabel("o");

        Point pointJ = new Point();
        pointJ.setCoordinates(coordinatesJ); pointJ.setLabel("+");

        data.add(pointA);
        data.add(pointB);
        data.add(pointC);
        data.add(pointD);
        data.add(pointE);
        data.add(pointF);
        data.add(pointG);
        data.add(pointH);
        data.add(pointI);
        data.add(pointJ);

        return data;
    }
}
