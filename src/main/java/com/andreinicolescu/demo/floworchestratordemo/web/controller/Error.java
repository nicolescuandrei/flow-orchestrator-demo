package com.andreinicolescu.demo.floworchestratordemo.web.controller;

import com.andreinicolescu.demo.floworchestratordemo.web.Node;
import com.andreinicolescu.webflow.floworchestrator.annotation.ResetFlow;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.nonNull;

@Controller
@RequestMapping(Node.ERROR)
public class Error implements ErrorController {

    @ResetFlow
    @GetMapping
    public String display(HttpServletRequest request) {
        String page = "error";

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (nonNull(status)) {
            int statusCode = Integer.parseInt(status.toString());
            if (HttpStatus.NOT_FOUND.value() == statusCode) {
                page = "error-404";
            }
        }

        return page;
    }

    @Override
    public String getErrorPath() {
        return Node.ERROR;
    }

}
