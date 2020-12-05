package org.example.controller;

import org.example.entities.AdoptersEntity;
import org.example.entities.AdoptionsEntity;
import org.example.entities.DogsEntity;
import org.example.models.AdoptionModel;
import org.example.services.AdoptersService;
import org.example.services.AdoptionService;
import org.example.services.DogsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @Autowired
    private AdoptersService adoptersService;

    @Autowired
    private DogsServices dogsServices;

    @GetMapping("/addAdoption")
    public ModelAndView addAdoption(){
        ModelAndView modelAndView =  new ModelAndView("adoption");
        modelAndView.addObject("adoption" , new AdoptionModel());
//        modelAndView.addObject("dogs", dogsServices.getAllDogsByNumber());
        modelAndView.addObject("adopter", adoptersService.getAllAdopters());
        modelAndView.addObject("dogs",dogsServices.getAllDogs());
        return modelAndView;
    }

    @PostMapping("/saveAdoption")
    public ModelAndView saveNewAdoption(@ModelAttribute ("adoption") AdoptionModel adoptionModel){
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        AdoptersEntity adopter = adoptersService.getAdopter(adoptionModel.getAdopterId());
        AdoptionsEntity adoptionsEntity = new AdoptionsEntity();
        adoptionsEntity.setAdopter(adopter);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            Date date = simpleDateFormat.parse(adoptionModel.getAdoptionDate());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        adoptionsEntity.setCanceled(false);

        DogsEntity dogsEntity = dogsServices.getAllDogsByNumber(adoptionModel.getDogNumber());
        adoptionsEntity.setDog(dogsEntity);

        adoptionService.saveAdoption(adoptionsEntity);

        return modelAndView;
    }


}
