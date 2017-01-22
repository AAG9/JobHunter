import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chiko on 1/19/2017.
 */
public class ClosestKCPoints {
    class CPoint{
        public double x;
        public double y;
    }

    public static CPoint[] closestK(CPoint[] myList, int k){
        Map<Double, CPoint> cPointMap = createTreeMap(myList);
        return getKClosestCPoints(cPointMap,k);
    }

    public static Map<Double, CPoint> createTreeMap(CPoint[] myList){
        Map<Double, CPoint> cPointMap = new TreeMap<>();

        for(int i=0; i<myList.length; i++){
            double x = myList[i].x;
            double y = myList[i].y;

            double distanceFromOrigin = Math.sqrt(x*x + y*y);
            cPointMap.put(distanceFromOrigin,myList[i]);
        }

        return cPointMap;
    }

    public static CPoint[] getKClosestCPoints(Map<Double, CPoint> cPointMap, int k){
        int count = 0;
        CPoint[] cPoints = new CPoint[k];

        for(Map.Entry<Double, CPoint> entry: cPointMap.entrySet()){
            if(count < k){
                cPoints[count++] = entry.getValue();
            }
        }
        return cPoints;
    }
}
