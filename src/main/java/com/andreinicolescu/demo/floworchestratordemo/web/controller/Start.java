package com.andreinicolescu.demo.floworchestratordemo.web.controller;

import com.andreinicolescu.demo.floworchestratordemo.web.Node;
import com.andreinicolescu.demo.floworchestratordemo.web.controller.dto.ViewDTO;
import com.andreinicolescu.webflow.floworchestrator.SessionContextFlow;
import com.andreinicolescu.webflow.floworchestrator.annotation.MarkNextNodeAsAccessible;
import com.andreinicolescu.webflow.floworchestrator.annotation.ResetFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.andreinicolescu.demo.floworchestratordemo.Constants.REDIRECT;


@Controller
@RequestMapping(Node.START)
public class Start {

    private final SessionContextFlow sessionContextFlow;

    @Autowired
    public Start(SessionContextFlow sessionContextFlow) {
        this.sessionContextFlow = sessionContextFlow;
    }

    @ResetFlow
    @GetMapping
    public String display(Model model) {
        // only to see the state of the session context flow in page
        model.addAttribute("view", sessionContextFlow);

        return "start";
    }

    @MarkNextNodeAsAccessible
    @PostMapping
    public String submit(@Valid @ModelAttribute ViewDTO viewDTO) {
        String nextNode = viewDTO.getNode();

        return REDIRECT + nextNode;
    }
}
