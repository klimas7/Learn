package pl.klimas7.learn.extend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ListBoxModel extends ArrayList<ListBoxModel.Option> {
    public static final class Option {
        /**
         * Text to be displayed to user.
         */
        public String name;
        /**
         * The value that gets sent to the server when the form is submitted.
         */
        public String value;

        /**
         * True to make this item selected.
         */
        public boolean selected;

        public Option(String name, String value) {
            this(name, value, false);
        }

        public Option(String name) {
            this(name, name, false);
        }

        public Option(String name, String value, boolean selected) {
            this.name = name;
            this.value = value;
            this.selected = selected;
        }

        @Override
        public String toString() {
            return name + "=" + value + (selected ? "[selected]" : "");
        }

    }

    public ListBoxModel(int initialCapacity) {
        super(initialCapacity);
    }

    public ListBoxModel() {
    }

    public ListBoxModel(Collection<Option> c) {
        super(c);
    }

    public ListBoxModel(Option... data) {
        super(Arrays.asList(data));
    }

    public void add(String displayName, String value) {
        add(new Option(displayName, value));
    }

    /**
     * A version of the {@link #add(String, String)} method where the display name and the value are the same.
     */
    public ListBoxModel add(String nameAndValue) {
        add(nameAndValue, nameAndValue);
        return this;
    }
}
