package com.semweb.semWebArt.controllers;

import com.semweb.semWebArt.model.BikeStation;
import com.semweb.semWebArt.services.LyonBikeStationService;
import com.semweb.semWebArt.services.StEtienneBikeStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GeneralControoler {

    @Autowired
    StEtienneBikeStationService stEtienneBikeStationService;

    @Autowired
    LyonBikeStationService lyonBikeStationService;

    @RequestMapping(method = RequestMethod.GET, value = "/st")
    public String StBikeStation(Model model) {

        List<BikeStation> StStations = stEtienneBikeStationService.getBikeStationList();
//        System.out.println(Stations);
        model.addAttribute("bikeStations", StStations);

        return "bikeStation";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/lyon")
    public String lybikeStation(Model model) {

        List<BikeStation> LyStations = lyonBikeStationService.getLyonBikeStationList();
        System.out.println(LyStations);
        model.addAttribute("LybikeStations", LyStations);

        return "lyBikeStation";
    }


//    @Autowired
//    HospitalServices hospitalServices;
//
//    @RequestMapping(method = RequestMethod.GET, value = "/st")
//    public String hospitalController(Model moelel){
//        List<Hospital> hospitals = hospitalServices.getHospitalsList();
//        moelel.addAttribute("test", hospitals);
//        return "index";
//    }




}
