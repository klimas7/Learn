package pl.klimas7.learn.hour;

import java.time.LocalTime;

public class Hour {
    public LocalTime getMaxHour(Integer ... argss) throws IllegalArgumentException {
        if (argss == null) {
            throw new IllegalArgumentException("Input parameter can't be null");
        }

        if (argss.length != 4) {
            throw new IllegalArgumentException("Must specified 4 parameters");
        }

        int hour = 0;
        int minute = 0;
        return LocalTime.of(hour, minute);
    }
}
