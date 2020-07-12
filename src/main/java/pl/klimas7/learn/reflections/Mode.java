package pl.klimas7.learn.reflections;

public enum Mode implements EnumWithValue<String> {
    RUNNING("SytemRunning"),
    STOPPED("SystemStopped"),
    IDLE("tmpIdle");

    private final String value;

    private Mode(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
