package se.iths.HealthApp.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {

    private HttpStatus httpStatus;
    @JsonFormat(pattern = "dd-MM-yyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private String message;
    private String debugMessage;

    private ApiError() {
        timeStamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus httpStatus, String message, Exception e) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.debugMessage = e.getMessage();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}
