import java.util.ArrayList;

public class DistanceFinder {

    public static double distanceBetweenPops(Pop A, Pop B) {
        double deltaX = A.getCord_x() - B.getCord_x();
        double deltaY = A.getCord_y() - B.getCord_y();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
    //2 metets
    public static Pop findClosestSickPop(Pop origin, Population population) {
        if (population.getPopulation().size() == 0)
            return null;
        Pop closestPop = null;

        for(Pop p : population.getPopulation()) {
            if(p.getState() instanceof SickNoSymptoms || p.getState() instanceof SickWithSymptoms) {
                closestPop = p;
                break;
            }
        }
        if(closestPop == null)
            return null;

        double closestDistance = distanceBetweenPops(origin, closestPop);

        for(int i = 1;i < population.getPopulation().size(); i++) {
            if(population.get(i).getState() instanceof SickNoSymptoms || population.get(i).getState() instanceof SickWithSymptoms) {
                double distance = distanceBetweenPops(origin, population.get(i));
                if (distance < closestDistance) {
                    closestPop = population.get(i);
                    closestDistance = distance;
                }
            }
        }
        return closestPop;
    }
}
