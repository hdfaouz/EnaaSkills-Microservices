package com.enaa.competence;

import com.enaa.competence.Dto.CompetenceDto;
import com.enaa.competence.Mappers.CompetenceMap;
import com.enaa.competence.Model.Competence;
import com.enaa.competence.Repository.CompetenceRepository;
import com.enaa.competence.Service.CompetenceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompetenceTest {

    @Mock
    private CompetenceRepository competenceRepository;

    @Mock
    private CompetenceMap competenceMap;

    @InjectMocks
    private CompetenceService competenceService;

    @Test
    void testAjouterCompetence() {

        CompetenceDto competenceDto = new CompetenceDto();
        competenceDto.setTitre("Java Programming");
        competenceDto.setStatutValidation(true);

        Competence competence = new Competence();
        competence.setTitre("Java Programming");
        competence.setStatutValidation(true);

        Competence savedCompetence = new Competence();
        savedCompetence.setId(1L);
        savedCompetence.setTitre("Java Programming");
        savedCompetence.setStatutValidation(true);

        CompetenceDto expectedDto = new CompetenceDto();
        expectedDto.setTitre("Java Programming");
        expectedDto.setStatutValidation(true);

        when(competenceMap.toEntity(competenceDto)).thenReturn(competence);
        when(competenceRepository.save(competence)).thenReturn(savedCompetence);
        when(competenceMap.toDTO(savedCompetence)).thenReturn(expectedDto);


        CompetenceDto result = competenceService.ajouterCompetence(competenceDto);


        assertNotNull(result);
        assertEquals(expectedDto.getTitre(), result.getTitre());
        assertEquals(expectedDto.isStatutValidation(), result.isStatutValidation());

    }

}
