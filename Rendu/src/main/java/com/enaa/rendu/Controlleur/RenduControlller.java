package com.enaa.rendu.Controlleur;

import com.enaa.rendu.Dto.RenduDto;
import com.enaa.rendu.Service.RenduService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rendu")
public class RenduControlller {

    private final RenduService  renduService;

    public RenduControlller(RenduService renduService) {
        this.renduService = renduService;
    }

    @GetMapping
    public RenduDto ajouterRendu(@RequestBody RenduDto renduDto){
        return renduService.ajouterRendu(renduDto);
    }
}
