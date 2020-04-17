package com.bridgelabz.fundoonotes.model;

import org.springframework.http.HttpStatus;

public class Response {

    //Variable
    private HttpStatus statusCode;
    private String statusMessage;

    //Parameterised Constructor.
    public Response(HttpStatus statusCode, String message) {
        super();
        this.statusCode=statusCode;
        this.statusMessage=message;
    }

    //Empty Constructor with super.
    public Response() {
        super();
    }

    //Getters and Setters
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
