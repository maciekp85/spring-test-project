package com.isf.aspress.isf.spring;

public class HelloMessageService implements MessageService{

    @Override
    public String getMessage() {
        return "Hello world";
    }
}
