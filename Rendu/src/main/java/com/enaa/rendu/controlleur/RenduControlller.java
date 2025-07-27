package com.enaa.rendu.controlleur;

import com.enaa.rendu.dto.Rendudto;
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
    public Rendudto ajouterRendu(@RequestBody Rendudto renduDto){
        return renduService.ajouterRendu(renduDto);
    }

    @GetMapping
    public List<Rendudto> getAll(){
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

}
