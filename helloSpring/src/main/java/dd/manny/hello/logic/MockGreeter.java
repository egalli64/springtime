package dd.manny.hello.logic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class MockGreeter implements Greeter {
    private static final Log log = LogFactory.getLog(MockGreeter.class);

    @Override
    public String greeting() {
        log.debug("Generating mock greeting");
        return "mock hello!";
    }
}
