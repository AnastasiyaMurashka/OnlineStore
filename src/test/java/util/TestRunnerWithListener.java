package util;

import cucumber.api.junit.Cucumber;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

public class TestRunnerWithListener extends Cucumber {

    public TestRunnerWithListener(Class klass) throws InitializationError, IOException {
        super(klass);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new TestListener());
        super.run(notifier);
    }
}
