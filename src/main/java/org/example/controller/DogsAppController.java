package org.example.controller;

import org.example.entities.DogsEntity;
import org.example.services.DogsServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DogsAppController {

    private static final Logger log = LoggerFactory.getLogger(DogsAppController.class);

    public DogsAppController() {
        log.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private DogsServices dogsServices;


    @GetMapping("/home")
    public ModelAndView getHomepage(){
        ModelAndView modelAndView = new ModelAndView("frontpage");
        return modelAndView;
    }
    @GetMapping("/about")
    public ModelAndView getAboutpage(){
        ModelAndView modelAndView = new ModelAndView("aboutpage");
        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView getContactpage(){
        ModelAndView modelAndView = new ModelAndView("contactpage");
        return modelAndView;
    }

    @GetMapping("/dogs")
    public ModelAndView getDogs(){
        ModelAndView modelAndView = new ModelAndView("availabledogs");
        modelAndView.addObject("dogs",dogsServices.getAllDogs() );
        return  modelAndView;
    }

    @GetMapping("/description/{id}")
    public ModelAndView getDescription(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("description");
//        modelAndView.addObject("dogs",dogsServices.getAllDogs());
        modelAndView.addObject("doggos", dogsServices.getDescription(id) );
        modelAndView.addObject("doggos",dogsServices.getImages(id));
        return modelAndView;
    }
    @GetMapping("/adoption/{id}")
    public ModelAndView getAdoption(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("adoption");
        modelAndView.addObject("dogs", dogsServices.getAllDogsByNumber(id));
        return modelAndView;
    }

}
