package pl.klimas7.learn.hour;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Hour {
    public LocalTime getMaxHour(Integer... argss) throws IllegalArgumentException {
        validate(argss);

        List<Integer> data = new ArrayList<>(Arrays.asList(argss));
        Collections.sort(data, Collections.reverseOrder());

        Integer majorHour = getAndRemove(data, i -> i <= 2);

        Integer minorHour = getAndRemove(data, i -> ((majorHour == 2 && i <= 3) || (majorHour != 2)));

        Integer majorMinute = getAndRemove(data, i -> i <= 5);
        Integer minorMinute = data.get(0);

        int hour = majorHour * 10 + minorHour;
        int minute = majorMinute * 10 + minorMinute;
        return LocalTime.of(hour, minute);
    }

    private Integer getAndRemove(List<Integer> data, Predicate<Integer> filter) {
        Integer element = data.stream()
                .filter(filter)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        data.remove(element);
        return element;
    }

    private void validate(Integer[] argss) {
        if (argss == null) {
            throw new IllegalArgumentException("Input parameter can't be null");
        }

        if (argss.length != 4) {
            throw new IllegalArgumentException("Must specified 4 parameters");
        }
    }
}
