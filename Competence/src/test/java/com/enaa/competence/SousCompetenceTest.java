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

import java.util.Arrays;
import java.util.List;
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

    @Test
    void testGetAll() {

        SousCompetence sousCompetence1 = new SousCompetence();
        sousCompetence1.setSousCompetenceNom("Algorithmes Java");
        sousCompetence1.setSousCompetenceStatus(Status.VALIDE);

        SousCompetence sousCompetence2 = new SousCompetence();
        sousCompetence2.setSousCompetenceNom("Design Patterns");
        sousCompetence2.setSousCompetenceStatus(Status.VALIDE);

        List<SousCompetence> sousCompetences = Arrays.asList(sousCompetence1, sousCompetence2);

        SousCompetenceDto sousCompetenceDto1 = new SousCompetenceDto();
        sousCompetenceDto1.setSousCompetenceNom("Algorithmes Java");
        sousCompetenceDto1.setSousCompetenceStatus(Status.NON_VALIDE);

        SousCompetenceDto sousCompetenceDto2 = new SousCompetenceDto();
        sousCompetenceDto2.setSousCompetenceNom("Design Patterns");
        sousCompetenceDto2.setSousCompetenceStatus(Status.VALIDE);

        List<SousCompetenceDto> expectedDtos = Arrays.asList(sousCompetenceDto1, sousCompetenceDto2);

        when(sousComptenceRepository.findAll()).thenReturn(sousCompetences);
        when(sousCompetenceMapper.toDtos(sousCompetences)).thenReturn(expectedDtos);


        List<SousCompetenceDto> result = sousCompetenceService.getAll();


        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Algorithmes Java", result.get(0).getSousCompetenceNom());
        assertEquals("Design Patterns", result.get(1).getSousCompetenceNom());
        assertEquals(Status.NON_VALIDE, result.get(0).getSousCompetenceStatus());


    }
}
