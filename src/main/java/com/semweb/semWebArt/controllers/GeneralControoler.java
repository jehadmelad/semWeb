package com.semweb.semWebArt.controllers;

import com.semweb.semWebArt.model.BikeStation;
import com.semweb.semWebArt.services.StEtienneBikeStationService;
import com.semweb.semWebArt.services.HospitalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GeneralControoler {

    @Autowired
    HospitalServices hospitalServices;

    @Autowired
    StEtienneBikeStationService stEtienneBikeStationService;



//    @RequestMapping(method = RequestMethod.GET, value = "/")
//    public String index(Model model) {
//
//        List<Hospital> hospitals = hospitalServices.getHospitalsList();
//        model.addAttribute("hospitals", hospitals);
//        return "index";
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/station")
    public String bikeStation(Model model) {

        List<BikeStation> Stations = stEtienneBikeStationService.getBikeStationList();
        System.out.println(Stations);
        model.addAttribute("bikeStations", Stations);
        return "bikeStation";
    }




}
