package org.agamotto.cloud.demo.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author
 * @Time 2019/6/2 21:24
 */
public class DemoException extends RuntimeException {



    protected HttpStatus code;

    public DemoException(){

    }
    public DemoException(String message,Integer code){
        super(message);
        this.code = HttpStatus.valueOf(code);
    }

    public DemoException(String message,HttpStatus code){
        super(message);
        this.code = code;
    }


    public DemoException(String message){
        super(message);
    }

    public Integer getCode(){
        return code.value();
    }

}
