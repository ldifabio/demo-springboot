package io.eurekalabs.challenge.config;

import com.fasterxml.jackson.core.JsonParseException;
import io.eurekalabs.challenge.exception.ApiKeyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ErrorHandlingControllerAdvice {

    /*@ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
        List<ValidationError> errors = new ArrayList<>(0);
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            errors.add(new ValidationError(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        return new ValidationErrorResponse(errors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ValidationError> errors = new ArrayList<>(0);
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return new ValidationErrorResponse(errors);
    }*/

    @ExceptionHandler(JsonParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    String onJsonParseException(JsonParseException e) {
        return e.getLocalizedMessage();
    }

    @ExceptionHandler(ApiKeyNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    String onNApiKeyNotFoundException(ApiKeyNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    String onException(Exception e) {
        return "Se produjo un error interno, vuelva a intentarlo más tarde.";
    }
}