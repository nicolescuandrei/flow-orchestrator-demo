package com.andreinicolescu.demo.floworchestratordemo.web;

import com.andreinicolescu.webflow.floworchestrator.exception.NodeAccessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.andreinicolescu.demo.floworchestratordemo.Constants.REDIRECT;
import static java.util.Objects.nonNull;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Performs a redirect to the last validated node
     *
     * @param e NodeAccessException
     * @return redirection path
     */
    @ExceptionHandler(NodeAccessException.class)
    public String nodeAccessExceptionHandler(NodeAccessException e) {
        log.warn(e.getMessage());
        String nextNode = nonNull(e.getHeadNode()) ?
                e.getHeadNode() : Node.START;
        log.warn("Redirecting to [{}] node", nextNode);

        return REDIRECT + nextNode;
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);

        return REDIRECT + Node.ERROR;
    }
}
