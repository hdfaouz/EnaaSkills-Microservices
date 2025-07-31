package com.enaa.apprenant.controller;

import com.enaa.apprenant.dto.ApprenantDto;
import com.enaa.apprenant.service.ApprenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ApprenantController {

    private final ApprenantService apprenantService;

    public ApprenantController(ApprenantService apprenantService) {
        this.apprenantService = apprenantService;
    }

    @PostMapping("/add")
    public ApprenantDto ajouterApprenant(@RequestBody ApprenantDto apprenantDto){
        return apprenantService.ajouterApprenant(apprenantDto);
    }

    @GetMapping("/all")
    public List<ApprenantDto> getAll(){
        return apprenantService.getAllApprenants();
    }

    @PutMapping("/{id}")
    public ApprenantDto update(@PathVariable Long id, @RequestBody ApprenantDto apprenantDto){
        return apprenantService.update(id,apprenantDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        apprenantService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public ApprenantDto getById(@PathVariable Long id){

        return apprenantService.getApprenantById(id);
    }
}
