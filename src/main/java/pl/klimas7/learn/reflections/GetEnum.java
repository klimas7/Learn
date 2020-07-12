package pl.klimas7.learn.reflections;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GetEnum {
    public static void main(String[] args) {
        try {

            Class<? extends EnumWithValue<String>> clazz = (Class<? extends EnumWithValue<String>>) Class.forName("Mode");
            EnumWithValue<String>[] values = clazz.getEnumConstants();

            for (EnumWithValue<String> enumWithValue : values) {
                System.out.print(enumWithValue + " = " + enumWithValue.getValue());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetEnum.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}

