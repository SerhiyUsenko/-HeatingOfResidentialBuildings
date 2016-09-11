package com.example.controller;

import com.example.model.Accounter;
import com.example.model.Customer;
import com.example.service.AccounterService;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Serhiy on 11.05.2016.
 */
@Controller
public class CustomerCountroller {
        @Autowired
        private CustomerService customerService;

        @RequestMapping(value = "/customer", method = RequestMethod.GET)
        public ModelAndView customer() {
            ModelAndView modelAndView = new ModelAndView("customer");
            List<Customer> customer = customerService.findAll();
            System.out.println(customer);
            modelAndView.addObject("customers", customer);
            return modelAndView;
        }
}
