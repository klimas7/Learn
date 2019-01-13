package pl.klimas7.learn.extend;

public class ExtendedList {
    public ErrorListBoxModel get() {
        ErrorListBoxModel errorListBoxModel = new ErrorListBoxModel();
        errorListBoxModel.addError("xyz");
        errorListBoxModel.add("xxx");
        return errorListBoxModel;
    }
}
