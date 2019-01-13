package pl.klimas7.learn.extend;

import java.util.ArrayList;
import java.util.List;

public class ErrorListBoxModel extends ArrayList<String> {
    private List<String> errors;

    public ErrorListBoxModel() {
        super();
        errors = new ArrayList<>();
    }

    public void addError(String error) {
        errors.add(error);
    }

    @Override
    public boolean add(String s) {
        return super.add(s);
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean hasError() {
        return errors != null && errors.size() > 0;
    }
}
