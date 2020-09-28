package com.andreinicolescu.demo.floworchestratordemo.web.controller;

import com.andreinicolescu.demo.floworchestratordemo.web.Node;
import com.andreinicolescu.demo.floworchestratordemo.web.controller.dto.ViewDTO;
import com.andreinicolescu.webflow.floworchestrator.SessionContextFlow;
import com.andreinicolescu.webflow.floworchestrator.annotation.CheckAccess;
import com.andreinicolescu.webflow.floworchestrator.annotation.MarkNextNodeAsAccessible;
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
@RequestMapping(Node.B)
public class B {

    private final SessionContextFlow sessionContextFlow;

    @Autowired
    public B(SessionContextFlow sessionContextFlow) {
        this.sessionContextFlow = sessionContextFlow;
    }

    @CheckAccess
    @GetMapping
    public String display(Model model) {
        model.addAttribute("view", sessionContextFlow);

        return "b";
    }

    @MarkNextNodeAsAccessible
    @CheckAccess
    @PostMapping
    public String submit(@Valid @ModelAttribute ViewDTO viewDTO) {
        String nextNode = viewDTO.getNode();

        return REDIRECT + nextNode;
    }
}
