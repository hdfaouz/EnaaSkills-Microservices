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


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void testGetAllCompetences() {

        Competence competence1 = new Competence();
        competence1.setId(1L);
        competence1.setTitre("Java Programming");
        competence1.setStatutValidation(true);

        Competence competence2 = new Competence();
        competence2.setId(2L);
        competence2.setTitre("Python Programming");
        competence2.setStatutValidation(false);

        List<Competence> competences = Arrays.asList(competence1, competence2);

        CompetenceDto competenceDto1 = new CompetenceDto();
        competenceDto1.setTitre("Java Programming");
        competenceDto1.setStatutValidation(true);

        CompetenceDto competenceDto2 = new CompetenceDto();
        competenceDto2.setTitre("Python Programming");
        competenceDto2.setStatutValidation(false);

        List<CompetenceDto> expectedDtos = Arrays.asList(competenceDto1, competenceDto2);

        when(competenceRepository.findAll()).thenReturn(competences);
        when(competenceMap.toDTOs(competences)).thenReturn(expectedDtos);


        List<CompetenceDto> result = competenceService.getAllCompetences();


        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Java Programming", result.get(0).getTitre());
        assertEquals("Python Programming", result.get(1).getTitre());
        assertTrue(result.get(0).isStatutValidation());
        assertFalse(result.get(1).isStatutValidation());
    }

}
