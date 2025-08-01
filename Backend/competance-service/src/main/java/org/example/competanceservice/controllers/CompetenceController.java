package org.example.competanceservice.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.example.competanceservice.dtos.CompetenceDTO;
import org.example.competanceservice.dtos.SubCompetenceDTO;
import org.example.competanceservice.entities.Competence;
import org.example.competanceservice.services.CompetenceService;
import org.example.competanceservice.services.ExcelServices;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/competence")
public class CompetenceController {
    private final CompetenceService service;
    private final ExcelServices excel;

    public CompetenceController(CompetenceService service, ExcelServices excel) {
        this.service = service;
        this.excel = excel;
    }

    @GetMapping("/getAll")
    public List<CompetenceDTO> getCompetenceList(){
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public CompetenceDTO getCompetenceById(@PathVariable Long id){
        return service.getCompetenceById(id);
    }

    @GetMapping("/getSubs/{id}")
    public List<SubCompetenceDTO> getSubCompetenceById(@PathVariable Long id){
        return service.getByCompetenceById(id);
    }

    @PostMapping("/add")
    public CompetenceDTO addCompetence(@RequestBody CompetenceDTO dto){
        return service.addCompetence(dto);
    }

    @PutMapping("/update/{id}")
    public CompetenceDTO updateCompetence(@PathVariable Long id, @RequestBody CompetenceDTO dto){
        return service.updateCompetence(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompetence(@PathVariable Long id){
        service.deleteCompetence(id);
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        // 1. Définir le type de contenu de la réponse
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        // 2. Créer un nom de fichier dynamique
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=rapportcompetences" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        // 3. Récupérer les données à exporter
        List<Competence> competences = service.getAll2();

        // 4. Appeler le service d'export
        excel.exportCompetencesToExcel(competences, response.getOutputStream());
    }
}
