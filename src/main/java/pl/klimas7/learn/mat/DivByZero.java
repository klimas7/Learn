package pl.klimas7.learn.mat;


import java.math.BigDecimal;
import java.math.BigInteger;

public class DivByZero {
    public static void main(String[] args) {
        divDoubleByZero(); //IEEE 754
        divFloatByZero();   //IEEE 754
        divIntByZero();
        divByteByZero();

        divBigDecimalByZero();
        divBigIntegerByZero();
    }

    private static void divBigIntegerByZero() {
        try {
            BigInteger ten = BigInteger.TEN;
            ten = ten.divide(BigInteger.ZERO);
            System.out.println(ten);
        } catch (Exception ex) {
            System.out.println("Exception in method divBigIntegerByZero: " + ex.getMessage());
        }
    }

    private static void divBigDecimalByZero() {
        try {
            BigDecimal ten = BigDecimal.TEN;
            ten = ten.divide(BigDecimal.ZERO);
            System.out.println(ten);
        } catch (Exception ex) {
            System.out.println("Exception in method divBigDecimalByZero: " + ex.getMessage());
        }
    }

    private static void divByteByZero() {
        try {
            byte x = (byte) (1 / 0);
            System.out.println(x);
        } catch (Exception ex) {
            System.out.println("Exception in method divByteByZero: " + ex.getMessage());
        }
    }

    private static void divIntByZero() {
        try {
            int x = 1 / 0;
            System.out.println(x);
        } catch (Exception ex) {
            System.out.println("Exception in method divIntByZero: " + ex.getMessage());
        }
    }

    private static void divFloatByZero() {
        Float x = 1.0f / 0;
        System.out.println(x);
    }

    private static void divDoubleByZero() {
        Double x = -1.0 / 0;
        System.out.println(x);
    }
}
