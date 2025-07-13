package com.enaa.competence;

import com.enaa.competence.Dto.SousCompetenceDto;
import com.enaa.competence.Mappers.SousCompetenceMapper;
import com.enaa.competence.Model.Competence;
import com.enaa.competence.Model.SousCompetence;
import com.enaa.competence.Model.Status;
import com.enaa.competence.Repository.CompetenceRepository;
import com.enaa.competence.Repository.SousComptenceRepository;
import com.enaa.competence.Service.SousCompetenceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SousCompetenceTest {

    @Mock
    private SousComptenceRepository sousComptenceRepository;

    @Mock
    private SousCompetenceMapper sousCompetenceMapper;

    @InjectMocks
    private SousCompetenceService sousCompetenceService;

    @Test
    void testAjouter() {

        SousCompetenceDto sousCompetenceDto = new SousCompetenceDto();
        sousCompetenceDto.setSousCompetenceNom("Algorithmes Java");
        sousCompetenceDto.setSousCompetenceStatus(Status.VALIDE);

        SousCompetence sousCompetence = new SousCompetence();
        sousCompetence.setSousCompetenceNom("Algorithmes Java");
        sousCompetence.setSousCompetenceStatus(Status.VALIDE);

        SousCompetence savedSousCompetence = new SousCompetence();
        savedSousCompetence.setSousCompetenceNom("Algorithmes Java");
        savedSousCompetence.setSousCompetenceStatus(Status.VALIDE);

        SousCompetenceDto expectedDto = new SousCompetenceDto();

        expectedDto.setSousCompetenceNom("Algorithmes Java");
        expectedDto.setSousCompetenceStatus(Status.VALIDE);

        when(sousCompetenceMapper.toEntity(sousCompetenceDto)).thenReturn(sousCompetence);
        when(sousComptenceRepository.save(sousCompetence)).thenReturn(savedSousCompetence);
        when(sousCompetenceMapper.toDto(savedSousCompetence)).thenReturn(expectedDto);


        SousCompetenceDto result = sousCompetenceService.ajouter(sousCompetenceDto);

        assertNotNull(result);
        assertEquals(expectedDto.getSousCompetenceNom(), result.getSousCompetenceNom());
        assertEquals(expectedDto.getSousCompetenceStatus(), result.getSousCompetenceStatus());

    }
}
