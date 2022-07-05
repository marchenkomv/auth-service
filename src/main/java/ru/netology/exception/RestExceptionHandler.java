package ru.netology.exception;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("ru.netology")
public class RestExceptionHandler {

    private final HttpHeaders headers = new HttpHeaders();
    private final ObjectNode node = JsonNodeFactory.instance.objectNode();

    public RestExceptionHandler() {
        headers.add("Content-Type", "application/json");
    }

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        node.put("error", e.getMessage());
        System.out.println(e.getMessage());
        return new ResponseEntity<>(node.toString(), headers, HttpStatus.valueOf(400));
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handleInvalidCredentials(UnauthorizedUser e) {
        node.put("error", e.getMessage());
        System.out.println(e.getMessage());
        return new ResponseEntity<>(node.toString(), headers, HttpStatus.valueOf(401));
    }
}