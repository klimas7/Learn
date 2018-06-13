package pl.sii.puzzles;

import java.util.stream.Stream;

public class SiiValues {
    public enum Value {
        AMBITION, CAN_DO_ATTITUDE, COURAGE, ENGAGEMENT, FAIRNESS,
        FIGHTING_SPIRIT, FLEXIBILITY, LOYALTY, MODESTY_AND_HUMILITY,
        PASSION, QUALITY, RESPECT, TEAM_SPIRIT, TRANSPARENCY, TRUST
    }

    public static void main(String[] args) {
        System.out.println(
                Stream.of(Value.values()).max(SiiValues::max).get()
        );
    }

    public static int max(Value a, Value b) {
        return Math.max(a.name().length(), b.name().length());
    }
}
