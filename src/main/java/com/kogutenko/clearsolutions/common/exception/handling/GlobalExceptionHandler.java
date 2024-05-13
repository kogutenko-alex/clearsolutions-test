package com.kogutenko.clearsolutions.common.exception.handling;

import com.kogutenko.clearsolutions.common.exception.business.BusinessException;
import com.kogutenko.clearsolutions.common.exception.business.NotFoundException;
import jakarta.validation.ConstraintDeclarationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleBusinessException(BusinessException exception) {
        log.warn(exception.getMessage());

        return new ErrorResponse(
                System.currentTimeMillis(),
                BAD_REQUEST.value(),
                List.of(Error.builder().message(exception.getMessage()).build())
        );
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException exception) {
        return new ErrorResponse(
                System.currentTimeMillis(),
                NOT_FOUND.value(),
                List.of(Error.builder().message(exception.getMessage()).build())
        );
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleUnexpectedTypeException(ConstraintDeclarationException exception) {
        log.warn(exception.getMessage());

        return new ErrorResponse(
                System.currentTimeMillis(),
                BAD_REQUEST.value(),
                List.of(Error.builder().message(exception.getMessage()).build())
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.warn(exception.getMessage());

        return new ErrorResponse(
                System.currentTimeMillis(),
                BAD_REQUEST.value(),
                List.of(Error.builder().message(exception.getMessage()).build())
        );
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handle(BindException exception) {
        log.warn(exception.getMessage());

        return new ErrorResponse(
                System.currentTimeMillis(),
                BAD_REQUEST.value(),
                exception.getBindingResult().getFieldErrors()
                        .stream()
                        .map(x -> FormValidationError.builder()
                                .field(x.getField())
                                .message(x.getDefaultMessage())
                                .build()).collect(Collectors.toList())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handle(MethodArgumentNotValidException exception) {
        log.warn(exception.getMessage());

        return new ErrorResponse(
                System.currentTimeMillis(),
                BAD_REQUEST.value(),
                exception.getBindingResult().getFieldErrors()
                        .stream()
                        .map(x -> FormValidationError.builder()
                                .field(x.getField())
                                .message(x.getDefaultMessage())
                                .build()).collect(Collectors.toList())
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        log.warn(exception.getMessage());

        return new ErrorResponse(
                System.currentTimeMillis(),
                BAD_REQUEST.value(),
                List.of(Error.builder().message(exception.getMessage()).build())
        );
    }

    @ResponseBody
    @ExceptionHandler(JDBCConnectionException.class)
    @ResponseStatus(SERVICE_UNAVAILABLE)
    public ErrorResponse psqlExceptionHandler(JDBCConnectionException exception) {
        exception.printStackTrace();

        return new ErrorResponse(
                System.currentTimeMillis(),
                SERVICE_UNAVAILABLE.value(),
                List.of(Error.builder().message(exception.getMessage()).build())
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleNotFoundException(Exception exception) {
        exception.printStackTrace();

        return new ErrorResponse(
                System.currentTimeMillis(),
                INTERNAL_SERVER_ERROR.value(),
                List.of(Error.builder().message(exception.getMessage()).build())
        );
    }

    @ExceptionHandler({ TransactionSystemException.class })
    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleConstraintViolation(Exception exception) {

        Throwable cause = ((TransactionSystemException) exception).getRootCause();
        if (cause instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause).getConstraintViolations();
            return new ErrorResponse(
                    System.currentTimeMillis(),
                    INTERNAL_SERVER_ERROR.value(),
                    constraintViolations.stream()
                            .map(constraintViolation -> Error.builder().message(constraintViolation.getMessageTemplate()).build())
                            .collect(Collectors.toList()));
        }
        return new ErrorResponse(
                System.currentTimeMillis(),
                INTERNAL_SERVER_ERROR.value(),
                List.of(Error.builder().message(exception.getMessage()).build())
        );
    }

}
