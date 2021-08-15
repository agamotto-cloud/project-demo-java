package org.agamotto.cloud.demo.core.service;


import org.agamotto.cloud.demo.core.Error;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public String getUser(String username) {

        Error.未找到用户.toThrow();

        return null;
    }
}
