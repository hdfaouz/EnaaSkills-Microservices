package com.enaa.rendu.Controlleur;

import com.enaa.rendu.Dto.RenduDto;
import com.enaa.rendu.Service.RenduService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rendu")
public class RenduControlller {

    private final RenduService  renduService;

    public RenduControlller(RenduService renduService) {
        this.renduService = renduService;
    }

    @GetMapping
    public RenduDto ajouterRendu(@RequestBody RenduDto renduDto, @PathVariable Long idApprenant){
        return renduService.ajouterRendu(renduDto,idApprenant);
    }
}
