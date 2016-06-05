package dd.sia.knights.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dd.sia.knights.logic.Knight;

@RestController
public class KnightController {
    @Resource
    private Knight knight;

    @RequestMapping("/quest")
    public String quest() {
        return knight.doQuest();
    }
}
