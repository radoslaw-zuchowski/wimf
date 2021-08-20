package pl.zuchol.wimf.food.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.zuchol.wimf.utils.ErrorMessage;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class FoodExceptionMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<ErrorMessage> foodNotFoundHandler(FoodNotFoundException exception, WebRequest req) {
        var errorMessage = new ErrorMessage(
                "FoodNotFoundException",
                NOT_FOUND.value(),
                exception.getMessage()
        );

        return new ResponseEntity<>(errorMessage, NOT_FOUND);
    }
}
