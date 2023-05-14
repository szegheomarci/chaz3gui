package com.szegheomarci.chaz3gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/favicon.ico")
    public String favicon(){
        return "favicon.ico";
    }

    @RequestMapping("/proba")
    public String proba(){
        return "proba";
    }

    @RequestMapping("/chart")
    public String chart(){
        return "myChart";
    }

    @RequestMapping("/chartdata")
    public String chartdata(){
        return "chartdata";
    }

    @RequestMapping("/priceavailability")
    public String priceavailability(){
        return "priceavailability";
    }
}
