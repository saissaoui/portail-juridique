package fr.artefrance.daj.ws.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URISyntaxException;

import static javax.ws.rs.core.Response.Status.*;

@ControllerAdvice
@Order
class WebExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler({IllegalArgumentException.class, HttpMessageNotReadableException.class})
    public Response defaultErrorHandler(IllegalArgumentException e) {
        LOGGER.error(
                "Wrong arguments given to request",
                e);
        return Response.status(BAD_REQUEST)
                              .build();
    }

    @ExceptionHandler(URISyntaxException.class)
    public Response uriSyntaxError(URISyntaxException e) {
        LOGGER.error(
                "uri syntax error",
                e);
        return Response.status(BAD_GATEWAY)
                       .build();
    }

    @ExceptionHandler(IOException.class)
    public Response inputOutputError(IOException e) {
        LOGGER.error(
                "Input/output error",
                e);
        return Response.status(INTERNAL_SERVER_ERROR)
                       .build();
    }

    @ExceptionHandler(Exception.class)
    public Response unknownError(Exception e) {
        LOGGER.error(
                "Unknown error: ",
                e);
        return Response.status(INTERNAL_SERVER_ERROR)
                       .build();
    }
}
