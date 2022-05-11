package se.iths.HealthApp.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger((this.getClass()));

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    //EmptyException

    @ExceptionHandler({EmailAlreadyExist.class})
    public ResponseEntity<Object> emailAlreadyExist(EmailAlreadyExist e) {
        logger.info(e.getClass().getName());
//        String errorMessage = "Email already exist!";
        return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, e.getMessage(), e));
    }

    @ExceptionHandler({NoSuchIDException.class})
    public ResponseEntity<Object> noSuchIdException(NoSuchIDException e) {
        logger.info(e.getClass().getName());
//        String errorMessage = "No such Id";
        return buildResponseEntity(new ApiError(HttpStatus.NO_CONTENT, e.getMessage(), e));
    }


    @ExceptionHandler({EmptyException.class})
    public ResponseEntity<Object> entityException(EmptyException e) {
        logger.info(e.getClass().getName());
//        String errorMessage = "";
        return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, e.getMessage(), e));
    }

    //Base Exception
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(e.getClass().getName());
        String errorMessage = " Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage, e));
    }

    // All Exceptions
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllException(Exception e) {
        logger.info(e.getClass().getName());
        logger.error("Error: ", e);
        String errorMessage = " An unexcpected error occured";

        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, e));
    }
}
