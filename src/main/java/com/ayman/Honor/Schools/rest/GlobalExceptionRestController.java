package com.ayman.Honor.Schools.rest;
import com.ayman.Honor.Schools.model.ResponseMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler
{
    @Override
    protected ResponseEntity<Object>handleMethodArgumentNotValid (MethodArgumentNotValidException e , HttpHeaders headers , HttpStatusCode code , WebRequest request)
    {
        return new ResponseEntity(new ResponseMsg(code.toString(), e.getBindingResult().toString()) , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMsg> exceptionHandler (Exception exception)
    {
        return new ResponseEntity(new ResponseMsg("500", exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
