package pl.klimas7.learn.hashequals;

/**
 * -- Niezależnie ile razy wywołamy metodę hashCode,
 *    dla tego samego obiektu powinna zwrócić zwszę tą samą wartośc int
 * -- Jeżeli dwa obiekty są równe na podstawie testu metodą equals to każdy z nich po wywołaniu metody hashCode powinien zwracać taką samą wartośc int
 * -- Nie jest wymagane, aby dwa obiekty niebędące sobie równe przy sprawdzeniu metodą equals zwracały różną wartość int przy wywołaniu na nich metody hashCode.
 *
 *    Warto jednak być świadomym, że dostarczanie innych wartości int dla metody hashCode dla różnych obiektów może wpłynąć na polepszenie wydajności kolekcji hashtable
 */
public class ExampleHashEquals {
    private String stringValue;
    private Integer integerValue;

    public ExampleHashEquals(String stringValue, Integer integerValue) {
        this.stringValue = stringValue;
        this.integerValue = integerValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleHashEquals that = (ExampleHashEquals) o;

        if (stringValue != null ? !stringValue.equals(that.stringValue) : that.stringValue != null) return false;
        return integerValue != null ? integerValue.equals(that.integerValue) : that.integerValue == null;

    }

    @Override
    public int hashCode() {
        return 1;

//        int result = stringValue != null ? stringValue.hashCode() : 0;
//        result = 31 * result + (integerValue != null ? integerValue.hashCode() : 0);
//        return result;
    }
}
