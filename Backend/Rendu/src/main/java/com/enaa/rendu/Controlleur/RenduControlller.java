package com.enaa.rendu.Controlleur;

import com.enaa.rendu.Dto.BreifDto;
import com.enaa.rendu.Dto.RenduDto;
import com.enaa.rendu.Service.RenduService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController

public class RenduControlller {

    private final RenduService  renduService;

    public RenduControlller(RenduService renduService) {
        this.renduService = renduService;
    }

   @PostMapping("/add")
    public RenduDto ajouterRendu(@RequestBody RenduDto renduDto){
        return renduService.ajouterRendu(renduDto);
    }

    @GetMapping("/all")
    public List<RenduDto> getAll(){
        return renduService.getAllRendu();
    }

    @DeleteMapping("/{id}")
    public void deleteRendu(@PathVariable Long id){
        renduService.deleteRendu(id);
    }

    @GetMapping("/brief/{briefid}")
    public List<Long> getRenduIdsByBriefId(@PathVariable("briefid") Long briefid){
        return renduService.getRenduIdsByBriefId(briefid);
    }

    @GetMapping("")
    public List<BreifDto> getRenduByBreif(Date date1,Date date2){
        return renduService.getRenduByIdBreif(date1, date2);
    }

}
