package dd.manny.hello.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final Log log = LogFactory.getLog(GreetingController.class);

    @RequestMapping("/greeting")
    public String greeting() {
        log.trace("trace hello");
        log.debug("debug hello");
        log.info("info hello");
        log.warn("warn hello");
        log.error("error hello");
        log.fatal("fatal hello");
        return "Hello!";
    }
}
