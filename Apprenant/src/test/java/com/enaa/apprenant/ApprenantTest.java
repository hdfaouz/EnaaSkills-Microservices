package com.enaa.apprenant;

import com.enaa.apprenant.dto.ApprenantDto;
import com.enaa.apprenant.mappers.ApprenantMap;
import com.enaa.apprenant.model.Apprenant;
import com.enaa.apprenant.repositories.ApprenantRepository;
import com.enaa.apprenant.service.ApprenantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApprenantTest {
    @Mock
    private ApprenantRepository apprenantRepository;

    @Mock
    private ApprenantMap apprenantMap;

    @InjectMocks
    private ApprenantService apprenantService;

    @Test
    void ajouterApprenant() {
        // Données de test
        ApprenantDto apprenantDto = new ApprenantDto();
        apprenantDto.setNom("Dupont");
        apprenantDto.setPrenom("Jean");
        apprenantDto.setEmail("jean.dupont@email.com");

        Apprenant apprenant = new Apprenant();
        apprenant.setNom("Dupont");
        apprenant.setPrenom("Jean");
        apprenant.setEmail("jean.dupont@email.com");

        Apprenant savedApprenant = new Apprenant();
//        savedApprenant.setId(1L);
        savedApprenant.setNom("Dupont");
        savedApprenant.setPrenom("Jean");
        savedApprenant.setEmail("jean.dupont@email.com");

        ApprenantDto expectedDto = new ApprenantDto();

        expectedDto.setNom("Dupont");
        expectedDto.setPrenom("Jean");
        expectedDto.setEmail("jean.dupont@email.com");

        // Configuration des mocks
        when(apprenantMap.toEntity(apprenantDto)).thenReturn(apprenant);
        when(apprenantRepository.save(apprenant)).thenReturn(savedApprenant);
        when(apprenantMap.toDto(savedApprenant)).thenReturn(expectedDto);

        // Exécution
        ApprenantDto result = apprenantService.ajouterApprenant(apprenantDto);

        // Vérifications
        assertNotNull(result);
        assertEquals("Dupont", result.getNom());
        assertEquals("Jean", result.getPrenom());
        assertEquals("jean.dupont@email.com", result.getEmail());
    }
    @Test
    void getAllApprenants() {
        // Données de test
        Apprenant apprenant1 = new Apprenant();
//        apprenant1.setId(1L);
        apprenant1.setNom("Dupont");
        apprenant1.setPrenom("Jean");
        apprenant1.setEmail("jean.dupont@email.com");

        Apprenant apprenant2 = new Apprenant();
//        apprenant2.setId(2L);
        apprenant2.setNom("Martin");
        apprenant2.setPrenom("Marie");
        apprenant2.setEmail("marie.martin@email.com");

        List<Apprenant> apprenants = Arrays.asList(apprenant1, apprenant2);

        ApprenantDto dto1 = new ApprenantDto();
        dto1.setNom("Dupont");
        dto1.setPrenom("Jean");
        dto1.setEmail("jean.dupont@email.com");

        ApprenantDto dto2 = new ApprenantDto();
        dto2.setNom("Martin");
        dto2.setPrenom("Marie");
        dto2.setEmail("marie.martin@email.com");

        List<ApprenantDto> expectedDtos = Arrays.asList(dto1, dto2);

        // Configuration des mocks
        when(apprenantRepository.findAll()).thenReturn(apprenants);
        when(apprenantMap.toDtos(apprenants)).thenReturn(expectedDtos);

        // Exécution
        List<ApprenantDto> result = apprenantService.getAllApprenants();

        // Vérifications
        assertNotNull(result);
        assertEquals("Dupont", result.get(0).getNom());
        assertEquals("Jean", result.get(0).getPrenom());
        assertEquals("jean.dupont@email.com", result.get(0).getEmail());
        assertEquals("Martin", result.get(1).getNom());
        assertEquals("Marie", result.get(1).getPrenom());
        assertEquals("marie.martin@email.com", result.get(1).getEmail());
    }


}
