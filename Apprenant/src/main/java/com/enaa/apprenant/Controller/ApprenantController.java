package com.enaa.apprenant.Controller;

import com.enaa.apprenant.dto.ApprenantDto;
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
