package com.andreinicolescu.demo.floworchestratordemo.web.controller;

import com.andreinicolescu.demo.floworchestratordemo.web.Node;
import com.andreinicolescu.webflow.floworchestrator.SessionContextFlow;
import com.andreinicolescu.webflow.floworchestrator.annotation.CheckAccess;
import com.andreinicolescu.webflow.floworchestrator.annotation.ResetFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Node.END)
public class End {

    private final SessionContextFlow sessionContextFlow;

    @Autowired
    public End(SessionContextFlow sessionContextFlow) {
        this.sessionContextFlow = sessionContextFlow;
    }

    @ResetFlow
    @CheckAccess
    @GetMapping
    public String display(Model model) {
        model.addAttribute("view", sessionContextFlow);

        return "end";
    }
}
