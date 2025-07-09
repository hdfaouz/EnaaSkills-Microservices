package com.enaa.apprenant.Controller;

import com.enaa.apprenant.Dto.ApprenantDto;
import com.enaa.apprenant.Service.ApprenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<ApprenantDto> getAll(){
        return apprenantService.getAll();
    }
}
