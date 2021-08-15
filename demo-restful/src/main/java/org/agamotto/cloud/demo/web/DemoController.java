package org.agamotto.cloud.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping
    public String ss() {
        return "xx";
    }
}
