package com.hcxy.entity;

/**
 * Created by Sjming
 * 2017-08-31 16:50
 */
public class ResultMessage {

    private int code;

    private String message;

    private Object content;

    public ResultMessage() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
