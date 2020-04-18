package com.bridgelabz.fundoonotes.serviceimplimentation;

import com.bridgelabz.fundoonotes.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseImplimentation {
    public static Response getResponse(HttpStatus statusCode, String messageCode) {
        Response response = new Response();
        response.setStatusMessage(messageCode);
        response.setStatusCode(statusCode);
        return response;
    }
}
