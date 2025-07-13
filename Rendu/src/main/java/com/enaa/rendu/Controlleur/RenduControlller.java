package com.enaa.rendu.Controlleur;

import com.enaa.rendu.Dto.RenduDto;
import com.enaa.rendu.Service.RenduService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendu")
public class RenduControlller {

    private final RenduService  renduService;

    public RenduControlller(RenduService renduService) {
        this.renduService = renduService;
    }

   @PostMapping
    public RenduDto ajouterRendu(@RequestBody RenduDto renduDto){
        return renduService.ajouterRendu(renduDto);
    }

    @GetMapping
    public List<RenduDto> getAll(){
        return renduService.getAllRendu();
    }
}
