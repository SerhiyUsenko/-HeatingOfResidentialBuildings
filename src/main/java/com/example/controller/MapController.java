package com.example.controller;

import com.example.model.Accounter;
import com.example.service.AccounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Serhiy on 10.05.2016.
 */
@Controller
public class MapController {
    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public ModelAndView map() {
        ModelAndView modelAndView = new ModelAndView("map");
        return modelAndView;
    }

//    @RequestMapping(value = "/mapAll", method = RequestMethod.POST)
//    @ResponseBody
//    public List<> mapAll() {
//        for (Patient patient : patientService.getPatientsByDoctor()){
//            System.out.println("Patient" +patient.getFirstName());
//        }
//        return patientService.getPatientsByDoctor();
//    }

}


