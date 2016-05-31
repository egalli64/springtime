package dd.manny.hello.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dd.manny.hello.logic.Greeter;

@RestController
public class GreetingController {
    @Resource
    private Greeter greeter;

    @RequestMapping("/greeting")
    public String greeting() {
        return greeter.greeting();
    }
}
