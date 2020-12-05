package org.example.controller;

import org.example.entities.AdoptersEntity;
import org.example.entities.Authorities;
import org.example.entities.User;

import org.example.entities.UserTypes;
import org.example.models.RegisterModel;
import org.example.repositories.AdoptersRepository;
import org.example.repositories.AuthoritiesRepository;
import org.example.repositories.UserRepository;
import org.example.repositories.UserTypesRepository;
import org.example.services.AdoptersService;
import org.example.services.UserTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;
import java.util.Optional;

@Controller
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdoptersService adoptersService;

    @Autowired
    private AdoptersRepository adoptersRepository;
    @Autowired
    private UserTypesRepository userTypesRepository;
    @Autowired
    private UserTypesService userTypesService;


    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/error") //url-ul pt login error din antMatchers din WebSecurityConfig
    public ModelAndView showErrorLogin() {
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerModel", new RegisterModel());
        modelAndView.addObject("userTypes", userTypesService.getAllUserTypes());
        modelAndView.addObject("adopters",adoptersService.getAllAdopters());
        return modelAndView;
    }

    @PostMapping("/register-user")
    public ModelAndView registerUser(@ModelAttribute("registerModel") RegisterModel registerModel) {
        Optional <User> userEntityOptional = userRepository.findById(registerModel.getUsername());
        User user = null;

        if(userEntityOptional.isPresent()){
            user = userEntityOptional.get();
        }else{
            user = new User();
        }
        user.setUsername(registerModel.getUsername());
        user.setPassword(passwordEncoder.encode(registerModel.getPassword()));
        user.setEnabled(true);
        user.setDeleted(false);

        AdoptersEntity adoptersEntity = null;
        if(userEntityOptional.isPresent()){
            adoptersEntity = user.getAdoptersEntity();
        }else{
            adoptersEntity = new AdoptersEntity();
        }
        adoptersEntity.setFirstName(registerModel.getFirstName());
        adoptersEntity.setLastName(registerModel.getLastName());
        adoptersEntity.setAddress(registerModel.getAddress());
        adoptersEntity.setEmail(registerModel.getEmail());
        adoptersEntity.setPhoneNumber(registerModel.getPhoneNumber());

        UserTypes userTypes = userTypesService.getUserTypeById(registerModel.getUserTypeId());
        adoptersEntity.setUserTypes(userTypes);

        if(!userEntityOptional.isPresent()){
            Authorities authorities = new Authorities();
            authorities.setUsername(registerModel.getUsername());
            authorities.setAuthority("ROLE_" + registerModel.getUserTypeId());
            authoritiesRepository.save(authorities);
        }

        userRepository.save(user);
        adoptersEntity.setUser(user);
        adoptersRepository.save(adoptersEntity);
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }

    @GetMapping("/editAdopter/{username}")
    public ModelAndView editAdopter(@PathVariable String username) {
        ModelAndView modelAndView = new ModelAndView("register");
        User user = userRepository.findByUsername(username);
        RegisterModel registerModel = new RegisterModel();
        registerModel.setUsername(user.getUsername());

        if (null != user.getAdoptersEntity()) {
            registerModel.setFirstName(user.getAdoptersEntity().getFirstName());
            registerModel.setLastName(user.getAdoptersEntity().getLastName());
            registerModel.setAddress(user.getAdoptersEntity().getAddress());
            registerModel.setEmail(user.getAdoptersEntity().getEmail());
            registerModel.setPhoneNumber(user.getAdoptersEntity().getPhoneNumber());

            registerModel.setUserTypeId(user.getAdoptersEntity().getUserTypes().getUserTypeId());
        }
        modelAndView.addObject("userTypes", userTypesService.getAllUserTypes());
        modelAndView.addObject("registerModel", registerModel);
        return modelAndView;
    }

    @GetMapping("/deleteAdopter/{id}")
    public ModelAndView deleteAdopter(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("redirect:/tables");
        adoptersService.delete(id);
        return modelAndView;
    }



}