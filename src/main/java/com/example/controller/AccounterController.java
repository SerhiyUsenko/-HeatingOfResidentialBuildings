package com.example.controller;

import com.example.model.Accounter;
import com.example.model.AccounterType;
import com.example.service.AccounterService;
import com.example.service.AccounterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Serhiy on 11.05.2016.
 */
@Controller
public class AccounterController {
    @Autowired
    private AccounterService accounterService;
    @Autowired
    private AccounterTypeService accounterTypeService;

    @RequestMapping(value = "/accounter", method = RequestMethod.GET)
    public ModelAndView accounter() {
        ModelAndView modelAndView = new ModelAndView("accounter");
        List<Accounter> accounter = accounterService.findAll();
        List<AccounterType> accounterTypes = accounterTypeService.findAll();
        System.out.println(accounter);
        modelAndView.addObject("accTypes", accounterTypes);
        modelAndView.addObject("accounters", accounter);
        return modelAndView;
    }
    @RequestMapping(value = "/accounter", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addAccounter(String accounterName, String accounterProducer, String instalDate, String accType) {
        System.out.println(accType);
        Accounter accounter = new Accounter();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = df.parse(instalDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("redirect:accounter");
        accounter.setNameAccounter(accounterName);
        accounter.setAccProducer(accounterProducer);
        AccounterType accounterType = accounterTypeService.findOne(Long.parseLong(accType));
        accounter.setAccounterType(accounterType);
        accounter.setInstalDate(date);
        accounterService.save(accounter);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteAccounters", method = RequestMethod.GET)
    public @ResponseBody ModelAndView accounter(@RequestParam("id") Long idAccounter) {
        ModelAndView modelAndView = new ModelAndView("redirect: accounter");
        System.out.println("ID: " + idAccounter);
        accounterService.deleteByIdAccounter(idAccounter);
        System.out.println("After delete");
        modelAndView.addObject("accounters", accounterService.findAll());
        return modelAndView;
    }

}
