package com.codeitek.pdp.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/23/13
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("")
public class WelcomeController {


    @SuppressWarnings({"SpringMVCViewInspection"})
    @RequestMapping(method= RequestMethod.GET)
    public String base(Model model) {
        return"redirect:/index";
    }

    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public String getCreateForm(Model model) {
        return "index";
    }

}
