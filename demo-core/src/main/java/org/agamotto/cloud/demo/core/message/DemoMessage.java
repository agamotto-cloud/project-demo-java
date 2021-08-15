package org.agamotto.cloud.demo.core.message;

import lombok.Getter;

/**
 * 获取消息列表
 */
@Getter
public enum DemoMessage {

    logoutOk("logout_ok"),
    logoutError("logout_error"),;


    private String message;


    DemoMessage(String msg){
        this.message = msg;
    }
}
