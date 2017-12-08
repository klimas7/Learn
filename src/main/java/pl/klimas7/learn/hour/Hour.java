package pl.klimas7.learn.hour;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Hour {
    public LocalTime getMaxHour(Integer... argss) throws IllegalArgumentException {
        validate(argss);

        List<Integer> data = new ArrayList();
        data.addAll(Arrays.asList(argss));

        Integer majorHour = getMajorHour(data);
        data.remove(majorHour);

        Integer minorHour = getMinorHour(data, majorHour);
        data.remove(minorHour);

        Integer majorMinute = getMajorMinute(data);
        data.remove(majorMinute);
        Integer minorMinute = data.get(0);

        int hour = majorHour * 10 + minorHour;
        int minute = majorMinute * 10 + minorMinute;
        return LocalTime.of(hour, minute);
    }

    private Integer getMajorHour(List<Integer> data) {
        return data.stream()
                .sorted(Comparator.reverseOrder())
                .filter(i -> i <= 2)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private Integer getMinorHour(List<Integer> data, Integer majorHour) {
        return data.stream()
                .sorted(Comparator.reverseOrder())
                .filter(i -> ((majorHour == 2 && i <= 3) || (majorHour != 2)))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private Integer getMajorMinute(List<Integer> data) {
        return data.stream()
                .sorted(Comparator.reverseOrder())
                .filter(i -> i <= 5)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
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
