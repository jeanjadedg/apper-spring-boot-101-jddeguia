package com.apper.theblogservice.service;
import com.apper.theblogservice.exception.BlogNotFoundException;
import com.apper.theblogservice.exception.BloggerNotFoundException;
import com.apper.theblogservice.exception.EmailAlreadyRegisteredException;
import com.apper.theblogservice.payload.ServiceErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServiceErrorResponse invalidBloggerEmail (EmailAlreadyRegisteredException ex) {
        ServiceErrorResponse errorResponse = new ServiceErrorResponse();
        errorResponse.setError(ex.getClass().getSimpleName());
        errorResponse.setMessage(ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(BloggerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServiceErrorResponse bloggerNotFound (BloggerNotFoundException ex) {
        ServiceErrorResponse errorResponse = new ServiceErrorResponse();
        errorResponse.setError(ex.getClass().getSimpleName());
        errorResponse.setMessage(ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(BlogNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServiceErrorResponse blogNotFound (BlogNotFoundException ex) {
        ServiceErrorResponse errorResponse =new ServiceErrorResponse();
        errorResponse.setError(ex.getClass().getSimpleName());
        errorResponse.setMessage(ex.getMessage());
        return errorResponse;
    }
}