package com.chhd.cniaoplay.http;

/**
 * Created by CWQ on 2017/5/11.
 */

public class ApiException extends Exception {

    private int code;

    private String displayMessage;

    public ApiException() {
    }

    public ApiException(int code, String displayMessage) {
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
