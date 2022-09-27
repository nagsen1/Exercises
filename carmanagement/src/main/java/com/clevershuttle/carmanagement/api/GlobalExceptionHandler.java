package com.clevershuttle.carmanagement.api;

import com.clevershuttle.carmanagement.api.dto.CarDetailsResponse;
import com.clevershuttle.carmanagement.api.dto.ErrorResponse;
import com.clevershuttle.carmanagement.exception.CarDetailsNotFoundException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CarDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Not Found.",
                    content = @Content),
    })
    public ResponseEntity<ErrorResponse> handleNotFound(CarDetailsNotFoundException e) {
        logger.info(e.getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Car details not Found."), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Something went terribly, terribly wrong.",
                    content = @Content),
    })
    public ResponseEntity<ErrorResponse> handleGeneralError(Exception e) {
        logger.info(e.getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Unknown error."), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
