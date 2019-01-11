package spittr.crash.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spittr.crash.DuplicateSpittleException;

@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleNotFound() {
        return "error/duplicate";
    }

}
