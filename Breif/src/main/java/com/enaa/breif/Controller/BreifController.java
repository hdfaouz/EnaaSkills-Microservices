package com.enaa.breif.Controller;

import com.enaa.breif.Dto.BreifDto;
import com.enaa.breif.Service.BreifService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breif")
public class BreifController {

    private final BreifService breifService;

    public BreifController(BreifService breifService) {
        this.breifService = breifService;
    }

    @PostMapping
    public BreifDto ajouterBreif(@RequestBody BreifDto breifDto){
        return breifService.ajouterBreif(breifDto);
    }
    @GetMapping
    public List<BreifDto> getAll(){
        return breifService.getAll();
    }
}
