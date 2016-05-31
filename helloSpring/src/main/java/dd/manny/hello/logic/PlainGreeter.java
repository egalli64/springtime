package dd.manny.hello.logic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class PlainGreeter implements Greeter {
    private static final Log log = LogFactory.getLog(PlainGreeter.class);

    @Override
    public String greeting() {
        log.trace("Generating plain greeting");
        return "Hello!";
    }
}
