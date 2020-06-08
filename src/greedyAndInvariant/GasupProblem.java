package greedyAndInvariant;

import java.util.ArrayList;
import java.util.List;

public class GasupProblem {

    private static class CityAndRemainingGas {
        public Integer city;
        public Integer remainingGallons ;
        public CityAndRemainingGas(Integer city, Integer remainingGallons) {
            this.city = city;
            this.remainingGallons = remainingGallons;
        }
    }
    private static final int MPG = 20;
// gallons[ij is the amount of gas in city i, and distances[i] is the distance

    // city i to the next city.
    public static CityAndRemainingGas findAmpleCity (List<Integer> gallons,
                                     List <Integer> distances) {
        int remainingGallons = 0;
        CityAndRemainingGas min = new CityAndRemainingGas(0 ,0 );
        final int numCities = gallons.size();
        for (int i = 1; i < numCities; ++i) {
            remainingGallons += gallons.get(i - 1) - distances.get(i - 1) / MPG;
            if (remainingGallons < min.remainingGallons) {
                min = new CityAndRemainingGas(i, remainingGallons);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> gallons=new ArrayList<>();
        List<Integer> distances=new ArrayList<>();
        gallons.add(10);gallons.add(10);gallons.add(50); gallons.add(20);gallons.add(5);gallons.add(30);gallons.add(25);
        distances.add(200);distances.add(100);distances.add(900);distances.add(600);distances.add(200);distances.add(400);distances.add(600);
        CityAndRemainingGas ampleCity = findAmpleCity(gallons, distances);
        System.out.println(ampleCity.city +" "+ampleCity.remainingGallons);
    }
}
