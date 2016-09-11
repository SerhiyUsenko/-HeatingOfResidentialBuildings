package com.example.controller;

import com.example.model.*;
import com.example.service.BuildingService;
import com.example.service.BuildingTypeService;
import com.example.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Serhiy on 14.05.2016.
 */
@Controller
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private BuildingTypeService buildingTypeService;
    @Autowired
    private StreetService streetService;


    @RequestMapping(value = "/building", method = RequestMethod.GET)
    public ModelAndView building() {
        ModelAndView modelAndView = new ModelAndView("building");
        List<Building> building = buildingService.findAll();
        List<BuildingType> buildingTypes = buildingTypeService.findAll();
        List<Street> streets = streetService.findAll();
        System.out.println(building);
        modelAndView.addObject("buildings", building);
        modelAndView.addObject("buildTypes", buildingTypes);
        modelAndView.addObject("streets",streets);
        return modelAndView;
    }
    @RequestMapping(value = "/building", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addBuilding(String buildType, Long buildingNumber, String street) {
        Building building = new Building();
        ModelAndView modelAndView = new ModelAndView("redirect:building");
        building.setBuildNumber(buildingNumber);
        BuildingType buildingType = buildingTypeService.findOne(Long.parseLong(buildType));
        building.setBuildingType(buildingType);
        Street stret = streetService.findOne(Long.parseLong(street));
        building.setStreet(stret);
        buildingService.save(building);

        return modelAndView;
    }
}
