package pl.sii.puzzles;

import java.time.*;

public class DateRiddle {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2016, 3, 27, 1, 20);
        localDateTime = localDateTime.plusHours(1);
        System.out.println(localDateTime);

        ZoneId zoneId = ZoneId.of("Europe/Warsaw");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
    }
}
