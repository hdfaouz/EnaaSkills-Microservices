package com.enaa.apprenant.Controller;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.apprenant.Service.ApprenantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apprenant")
public class ApprenantController {

    private final ApprenantService apprenantService;

    public ApprenantController(ApprenantService apprenantService) {
        this.apprenantService = apprenantService;
    }

    @PostMapping
    public ApprenantDto ajouterApprenant(@RequestBody ApprenantDto apprenantDto){
        return apprenantService.ajouterApprenant(apprenantDto);
    }
}
