package pl.klimas7.learn.mockito;

import java.util.logging.Logger;

public class SuperClazz {
    Logger logger = Logger.getLogger(SuperClazz.class.getName());

    public boolean doSomething(String message) {
        logger.info(message);
        return true;
    }

    public int getId() {
        return 42;
    }

    public void fakeMethod() {
    }
}
