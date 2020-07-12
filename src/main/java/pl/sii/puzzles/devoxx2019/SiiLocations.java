package pl.sii.puzzles.devoxx2019;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class SiiLocations {
    public static void main(String[] args) {
        List<Location> locations = Arrays.asList(
                new Location("Warsaw", 847),
                new Location("Gdansk", 910),
                new Location("Wroclaw", 478),
                new Location("Cracow", 504));

        //locations.add(new Location("Rzeszow", 50));
        //locations.add(new Location("Bydgoszcz", 36));

        Stream<Location> locationStream = locations.stream();

        System.out.println("Sii locations: " + locationStream.count());
        locationStream.max(comparing(l -> l.workers))
                      .ifPresent(l -> System.out.println(l.name));
    }
    //Lombok
    @AllArgsConstructor
    static class Location {
        String name;
        Integer workers;
    }
}


