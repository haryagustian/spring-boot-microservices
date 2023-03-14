package tech.haryaugust.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.haryaugust.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourcesNotFoundException(ResourceNotFoundException rnfex){
        return new ResponseEntity<>(ApiResponse.builder().message(rnfex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build(), HttpStatus.NOT_FOUND);
    }
}
