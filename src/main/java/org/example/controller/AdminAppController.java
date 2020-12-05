package org.example.controller;

import org.example.entities.DogsEntity;
import org.example.services.AdminServices;
import org.example.services.AdoptersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminAppController {

    private static final Logger log = LoggerFactory.getLogger(AdminAppController.class);

    public AdminAppController() {
        log.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private AdminServices adminServices;

    @Autowired
    private AdoptersService adoptersService;



    @GetMapping("/tables")
    public ModelAndView getDogsAdoptersTables(){
        ModelAndView modelAndView = new ModelAndView("admintables");
        modelAndView.addObject("dogs",adminServices.getAllDogs());
//        modelAndView.addObject("adopters",adminServices.getAllAdopters());
        modelAndView.addObject("dog", new DogsEntity());
        modelAndView.addObject("adopters",adoptersService.getAllAdopters());
//        modelAndView.addObject("adopter", new DogsAdoptersEntity());
        return modelAndView;
    }

    @GetMapping("/editDog/{id}")
    public ModelAndView editDog(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("editpage");
        modelAndView.addObject("dog",adminServices.getDog(id));
        return modelAndView;
    }
    @GetMapping("/deleteDog/{id}")
    public ModelAndView deleteDog(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("admintables");
        adminServices.deleteDog(id);
        return modelAndView;
    }
    @GetMapping("/addDog")
    public ModelAndView addDog(){
        ModelAndView modelAndView = new ModelAndView("addpage");
        modelAndView.addObject("dog", new DogsEntity());
        return modelAndView;
    }
    @PostMapping("/saveDog")
    public ModelAndView saveDog(@Valid @ModelAttribute("dog") DogsEntity dogsEntity, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("redirect:/tables");
        if(bindingResult.hasErrors()){
            modelAndView.addObject("dog", dogsEntity);
            modelAndView.setViewName("admintables");
            return modelAndView;
        }
        dogsEntity.setDeleted(false);
        adminServices.saveDog(dogsEntity);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editDog(@ModelAttribute("dog") DogsEntity dogsEntity, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("redirect:/tables");
        if(bindingResult.hasErrors()){
            modelAndView.addObject("dog", dogsEntity);
            modelAndView.setViewName("admintables");
            return modelAndView;
        }
        dogsEntity.setName(dogsEntity.getName());
        dogsEntity.setDogNumber(dogsEntity.getDogNumber());
        dogsEntity.setAge(dogsEntity.getAge());
        dogsEntity.setSex(dogsEntity.getSex());
        dogsEntity.setDescription(dogsEntity.getDescription());
        dogsEntity.setImageUrl(dogsEntity.getImageUrl());
        dogsEntity.setRegistrationDate(dogsEntity.getRegistrationDate());
        dogsEntity.setAdopted(dogsEntity.getAdopted());
        adminServices.saveDog(dogsEntity);
        return modelAndView;
    }
}
