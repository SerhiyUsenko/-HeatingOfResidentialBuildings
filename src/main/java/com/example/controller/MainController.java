package com.example.controller;

import com.example.model.Accounter;
import com.example.service.AccounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by MrWhite_PRO on 10.05.2016.
 */
@Controller
public class MainController {
    @Autowired
    private AccounterService accounterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        Accounter accounter = accounterService.getOne(1L);
        modelAndView.addObject("accounter", accounter);
        return modelAndView;
    }


}
