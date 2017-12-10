package pl.klimas7.learn.distance;

public class Distance {
    private Integer[] array;

    public Distance(Integer[] array) {
        this.array = array;
    }

    public Integer getMin() {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int dist = Math.abs(array[i] - array[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }

        return min;
    }
}
