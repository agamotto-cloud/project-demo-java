package org.agamotto.cloud.demo.web;

import org.agamotto.cloud.demo.core.service.UserService;
import org.agamotto.cloud.resp.AgamottoResponse;
import org.agamotto.cloud.resp.Ret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Ret<String> ss() {
        return AgamottoResponse.ok(userService.getUser("xx"));
    }
}
